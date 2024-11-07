package com.sher.atmg.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 作品类别表
 *
 * @author ·SHER·
 */
@Data
@TableName("t_works_category")
@EqualsAndHashCode(callSuper = true)
public class WorksCategoryEntity extends Model<WorksCategoryEntity> {
 
	/**
	* categoryId
	*/
    @TableId(type = IdType.ASSIGN_ID)
    private Long categoryId;

	/**
	* parentId
	*/
    private Long parentId;

	/**
	 * 类别名
	 */
	private String categoryName;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 描述
	 */
	private String description;

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