package com.sher.atmg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sher.atmg.constants.CommonConstants;
import com.sher.atmg.entity.WorksCategoryEntity;
import com.sher.atmg.entity.WorksEntity;
import com.sher.atmg.mapper.WorksCategoryMapper;
import com.sher.atmg.mapper.WorksMapper;
import com.sher.atmg.result.R;
import com.sher.atmg.service.WorksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 作品表
 *
 * @author ·SHER·
 */
@Service
@AllArgsConstructor
public class WorksServiceImpl extends ServiceImpl<WorksMapper, WorksEntity> implements WorksService {

	private final WorksMapper worksMapper;
	private final WorksCategoryMapper worksCategoryMapper;

	@Override
	public R getWorks(Page page, WorksEntity works) {
		//根据类别获取广告
		if (works.getCategoryId() == null){
			//没传类别查询全部
			return R.ok(this.page(page, Wrappers.<WorksEntity>lambdaQuery().orderByDesc(WorksEntity::getSort)));
		}
		WorksCategoryEntity worksCategoryEntity = worksCategoryMapper.selectById(works.getCategoryId());
		if (worksCategoryEntity == null){
			return R.failed("未找到该类别,请重试!");
		}
		LambdaQueryWrapper<WorksEntity> wrappers = Wrappers.lambdaQuery();
		if (Objects.equals(worksCategoryEntity.getParentId(), CommonConstants.PARENT_ROOT_ID)){
			//如果是父类 获取所有子类
			List<Long> categoryList = new ArrayList<>();
			//包括添加父类
			categoryList.add(worksCategoryEntity.getCategoryId());
			categoryList.addAll(worksCategoryMapper.selectList(Wrappers.<WorksCategoryEntity>lambdaQuery()
					.eq(WorksCategoryEntity::getParentId, worksCategoryEntity.getCategoryId()))
					.stream().map(WorksCategoryEntity::getCategoryId).toList());
			wrappers.in(WorksEntity::getCategoryId, categoryList);
		}else{
			//根据子类查询
			wrappers.eq(WorksEntity::getCategoryId, worksCategoryEntity.getCategoryId());
		}
		page = this.page(page, wrappers
				.orderByDesc(WorksEntity::getSort)
		);
		return R.ok(page);
	}
}