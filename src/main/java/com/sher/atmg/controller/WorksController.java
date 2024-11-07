package com.sher.atmg.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sher.atmg.entity.WorksCollectionEntity;
import com.sher.atmg.entity.WorksEntity;
import com.sher.atmg.result.R;
import com.sher.atmg.service.WorksCollectionService;
import com.sher.atmg.service.WorksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作品表
 *
 * @author ·SHER·
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/works" )
@CrossOrigin(origins = "*")
public class WorksController {

	private final WorksService worksService;
	private final WorksCollectionService worksCollectionService;

	/**
	 * 获取作品
	 */
	@GetMapping("/getWorks")
	public R getWorks(Page page, WorksEntity works) {
		return worksService.getWorks(page, works);
	}


	/**
	 * 获取作品集
	 */
	@GetMapping("/getWorksCollection")
	public R getWorks(Long worksId) {
		return R.ok(worksCollectionService.list(Wrappers.<WorksCollectionEntity>lambdaQuery().eq(WorksCollectionEntity::getWorksId, worksId)));
	}
}