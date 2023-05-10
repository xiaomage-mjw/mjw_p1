package com.i2f.springboot.test;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 13:56 2023/3/29
 */
public class Testified {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }).start();
        }
    }
}
