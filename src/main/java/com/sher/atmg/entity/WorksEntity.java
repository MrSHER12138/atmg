package com.sher.atmg.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 作品表
 *
 * @author ·SHER·
 */
@Data
@TableName("t_works")
@EqualsAndHashCode(callSuper = true)
public class WorksEntity extends Model<WorksEntity> {
 
	/**
	* worksId
	*/
    @TableId(type = IdType.ASSIGN_ID)
    private Long worksId;

	/**
	* categoryId
	*/
    private Long categoryId;

	/**
	 * 作品标题
	 */
	private String title;

	/**
	 * 作品内容
	 */
	private String content;

	/**
	 * 作品封面
	 */
	private String cover;

	/**
	 * 排序
	 */
	private Integer sort;

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