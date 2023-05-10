package com.i2f.springboot.service.impl;

import com.i2f.springboot.config.Datasource;
import com.i2f.springboot.entity.PersonInfo;
import com.i2f.springboot.entity.User;
import com.i2f.springboot.service.PdfService;
import com.i2f.springboot.service.UserService;
import com.itextpdf.text.DocumentException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 22:43 2023/2/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PdfServiceImplTest {
    @Autowired
    private PdfService pdfService;
    @Autowired
    private UserService userService;

    @Test
    public void createpdf() throws IOException, DocumentException {
      /*  System.out.println("11111");
        User user = new User();
        //List<User> bySex = userService.get(0).findBySex(3);
//        userService.findBySex(23);
       // UserConfig userConfig = new UserConfig();
        User createpdf = pdfService.createpdf(new PersonInfo("马锦文", "Java开发工程师", "男", "汉族", "团员",
                "未婚", "陕西咸阳", "上海市浦东新区海荣路3899弄", "亚健康",
                "18483639641", "1834112850@qq.com", "美女，篮球，健身"));
        System.out.println(createpdf);*/
        Thread thread =  new Thread(() -> userService.updateSex(11, "物理1"));
        Thread thread1 = new Thread(() -> userService.updateSex(11, "物理2"));
        Thread thread2=  new Thread(() -> userService.updateSex(11, "物理3"));
        Thread thread3 = new Thread(() -> userService.updateSex(11, "物理4"));
        thread.start();
        thread1.start();
        ThreadLocal
        thread2.start();
        thread3.start();
    }

}