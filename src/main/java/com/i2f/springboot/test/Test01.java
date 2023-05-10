package com.i2f.springboot.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.i2f.springboot.entity.InterFace;
import com.i2f.springboot.entity.User;
import lombok.Synchronized;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 10:00 2022/12/31
 */
public class Test01 extends ClassLoader{
    /*
    * 1 一个小区里有n个居民，第一天有k个传染病感染者，感染者需要转运到医院隔离和治疗，该小区第一天的转运感染者的能力是p个人，
    * 第二天转运能力是p-1人，第三天转运能力是p-2人，以此类推。如果感染者当天没有转运出小区，则每一个感染者会在当天午夜12点感染1个人。
    * 请问这个小区需要多少天感染者能清零。用Java/JS/TS/C++语言实现求清零天数函数。
要求：
(1) 命名一个合适的函数名称，实现完整的函数
(2) 按照你平时的编程习惯，在你认为需要注释处写上相应的注释
(3) 代码行数尽可能少，代码运行复杂度尽可能小
(4) 写出你实现代码的算法复杂度o(n)
    **/
    public static void main(String[] args) throws InterruptedException, ParseException {
        User user = new User();
        user.setName("王小二");
        user.setDate("2022-03-03");
        String jsonStr = JSONUtil.toJsonStr(user);
        System.out.println(jsonStr);
        InterFace user1 = JSONUtil.toBean(jsonStr, InterFace.class);
        System.out.println(user1);
        String jsonStr1 = JSONUtil.toJsonStr(user1);
        JSONObject entries = JSONUtil.parseObj(jsonStr1);
        System.out.println(entries);
        Object ss = 5;
        System.out.println(ss.equals("5"));
        String str = "2023-02-22 11:24:04";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = formatter.parse(str);
        LocalDateTime localDateTime = DateUtil.toLocalDateTime(parse).plusDays(45);

        long between = LocalDateTimeUtil.between(LocalDateTime.now(), localDateTime, ChronoUnit.SECONDS);
        System.out.println(between);
    }
    public static String sock(){
        return IdUtil.fastSimpleUUID();
    }

    public static int[] FindNumsAppearOnce (int[] nums) {
        // write code here
        HashMap<Integer,Integer> map = new HashMap();
        int len = 0;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
                len++;
            }
        }
        Object[] objects =  map.entrySet().stream().filter((Map.Entry<Integer, Integer> entry) -> (entry.getValue() == 1)).map((Map.Entry<Integer, Integer> entry) -> entry.getKey()).toArray();
        int[] arr = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            arr[i] = (int)objects[i];
        }
        return arr;
    }


}
