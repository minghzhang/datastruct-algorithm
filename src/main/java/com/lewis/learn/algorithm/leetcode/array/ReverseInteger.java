package com.lewis.learn.algorithm.leetcode.array;

/**
 * @author fanhuai.zmh@alibaba-inc.com
 * @date 2019/05/07
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger demo = new ReverseInteger();
        //int reverse = demo.reverse(123);
        int reverse = demo.fastReverse(Integer.MAX_VALUE);
        System.out.println(reverse);
        boolean palindrome = demo.isPalindrome(121);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        int y = x;
        long res =0;
        for(;x !=0; x /= 10){
            res = res * 10 + x % 10;
        }
        if(y == res) {
            return true;
        }
        return false;
    }
    //将最低位和最高位反转
    public int fastReverse(int x) {
        if (invalidRange(x)) {
            return 0;
        }
        long res = 0;
        for (; x != 0; x /= 10) {
            res = res * 10 + x % 10;
        }
        if (invalidRange(res)) {
            return 0;
        }
        return (int) res;
    }

    private boolean invalidRange(long x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    //将数值转为字符数组 再反转
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE || x == 0) {
            return 0;
        }
        try {
            if (x > 0) {
                return Integer.parseInt(reversAbs(x));
            } else {
                return Integer.parseInt("-" + reversAbs(x));
            }
        } catch (Exception e) {
            return 0;
        }
    }

    private String reversAbs(int x) {
        x = Math.abs(x);
        String xString = ((Integer) x).toString();
        char[] chars = xString.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[chars.length - i - 1] = chars[i];
        }
        return new String(newChars);
    }
}
