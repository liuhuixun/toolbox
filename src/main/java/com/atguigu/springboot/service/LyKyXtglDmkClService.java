package com.atguigu.springboot.service;


import com.atguigu.springboot.entity.LyKyXtglDmkCl;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 代码库常量表(LyKyXtglDmkCl)表服务接口
 *
 * @author makejava
 * @since 2023-08-15 18:11:00
 */
public interface LyKyXtglDmkClService extends IService<LyKyXtglDmkCl> {

    Boolean insert(LyKyXtglDmkCl lyKyXtglDmkCl);

    Boolean insertBatch(List<LyKyXtglDmkCl> entities);

    Boolean update(LyKyXtglDmkCl lyKyXtglDmkCl);

    Boolean deleteByMulti(List<String> ids);

}
