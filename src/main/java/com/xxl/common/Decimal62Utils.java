package com.xxl.common;

/**
 * 62 进制工具类
 * @author sean
 * @date 2019/01/02/23:41
 **/
public class Decimal62Utils {
    private final static char[] DIGITS  = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z' };

    private final String digits =new String(DIGITS);

    int len = DIGITS.length;

    /**
     * 循环求余求商的原理
     * @param number
     * @return
     */
    public String toDecimal62(long number) {
        StringBuilder sBuilder = new StringBuilder();
        while (true) {
            int remainder = (int) (number % 62);
            sBuilder.append(DIGITS[remainder]);
            number = number / 62;
            if (number == 0) {
                break;
            }
        }
        return sBuilder.reverse().toString();
    }

    public long toDecimal10(String s) {
        int a = s.length()-1;
        long val=0;
        for(int i=a;i>=0;i--){
            char c = s.charAt(i);
            val += (digits.indexOf(c)*Math.pow(len, a-i));
        }
        return val;
    }

    public static void main(String[] args) {
        Decimal62Utils s64 = new Decimal62Utils();
        long num=452364344;
        String enCode=s64.toDecimal62(num);
        long deCode = s64.toDecimal10(enCode);
        System.out.println("短Id是："+enCode);
        System.out.println("Id是："+deCode);
    }
}
