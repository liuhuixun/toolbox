/**
 * @author SargerasWang
 */
package ExcelUtil;

import com.atguigu.springboot.ExcelUtil.ExcelLogs;
import com.atguigu.springboot.ExcelUtil.ExcelUtil;
import com.atguigu.springboot.service.impl.LyKyXtglDmkClServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 测试导入Excel 97/2003
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestImportExcel {

  @Resource
  private LyKyXtglDmkClServiceImpl impl;

  @Test
  public void importXls() throws FileNotFoundException {
    File f=new File("src/test/resources/test.xls");
    InputStream inputStream= new FileInputStream(f);
    
    ExcelLogs logs =new ExcelLogs();
    Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs , 0);
    
    for(Map m : importExcel){
      System.out.println(m);
    }
  }

  @Test
  public void importXlsx() throws FileNotFoundException {
    List<String> list = new ArrayList<>();
    list.add("1");
    impl.deleteByMulti(list);

    File f=new File("C:\\Users\\admin\\Desktop\\1.xlsx");
    InputStream inputStream= new FileInputStream(f);

    ExcelLogs logs =new ExcelLogs();
    Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs , 0);

    for(Map m : importExcel){
      System.out.println(m);
    }

  }

}
