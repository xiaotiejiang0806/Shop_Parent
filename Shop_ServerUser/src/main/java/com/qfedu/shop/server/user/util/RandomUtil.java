package com.qfedu.shop.server.user.util;

import java.util.Random;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 19:55 2019/6/15
 */
public class RandomUtil {

    public static  int creatScore(int start,int end){
        Random random = new Random();
        return random.nextInt((end - start) + start);
    }

    /*public static void main(String[] args) {
        int i = creatScore(3, 5);
        System.out.println(i);
    }*/
}
