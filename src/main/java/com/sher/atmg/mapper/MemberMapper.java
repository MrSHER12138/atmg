package com.sher.atmg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sher.atmg.entity.MemberEntity;
import com.sher.atmg.result.MemberWorksResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper extends BaseMapper<MemberEntity> {

    List<MemberWorksResult> getMemberWorks(Long memberId);
}