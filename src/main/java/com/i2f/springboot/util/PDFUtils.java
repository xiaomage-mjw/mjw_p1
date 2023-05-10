package com.i2f.springboot.util;

import com.i2f.springboot.entity.PersonInfo;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 9:22 2022/9/24
 */
public class PDFUtils {
    public static void readAndSetPdf(String pdfUrl,String newPDFUrl) throws IOException, DocumentException {
        //读取PDF表单
        PdfReader reader =null;
        PdfStamper stamper =null;
        OutputStream os = null;
        try{
            //读取PDF表单
            reader = new PdfReader(pdfUrl);
            os = new FileOutputStream(new File(newPDFUrl));
            //根据表单生成一个新的PDF文件
            stamper = new PdfStamper(reader,os);
            AcroFields form = stamper.getAcroFields();
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            PersonInfo info = new PersonInfo("马锦文","Java开发工程师","男","汉族","团员",
                    "未婚","陕西咸阳","上海市浦东新区海荣路3899弄","亚健康",
                    "18483639641","1834112850@qq.com","美女，篮球，健身");
            Field[] declaredFields = info.getClass().getDeclaredFields();
            form.addSubstitutionFont(bf);
            for (int i = 0; i < declaredFields.length; i++) {
                //首字母大写
                declaredFields[i].setAccessible(true);
                System.out.println(declaredFields[i].get(info));
                form.setField(declaredFields[i].getName(), (String)declaredFields[i].get(info));
            }
            stamper.setFormFlattening(true);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //释放资源
            stamper.close();
            reader.close();
            os.close();
        }
        HashMap map = new HashMap<>();
    }

    private static String toFirstUpper(String name) {
        char[] chars = name.toCharArray();
        if(chars[0]>='a' && chars[0]<='z'){
            chars[0] = (char)(chars[0] - 32);
        }
        return new String(chars);
    }
}
