package com.sher.atmg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sher.atmg.entity.MemberEntity;
import com.sher.atmg.result.R;

public interface MemberService extends IService<MemberEntity> {

    /**
     * 获取成员作品
     */
    R getMemberWorks(Long memberId);
}