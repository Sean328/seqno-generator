package com.xxl.common;

import java.util.Stack;

/**
 * 62进制工具类
 *
 * <herf https://blog.csdn.net/qq_30629571/article/details/81065009></herf>
 * @author sean
 * @date 2019/01/02/23:20
 **/
public class DigitalFor62 {

    private static char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * 将10进制转化为62进制
     *
     * @param number
     * @param length 转化成的62进制长度，不足length长度的话高位补0，否则不改变什么
     * @return
     */
    public static String decimal_10to62(long number, int length) {
        Long rest = number;
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder(0);
        while (rest != 0) {
            stack.add(charSet[new Long((rest - (rest / 62) * 62)).intValue()]);
            rest = rest / 62;
        }
        for (; !stack.isEmpty(); ) {
            result.append(stack.pop());
        }
        int result_length = result.length();
        StringBuilder temp0 = new StringBuilder();
        for (int i = 0; i < length - result_length; i++) {
            temp0.append('0');
        }

        return temp0.toString() + result.toString();

    }

    /**
     * 将62进制转换成10进制数 ，我重新写了这个函数，原先版本有问题
     *
     * @param ident62
     * @return
     */
    public static String convertBase62ToDecimal_v2(String ident62) {
        Long dst = 0L;
        for (int i = 0; i < ident62.length(); i++) {
            char c = ident62.charAt(i);
            for (int j = 0; j < charSet.length; j++) {
                if (c == charSet[j]) {
                    dst = (dst * 62) + j;
                    break;
                }
            }
        }
        String str = String.format("%08d", dst);
        return str;
    }


    /**
     * 将62进制转换成10进制数
     *
     * @param ident62
     * @return
     */
    public static String convertBase62ToDecimal(String ident62) {
        int decimal = 0;
        int base = 62;
        int keisu = 0;
        int cnt = 0;

        byte ident[] = ident62.getBytes();
        for (int i = ident.length - 1; i >= 0; i--) {
            int num = 0;
            if (ident[i] > 48 && ident[i] <= 57) {
                num = ident[i] - 48;
            } else if (ident[i] >= 65 && ident[i] <= 90) {
                num = ident[i] - 65 + 10;
            } else if (ident[i] >= 97 && ident[i] <= 122) {
                num = ident[i] - 97 + 10 + 26;
            }
            keisu = (int) Math.pow((double) base, (double) cnt);
            decimal += num * keisu;
            cnt++;
        }
        return String.format("%08d", decimal);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("62System=" + decimal_10to62(Integer.parseInt("452364344"), 0));
        System.out.println("10System=" + convertBase62ToDecimal("Uc4d6"));

        //120160524121052485
        System.out.println("10System=" + convertBase62ToDecimal_v2("00008sKrPTsBmv"));
    }

}