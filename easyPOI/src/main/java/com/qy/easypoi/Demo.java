package com.qy.easypoi;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.qy.easypoi.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.context.annotation.Import;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author QianSiWang
 * @Date 2022/8/8 18:18
 * @Description
 */
public class Demo {
    public List<User> getUser(){
        List<User> users = new ArrayList<User>();
        for(int i = 0 ;i< 5;i++){

            users.add(new User("钱思惘"+i,i,"踢足球"+i));
        }
        return users;
    }

    /**
     * 导出测试
     * @throws IOException
     */
    @Test
    public void testExport() throws IOException {
        List<User> user = getUser();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, "用户信息sheet"), User.class, user);
        FileOutputStream fileOutputStream = new FileOutputStream("E://user.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
    }

    /**
     * 导入测试
     */
    @Test
    public void testImport() throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(1);
        List<User> objects = ExcelImportUtil.importExcel(new FileInputStream("E://user.xls"), User.class, importParams);
        objects.forEach(System.out::println);
    }
}
