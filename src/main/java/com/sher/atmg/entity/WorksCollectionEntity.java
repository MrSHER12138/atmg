package com.sher.atmg.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 作品集表
 *
 * @author ·SHER·
 */
@Data
@TableName("t_works_collection")
@EqualsAndHashCode(callSuper = true)
public class WorksCollectionEntity extends Model<WorksCollectionEntity> {
 
	/**
	* categoryId
	*/
    @TableId(type = IdType.ASSIGN_ID)
    private Long collection_id;

	/**
	* worksId
	*/
    private Long worksId;

	/**
	 * 作品集类型(视频,图片)
	 */
	private String worksCollectionType;

	/**
	 * 作品集
	 */
	private String worksCollection;

	/**
	 * 删除标志
	 */
	@TableLogic
	private String delFlag;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
}