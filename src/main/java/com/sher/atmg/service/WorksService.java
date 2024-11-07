package com.sher.atmg.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sher.atmg.entity.WorksEntity;
import com.sher.atmg.result.R;

public interface WorksService extends IService<WorksEntity> {

	/**
	 * 获取作品类别树
	 *
	 * @return
	 */
	R getWorks(Page page, WorksEntity works);
}