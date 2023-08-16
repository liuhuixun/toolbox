package com.atguigu.springboot.dao;

import com.atguigu.springboot.entity.LyKyXtglDmkCl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 代码库常量表(LyKyXtglDmkCl)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-15 18:11:00
 */
@Mapper
public interface LyKyXtglDmkClMapper extends BaseMapper<LyKyXtglDmkCl> {

    int insertBatch(@Param("list") List<LyKyXtglDmkCl> entities);

}

