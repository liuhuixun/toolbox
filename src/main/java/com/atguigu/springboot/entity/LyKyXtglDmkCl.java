package com.atguigu.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;

/**
 * 代码库常量表(LyKyXtglDmkCl)实体类
 *
 * @author makejava
 * @since 2023-08-15 18:11:00
 */
@Data
@TableName(value = "LY_KY_XTGL_DMK_CL")
public class LyKyXtglDmkCl implements Serializable {
    private static final long serialVersionUID = 312268191232733603L;
    /**
     * 主键
     */
    @TableId(value = "PkID")
    private String pkid;
    /**
     * 分类ID，关联代码库分类表的PKID
     */
    @TableField(value = "flid", jdbcType = JdbcType.VARCHAR)
    private String flid;
    /**
     * 代码
     */
    @TableField(value = "dm", jdbcType = JdbcType.VARCHAR)
    private String dm;
    /**
     * 名称
     */
    @TableField(value = "mc", jdbcType = JdbcType.VARCHAR)
    private String mc;
    /**
     * 简称/别名
     */
    @TableField(value = "jc", jdbcType = JdbcType.VARCHAR)
    private String jc;
    /**
     * 父代码
     */
    @TableField(value = "fdm", jdbcType = JdbcType.VARCHAR)
    private String fdm;
    /**
     * 排序号
     */
    @TableField(value = "pxh", jdbcType = JdbcType.INTEGER)
    private Integer pxh;
    /**
     * 状态，1启用，0禁用
     */
    @TableField(value = "zt", jdbcType = JdbcType.VARCHAR)
    private String zt;
    /**
     * 代码标志
     */
    @TableField(value = "dmbz", jdbcType = JdbcType.VARCHAR)
    private String dmbz;

}

