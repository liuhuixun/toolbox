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
//            System.out.println(entity);

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

        List<LyKyXtglDmkCl> bigEntities = new ArrayList<>();
        List<LyKyXtglDmkCl> middleEntities = new ArrayList<>();
        List<LyKyXtglDmkCl> smallEntities = new ArrayList<>();

        String bigFlid = "d1dab0d4-a80d-4451-9552-0daa160abdad";
        String middleFlid = "74086358-b2b9-4b46-9b1b-707738ac30d6";
        String smallFlid = "93ac39a0-7448-4fde-99f0-511da89dc7e3";

        int bigIndex = 1;
        int middleIndex = 1;
        int smallIndex = 1;

        String bigSign = "BIG_NATIONAL_ECONOMY";
        String middleSign = "MEDIUM_NATIONAL_ECONOMY";
        String smallSign = "SMALL_NATIONAL_ECONOMY";

        for (Map m : importExcel) {

            String big = (m.get("大类 ") + "").trim();
            String middle = (m.get("中类 ") + "").trim();
            String small = (m.get("小类 ") + "").trim();
            String name = (m.get("类 别 名 称 ") + "").trim();

            if (!big.isEmpty()) {
                LyKyXtglDmkCl entity = new LyKyXtglDmkCl();
                entity.setFlid(bigFlid);
                entity.setDm(big);
                entity.setMc(name);
                entity.setJc(name);
                entity.setPxh(bigIndex++);
                entity.setZt("1");
                entity.setDmbz(bigSign);

                bigEntities.add(entity);

                continue;
            }

            if (!middle.isEmpty() && !small.isEmpty()) {
                LyKyXtglDmkCl middleEntity = new LyKyXtglDmkCl();
                middleEntity.setFlid(middleFlid);
                middleEntity.setDm(middle);
                middleEntity.setMc(name);
                middleEntity.setJc(name);
                middleEntity.setFdm(middle.substring(0, middle.length() - 1));
                middleEntity.setPxh(middleIndex++);
                middleEntity.setZt("1");
                middleEntity.setDmbz(middleSign);

                middleEntities.add(middleEntity);

                LyKyXtglDmkCl smallEntity = new LyKyXtglDmkCl();
                smallEntity.setFlid(smallFlid);
                smallEntity.setDm(small);
                smallEntity.setMc(name);
                smallEntity.setJc(name);
                smallEntity.setFdm(small.substring(0, small.length() - 1));
                smallEntity.setPxh(smallIndex++);
                smallEntity.setZt("1");
                smallEntity.setDmbz(smallSign);

                smallEntities.add(smallEntity);

                continue;
            }

            if (!middle.isEmpty()) {
                LyKyXtglDmkCl middleEntity = new LyKyXtglDmkCl();
                middleEntity.setFlid(middleFlid);
                middleEntity.setDm(middle);
                middleEntity.setMc(name);
                middleEntity.setJc(name);
                middleEntity.setFdm(middle.substring(0, middle.length() - 1));
                middleEntity.setPxh(middleIndex++);
                middleEntity.setZt("1");
                middleEntity.setDmbz(middleSign);

                middleEntities.add(middleEntity);

                continue;
            }

            if (!small.isEmpty()) {

                LyKyXtglDmkCl smallEntity = new LyKyXtglDmkCl();
                smallEntity.setFlid(smallFlid);
                smallEntity.setDm(small);
                smallEntity.setMc(name);
                smallEntity.setJc(name);
                smallEntity.setFdm(small.substring(0, small.length() - 1));
                smallEntity.setPxh(smallIndex++);
                smallEntity.setZt("1");
                smallEntity.setDmbz(smallSign);

                smallEntities.add(smallEntity);

            }
//            System.out.println(big + "," + middle + "," + small + "," + name);
        }


//        service.insertBatch(bigEntities);
//        service.insertBatch(middleEntities);
        List<List<LyKyXtglDmkCl>> lists = splitCollection(smallEntities, 300);
        for (List<LyKyXtglDmkCl> list : lists) {
            System.out.println(list);
//            service.insertBatch(list);
        }


//        System.out.println(bigEntities);
//        System.out.println(middleEntities);
//        System.out.println(smallEntities);

    }

    public static <T> List<List<T>> splitCollection(List<T> collection, int chunkSize) {
        int length = collection.size();
        int numOfChunks = (int) Math.ceil((double) length / chunkSize);

        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i < numOfChunks; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, length);
            result.add(collection.subList(start, end));
        }

        return result;
    }

    @Test
    public void test4() throws FileNotFoundException {

        File f = new File("C:\\Users\\admin\\Desktop\\代码集副本.xls");
        InputStream inputStream = new FileInputStream(f);

        ExcelLogs logs = new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, 0);
        List<LyKyXtglDmkCl> firstEntities = new ArrayList<>();
        List<LyKyXtglDmkCl> secondEntities = new ArrayList<>();
        String firstFlid = "2f6de6bf42684b0b817adeb4c959c071";
        String secondFlid = "ee1abf0a053b445fb2c720ade9866810";
        String firstSign = "RESEARCH_TITLE_FIRST_LEVEL";
        String secondSign = "RESEARCH_TITLE_SECOND_LEVEL";
        System.out.println("一共有" + importExcel.size() + "条数据");
        int firstIndex = 1;
        int secondIndex = 1;

        for (Map m : importExcel) {
//            System.out.println(m);
            LyKyXtglDmkCl entity = new LyKyXtglDmkCl();
            entity.setDm(m.get("代码") + "");
            entity.setMc(m.get("名称") + "");
            entity.setJc(m.get("名称") + "");
            entity.setZt("1");

            String fdm = m.get("父级节点ID") + "";
            if ("无".equals(fdm)) {
                entity.setDmbz(firstSign);
                entity.setFlid(firstFlid);
                entity.setPxh(firstIndex++);
                firstEntities.add(entity);
            } else {
                entity.setFdm(fdm);
                entity.setFlid(secondFlid);
                entity.setDmbz(secondSign);
                entity.setPxh(secondIndex++);
                secondEntities.add(entity);
            }
//            System.out.println(entity);
        }

        System.out.println("一级一共有" + firstEntities.size() + "条数据");
        System.out.println("二级一共有" + secondEntities.size() + "条数据");
        System.out.println("一级最大排序号" + firstIndex);
        System.out.println("二级最大排序号" + secondIndex);

//        if(firstEntities.size() > 0){
//            service.insertBatch(firstEntities);
//        }
//        if(secondEntities.size() > 0){
//            service.insertBatch(secondEntities);
//        }
    }

}
