package com.i2f.springboot.service;

import com.i2f.springboot.entity.PersonInfo;
import com.i2f.springboot.entity.User;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 8:57 2022/9/24
 */
public interface PdfService {
    /**
    * description: 生成PDF文件
    **/
   User createpdf(PersonInfo info) throws IOException, DocumentException;
}
