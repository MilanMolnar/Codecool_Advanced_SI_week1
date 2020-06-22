package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(nearby(1,0,1));

    }

    public static ArrayList<Integer> nearby(int x, int y, int range){
        int[][] multi = new int[][]{
                { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
                { 1, 3, 5, 7 },
                { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
        };
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= range; i++) {
            try {
                list.add(multi[x][y-i]);
                System.out.println("number added: " + multi[x][y-i]);
            } catch (ArrayIndexOutOfBoundsException err){
                System.out.println("no nearby num -");
            }
            try {
                list.add(multi[x][y+i]);
                System.out.println("number added: " + multi[x][y+i]);
            } catch (ArrayIndexOutOfBoundsException err){
                System.out.println("no nearby num +");
            }
        }
        return list;
    }
}