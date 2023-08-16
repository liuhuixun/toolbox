package com.atguigu.springboot;

import com.atguigu.springboot.ExcelUtil.ExcelLogs;
import com.atguigu.springboot.ExcelUtil.ExcelUtil;
import com.atguigu.springboot.entity.LyKyXtglDmkCl;
import com.atguigu.springboot.service.LyKyXtglDmkClService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@SpringBootTest
public class SpringBoot01HelloworldQuickApplicationTests {

    @Resource
    private LyKyXtglDmkClService service;


    @Test
    public void contextLoads() throws FileNotFoundException {
    }

    @Test
    public void test1() throws FileNotFoundException {

        File f = new File("C:\\Users\\admin\\Desktop\\1.xlsx");
        InputStream inputStream = new FileInputStream(f);

        ExcelLogs logs = new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, 0);
        List<LyKyXtglDmkCl> entities = new ArrayList<>(importExcel.size());
        int index = 1;

        for (Map m : importExcel) {
//            System.out.println(m);
            LyKyXtglDmkCl entity = new LyKyXtglDmkCl();
            entity.setFlid("0381b170-ea90-4ea7-98a9-00c1a2f25e43");
            entity.setDm(m.get("代码") + "");
            entity.setMc(m.get("学科分类") + "");
            entity.setJc(m.get("学科分类") + "");
            entity.setPxh(index++);
            entity.setZt("1");
            entity.setDmbz("1");
            entities.add(entity);
//            System.out.println(entity);
        }

//        if(entities.size() > 0){
//            service.insertBatch(entities);
//        }
    }

    @Test
    public void test2() throws FileNotFoundException {

        File file = new File("C:\\Users\\admin\\Desktop\\社会经济服务目标.xlsx");
        InputStream inputStream = new FileInputStream(file);

        ExcelLogs logs = new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, 0);
        List<LyKyXtglDmkCl> entities = new ArrayList<>(importExcel.size());
        int index = 1;

        // Iterate over each row in the imported Excel data
        for (Map row : importExcel) {
            String dm = row.get("代码") + "";

            // Skip rows where the length of "dm" is greater than 4
            if (dm.length() > 4) {
                continue;
            }

            // Create a new entity and set its properties
            LyKyXtglDmkCl entity = new LyKyXtglDmkCl();
            entity.setFlid("f4625ce4-3461-497d-aac1-5639f09bca95");
            entity.setDm(dm);
            entity.setMc(row.get("分类名称") + "");
            entity.setJc(row.get("分类名称") + "");

            // Set the "fdm" property based on the first two characters of "dm"
            if (dm.length() > 2) {
                entity.setFdm(dm.substring(0, 2));
            }

            entity.setPxh(index++);
            entity.setZt("1");
            entity.setDmbz("1");

            // Add the entity to the list
            entities.add(entity);

            // Print the entity
            System.out.println(entity);

        }

        // Insert the entities
//        if (entities.size() > 0) {
//            service.insertBatch(entities);
//        }

    }

    @Test
    public void test3() throws FileNotFoundException {

        File f = new File("C:\\Users\\admin\\Desktop\\国民经济行业分类.xlsx");
        InputStream inputStream = new FileInputStream(f);

        ExcelLogs logs = new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, 0);

        for (Map m : importExcel) {
            System.out.println(m);
        }
    }

}
