package com.sher.atmg.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sher.atmg.entity.MemberEntity;
import com.sher.atmg.entity.WorksCollectionEntity;
import com.sher.atmg.entity.WorksEntity;
import com.sher.atmg.result.R;
import com.sher.atmg.service.MemberService;
import com.sher.atmg.service.WorksCollectionService;
import com.sher.atmg.service.WorksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 团队成员表
 *
 * @author ·SHER·
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/member" )
@CrossOrigin(origins = "*")
public class MemberController {

	private final MemberService memberService;

	/**
	 * 获取团队成员信息
	 */
	@GetMapping("/getMember")
	public R getMember(MemberEntity member) {
		return R.ok(memberService.list(Wrappers.<MemberEntity>lambdaQuery()
				.eq(StrUtil.isNotEmpty(member.getType()), MemberEntity::getType, member.getType())
				.orderByAsc(MemberEntity::getSort)
		));
	}

	/**
	 * 获取成员作品
	 */
	@GetMapping("/getMemberWorks")
	public R getMemberWorks(Long memberId) {
		return memberService.getMemberWorks(memberId);
	}
}