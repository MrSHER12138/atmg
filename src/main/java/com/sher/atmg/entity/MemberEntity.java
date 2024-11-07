package com.sher.atmg.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 团队成员表
 *
 * @author ·SHER·
 */
@Data
@TableName("t_member")
@EqualsAndHashCode(callSuper = true)
public class MemberEntity extends Model<MemberEntity> {
 
	/**
	* memberId
	*/
    @TableId(type = IdType.ASSIGN_ID)
    private Long memberId;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 照片
	 */
	private String photo;

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