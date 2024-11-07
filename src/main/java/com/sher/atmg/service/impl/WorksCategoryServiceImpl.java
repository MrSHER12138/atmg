package com.sher.atmg.service.impl;

import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sher.atmg.constants.CommonConstants;
import com.sher.atmg.entity.WorksCategoryEntity;
import com.sher.atmg.mapper.WorksCategoryMapper;
import com.sher.atmg.result.R;
import com.sher.atmg.service.WorksCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 作品类别表
 *
 * @author ·SHER·
 */
@Service
@AllArgsConstructor
public class WorksCategoryServiceImpl extends ServiceImpl<WorksCategoryMapper, WorksCategoryEntity> implements WorksCategoryService {

	private final WorksCategoryMapper worksCategoryMapper;

	@Override
	public R tree() {
		List<TreeNode<Long>> collect = this.list()
				.stream()
				.map(getNodeFunction())
				.collect(Collectors.toList());
		return R.ok(TreeUtil.build(collect, CommonConstants.PARENT_ROOT_ID));
	}

	private Function<WorksCategoryEntity, TreeNode<Long>> getNodeFunction() {
		return worksCategory -> {
			TreeNode<Long> node = new TreeNode<>();
			node.setId(worksCategory.getCategoryId());
			node.setName(worksCategory.getCategoryName());
			node.setParentId(worksCategory.getParentId());
			node.setWeight(worksCategory.getSort());
			// 扩展属性
			Map<String, Object> extra = new HashMap<>();
			extra.put("description", worksCategory.getDescription());
			node.setExtra(extra);
			return node;
		};
	}
}