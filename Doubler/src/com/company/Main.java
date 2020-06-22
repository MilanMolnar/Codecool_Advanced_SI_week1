package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,4,11,12,8};
        System.out.println(doubleResult(2,numbers));
    }

    public static int doubleResult(int b, final int[] numbers) {
        if(numbers != null){
            Arrays.sort(numbers);
            for(int num:numbers){
                if(num == b){
                    b = b*2;
                }
            }
        }
        return b;
    }
}
