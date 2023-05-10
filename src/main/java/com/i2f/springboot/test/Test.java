package com.i2f.springboot.test;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 20:12 2022/9/20
 */
public class Test {
    /*public static void main(String[] args) {
       *//* String acdeaffdD = encode("acdeaffdD");
        System.out.println(acdeaffdD);*//*
        //main();
        int arr1[] = new int[]{1,3,5,44,21,8,11,7};
        String arr2[] = createStr();
        //将数组转换为list
        List<Integer> list = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<String> list1 = Arrays.asList(arr2);
        //集合排序
        //Collections.sort(list, (String s1, String s2)-> s1.compareTo(s2));
        list.sort((s1,s2)->s1.compareTo(s2));
        //list.stream().forEach(System.out::println);
       // Stream.of(list).forEach(System.out::println);
        //将Integer集合转换为String集合
        List<String> collect = list.stream().map(x -> String.valueOf(x)).collect(Collectors.toList());
        collect.sort(String::compareTo);
        int [] a = new int[]{-1,-2,-3,-4,-5};
        int[] ints = twoSum(a, -8);
        Arrays.stream(ints).forEach(System.out::println);
    }*/
    public static int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target && i!=j){
                    arr[0]=i;
                    arr[1]=j;
                    break;
                }
            }
        }
       /* List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        collect.stream().forEach((x,y)-> {if(==target)});*/
        return arr;
    }

    private static String[] createStr() {
        String arr[] = new String[5];
        Random r = new Random(2);
        for(int i = 0; i < 5; i++){
            int i1 = r.nextInt();
            arr[i] = String.valueOf(i1);
        }
        return arr;
    }

    public static String main() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd:HH:mm");
        String format = formatter.format(date);
        System.out.println(format);
        return  "";
    }
    static String encode(String word){
        word = word.toLowerCase();
        Stream<String> word1 = Stream.of(word);
        word1.sorted();
        String result = "";
        for (int i = 0; i < word.length() ; i++) {
            char c = word.charAt(i);
            result += word.indexOf(c) == word.lastIndexOf(c) ? "(" : ")";
        }
        return result;
    }

    public static void main(String[] args) {
        /*int anInt[] = {1,2,3,4,5};
        int[] ints = reverseaStack(anInt);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }*/
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] string = null;
        if(str.length() % 8 ==0){
            string = new String[str.length() / 8];
        }else {
            string = new String[str.length() / 8 + 1];
        }

        int len = 0;
        if(str.length() == 8){
            System.out.println(str);
            return;
        }else {
            for (int i = 0; i <= str.length() / 8; i++) {
                StringBuilder buffer = new StringBuilder();
                if (str.length() < 8) {
                    buffer.append(str);
                    for (int j = 0; j < 8 - str.length(); j++) {
                        buffer.append("0");
                    }
                    string[i] = buffer.toString();
                } else {
                    if (i == str.length() / 8 && str.substring(len).length() < 8 ) {
                        if( str.substring(len).length() ==0){
                            continue;
                        }
                        buffer.append(str.substring(len));
                        for (int j = 0; j < 8 - str.substring(len).length(); j++) {
                            buffer.append("0");
                        }
                        string[i] = buffer.toString();
                    } else {
                        string[i] = str.substring(len, (i + 1) * 8);
                    }
                    len = (i + 1) * 8;
                }
            }
        }
        Arrays.stream(string).forEach(System.out::println);
    }

    public static int[] reverseaStack (int[] sta) {
        int arry[] = new int[sta.length];
        int j=sta.length-1;
        for (int i = 0; i < sta.length; i++,j--) {
            if(j < 0){
                continue;
            }
            arry[j]=sta[i];
        }
        return arry;
    }

    public int[] solve (int n, int m, int[] a) {
        // write code here
        if(m==0 && (n == a.length)){
            return a;
        }
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            //判断移动长度
            if((i+m)%a.length >0){
                s = a[(i+m)%a.length];
                a[(i+m)%a.length] = a[i];

            }else{
                s = a[i+m];
                a[i+m] = a[i];
            }
        }
        return null;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        //pre指针：用来指向反转后的节点，初始化为null
        ListNode pre = null;
        //当前节点指针
        ListNode cur = head;
        //循环迭代
        while(cur!=null){
            //Cur_next 节点，永远指向当前节点cur的下一个节点
            ListNode Cur_next = cur.next;
            //反转的关键：当前的节点指向其前一个节点(注意这不是双向链表，没有前驱指针)
            cur.next = pre;
            //更新pre
            pre = cur;
            //更新当前节点指针
            cur = Cur_next ;
        }
        //为什么返回pre？因为pre是反转之后的头节点
        return pre;
    }
}
