package com.sher.atmg.controller;


import com.sher.atmg.result.R;
import com.sher.atmg.service.WorksCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作品类别表
 *
 * @author ·SHER·
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/worksCategory" )
@CrossOrigin(origins = "*")
public class WorksCategoryController {

	private final WorksCategoryService worksCategoryService;

	/**
	 * 获取作品类别树
	 */
	@GetMapping("/tree")
	public R tree() {
		return worksCategoryService.tree();
	}
}