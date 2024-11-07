package com.sher.atmg.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sher.atmg.entity.MemberEntity;
import com.sher.atmg.entity.WorksEntity;
import com.sher.atmg.mapper.MemberMapper;
import com.sher.atmg.mapper.WorksMapper;
import com.sher.atmg.result.MemberWorksResult;
import com.sher.atmg.result.R;
import com.sher.atmg.service.MemberService;
import com.sher.atmg.service.WorksService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 团队成员表
 *
 * @author ·SHER·
 */
@Service
@AllArgsConstructor
@Slf4j
public class MemberServiceImpl extends ServiceImpl<MemberMapper, MemberEntity> implements MemberService {

    private final MemberMapper memberMapper;
    private final WorksMapper worksMapper;

    @Override
    public R getMemberWorks(Long memberId) {
        List<MemberWorksResult> memberWorksList = memberMapper.getMemberWorks(memberId);
        if (memberWorksList == null || memberWorksList.isEmpty()){
            return R.failed("为获取到团队成员作品!");
        }
        MemberWorksResult memberWorksResult = new MemberWorksResult();
        memberWorksResult.setMemberId(memberWorksList.get(0).getMemberId());
        memberWorksResult.setName(memberWorksList.get(0).getName());
        memberWorksResult.setPhoto(memberWorksList.get(0).getPhoto());

        List<WorksEntity> worksList = new ArrayList<>();
        for (MemberWorksResult memberWorks : memberWorksList) {
            WorksEntity works = new WorksEntity();
            BeanUtil.copyProperties(memberWorks, works);
            worksList.add(works);
        }
        memberWorksResult.setWorksList(worksList);
        return R.ok(memberWorksResult);
    }
}