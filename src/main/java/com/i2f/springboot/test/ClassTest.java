package com.i2f.springboot.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.i2f.springboot.entity.PersonInfo;
import com.i2f.springboot.entity.User;
import com.i2f.springboot.service.impl.PdfServiceImpl;
import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 14:04 2022/12/13
 */

public class ClassTest {
    @AllArgsConstructor
    @Data
    static class Person{
        private String name;
        private Integer age;
        /*private void setAge(Integer age){
            this.age = age;
        }
        private Integer getAge(){
            return age;
        }
        private void setName(String name){
            this.name = name;
        }
        private String getName(){
            return name;
        }*/
    }

    static class c{
        static String s = "内部类静态变量";
        String ss = "sa";
        c(){
            System.out.println("c对象被实例化");
        }
        private void tes(){}
    }
    public static void main(String[] args) throws IOException, DocumentException {
        Person person = new Person("小马",22);
        Person person1 = new Person("小王",null);
        Person person2 = new Person("小张",27);
        Person person3 = new Person("小徐",29);
        Person person4 = new Person("小黄",null);
        String a = "从从";
        ArrayList<Person> list = new ArrayList();
        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        ArrayList<String> list1 = new ArrayList();
        list1.add("小王");
        list1.add("23");
        list1.add("小徐");
        list1.add("31");
        list1.add("小黄");
        ArrayList<String> list2 = new ArrayList();
        list2.add("小王");
        list2.add("23");
        list2.add("小徐");
        Collection<String> intersection = CollectionUtil.intersection(list1,null);
        List<String> collect = intersection.stream().collect(Collectors.toList());
        System.out.println(CollectionUtil.isNotEmpty(intersection));
        //找出年龄大于22的人的名字，并返回
        List collect2 = list.stream().filter(x -> ObjectUtil.isNotEmpty(x.getAge()) && x.getAge() >22).map(Person::getAge).collect(Collectors.toList());
       collect2.forEach(System.out::println);
       Integer s = 6;
        System.out.println(ObjectUtil.isEmpty(s));
        Integer m = 6;
        boolean r = ObjectUtil.equal(s, m);
        String sm= null;
     //   BigDecimal bigDecimal = new BigDecimal(sm);
        System.out.println(r);
       // System.out.println(isPalindrome(-121));
        PdfServiceImpl pdfService = new PdfServiceImpl();
        User createpdf = pdfService.createpdf(new PersonInfo("马锦文", "Java开发工程师", "男", "汉族", "团员",
                "未婚", "陕西咸阳", "上海市浦东新区海荣路3899弄", "亚健康",
                "18483639641", "1834112850@qq.com", "美女，篮球，健身"));
        System.out.println(createpdf);
       /* List<String> collect = null;
        collect.forEach(System.out::println);
        String str = null;
        String s1 = "";
        System.out.println(StringUtils.isNotEmpty(str)+"======"+StringUtils.isNotEmpty(s1));
        Collection<String> intersection = CollectionUtil.intersection(list1, collect);
        List<String> collect1 = intersection.stream().collect(Collectors.toList());
        collect1.forEach(System.out::println);*/

        /*BigDecimal bigDecimal = new BigDecimal((char[]) null);
        BigDecimal divide = bigDecimal.divide(new BigDecimal(100));
        System.out.println(divint s = ;
        System.out.println(s);
       /* list.stream().map(x-> {x.setAge(23);return x;}).forEach(System.out::println);
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> reduce = integerStream.reduce( (x, y) -> x+y);
        System.out.println(reduce.get());
        System.out.println(1+2+3+4+5);*/
        /*Optional<Integer> reduce1 = integerStream.reduce((x, y) -> x > y ? x : y);
        System.out.println(reduce1.get());*/
        /*BigDecimal bigDecimal = new BigDecimal("0.000000");
        BigDecimal zero = BigDecimal.ZERO;
        System.out.println(bigDecimal+"===="+zero);
        System.out.println(bigDecimal.compareTo(zero));
        Integer s =0;
        int ss=0;
        System.out.println(s==ss);*/
    }

    public static boolean isPalindrome(int x) {
        //转换为String
        String s =  String.valueOf(x);
        int len = s.length();
        boolean flag = len%2 == 0 ? true : false;
        if(flag){//偶数
            String m = s.substring(0,len/2);
            String p = s.substring(len/2,len);
            p = new StringBuilder(p).reverse().toString();
            return m.equals(p) ? true : false;
        }else{
            String m = s.substring(0,len/2);
            String p = s.substring(len/2+1,len);
            p = new StringBuilder(p).reverse().toString();
            return m.equals(p) ? true : false;
        }
    }
}
