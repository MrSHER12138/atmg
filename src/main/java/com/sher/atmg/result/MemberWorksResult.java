package com.sher.atmg.result;

import com.sher.atmg.entity.MemberEntity;
import com.sher.atmg.entity.WorksEntity;
import lombok.Data;

import java.util.List;

@Data
public class MemberWorksResult extends MemberEntity {

    /**
     * 作品标题
     */
    private String title;
    /**
     * 作品id
     */
    private Long worksId;
    /**
     * 作品内容
     */
    private String content;
    /**
     * 作品封面
     */
    private String cover;
    /**
     * 作品数
     */
    private Integer worksCount;
    /**
     * 作品集合
     */
    private List<WorksEntity> worksList;
}
