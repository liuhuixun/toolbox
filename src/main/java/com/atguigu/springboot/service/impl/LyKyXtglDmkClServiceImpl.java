package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.dao.LyKyXtglDmkClMapper;
import com.atguigu.springboot.entity.LyKyXtglDmkCl;
import com.atguigu.springboot.service.LyKyXtglDmkClService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 代码库常量表(LyKyXtglDmkCl)表服务实现类
 *
 * @author makejava
 * @since 2023-08-15 18:11:00
 */
@Service
public class LyKyXtglDmkClServiceImpl extends ServiceImpl<LyKyXtglDmkClMapper,LyKyXtglDmkCl> implements LyKyXtglDmkClService {

    @Resource
    private LyKyXtglDmkClMapper lyKyXtglDmkClMapper;

    @Override
    public Boolean insert(LyKyXtglDmkCl lyKyXtglDmkCl) {
    
        return lyKyXtglDmkClMapper.insert(lyKyXtglDmkCl) > 0;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean insertBatch(List<LyKyXtglDmkCl> entities) {

        return lyKyXtglDmkClMapper.insertBatch(entities) > 0;

    }


    @Override
    public Boolean update(LyKyXtglDmkCl lyKyXtglDmkCl) {

        return lyKyXtglDmkClMapper.updateById(lyKyXtglDmkCl) > 0;

    }


    @Override
    public Boolean deleteByMulti(List<String> ids) {
    
         return lyKyXtglDmkClMapper.deleteBatchIds(ids) > 0;
        
    }
    
}
