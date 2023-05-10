package com.i2f.springboot.test;

import com.i2f.springboot.entity.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 17:23 2023/1/18
 */
public class Test02 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
       /* int a =2,b=3;
        if(a != 2 && b != 3){
            System.out.println("结果为true");
        }
        Test02 test02 = new Test02();
        int math = test02.math(0, 0);
        System.out.println("结束"+math);*/
       ListNode l1 = new ListNode(-1);
       ListNode l2 = new ListNode(-1);
       ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(5);
       l1.next = head1;
       l2.next = head2;
        for (int i = 2; i < 5; i++) {
            head1.next = new ListNode(i);
            head1 = head1.next;
        }
        for (int i = 6; i < 10; i++) {
            head2.next = new ListNode(i);
            head2 = head2.next;
        }
        ListNode node = addTwoNumbers(l1.next, l2.next);
        System.out.println(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //链表反转
        ListNode pre1 = null;
        ListNode cur = l1;
        ListNode next;
        int i = 0;
        while(cur != null){
            next = cur.next;
            cur.next = pre1;
            pre1 = cur;
            cur = next;
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < i; k++) {
            builder.append(pre1.val);
            pre1 = pre1.next;
        }
        ListNode pre2 = null;
        cur = l2;
        int j = 0;
        while(cur != null){
            next = cur.next;
            cur.next = pre2;
            pre2 = cur;
            cur = next;
            j++;
        }
        StringBuilder builder1 = new StringBuilder();
        for (int k = 0; k < j; k++) {
            builder1.append(pre2.val);
            pre2 = pre2.next;
        }

        long ls1 = Long.parseLong(builder.toString());
        long ls2 = Long.parseLong(builder1.toString());
        String s = String.valueOf(ls1 + ls2);
        String[] chars = s.split("");
        IntStream intStream = Arrays.stream(chars).mapToInt(x -> Integer.parseInt(x));
        int[] ints = intStream.toArray();
        //int[] nums = new int[chars.length];
        ListNode damny = new ListNode(-1);
        ListNode node = damny;
        for (int i1 = 0; i1 < ints.length; i1++) {
           ListNode node1 = new ListNode(ints[i1]);
           node.next = node1;
           node = node.next;
        }
        return reverListNode(damny.next);
    }

    private static ListNode reverListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseNode(ListNode head){
        //使用栈的先进后出的特性来实现链表的反转
        Stack<ListNode> stack = new Stack<>();
        if(head == null) return null;
        while(head !=null){
            stack.push(head);
            head = head.next;
        }
        //创建一个新的node对象接受新的链表
        ListNode node_new = stack.pop();
        ListNode pre = node_new;
        //取出栈中的所有链表
        while (!stack.empty()){
            ListNode node = stack.pop();
            node_new.next = node;
            node_new = node_new.next;
        }
        //将最后一个node.next置为null,避免循环
        node_new.next = null;
        return pre; 
    }
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode cur = new ListNode(-1);
        ListNode pre = cur;
        while (list1!=null & list2!=null){
            if(list1.val<=list2.val){
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        if(list1!=null){
            cur.next = list1;
        }
        if(list2!=null){
            cur.next = list2;
        }
        return pre;
    }

}
