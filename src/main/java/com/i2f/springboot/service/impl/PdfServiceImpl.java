package com.i2f.springboot.service.impl;

import com.i2f.springboot.entity.PersonInfo;
import com.i2f.springboot.entity.User;
import com.i2f.springboot.service.PdfService;
import com.i2f.springboot.util.PDFUtils;
import com.itextpdf.text.DocumentException;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 9:00 2022/9/24
 */
@Service
public class PdfServiceImpl implements PdfService {
    private final String pdfUrl = "D:/home/个人简历模板.pdf";
    private final String newPDFUrl = "D:/home/mjw_resume.pdf";
    @Override
    public User createpdf(PersonInfo personInfo) throws IOException, DocumentException {
        PDFUtils.readAndSetPdf(pdfUrl,newPDFUrl);
        return new User("mhw","99");
    }
}
