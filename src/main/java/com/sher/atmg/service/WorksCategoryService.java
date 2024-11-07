package com.sher.atmg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sher.atmg.entity.WorksCategoryEntity;
import com.sher.atmg.result.R;

public interface WorksCategoryService extends IService<WorksCategoryEntity> {

	/**
	 * 获取作品类别树
	 * @return
	 */
	R tree();

}