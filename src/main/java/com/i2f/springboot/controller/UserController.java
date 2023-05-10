package com.i2f.springboot.controller;

import com.i2f.springboot.common.Constant;
import com.i2f.springboot.common.ResultModel;
import com.i2f.springboot.entity.PersonInfo;
import com.i2f.springboot.entity.User;
import com.i2f.springboot.service.PdfService;
import com.i2f.springboot.service.UserService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 14:24 2022/6/7
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PdfService pdfService;
    @RequestMapping("toUserPage")
    public String toUser(@RequestBody String name){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User("张三"+i,String.valueOf(i));
            list.add(user);
        }

        List<User> users = userService.findBySex(110);
        //model.addAttribute("users",list);
        return "welcome";
    }
    @RequestMapping("login")
    public void userLogin(String name,String password){
        System.out.println(Thread.currentThread().getName()+"controller方法调用结束");
        userService.doLogin(name,password);
    }

    @RequestMapping("personResumePDF")
    public ResultModel personResumePDF(PersonInfo personInfo) throws IOException, DocumentException {
        if(Constant.SUCCESS.equals("000")){
            return new ResultModel(Constant.SUCCESS,"pdf生成成功", null);
        }else{
            return new ResultModel(Constant.PDF_CREATE_FAILED,"pdf生成失败", null);
        }
    }

}
