package com.lewis.learn.algorithm.leetcode.array;


/**
 * @author minghzhang
 * @date 2019/05/19
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary67 {

    public static void main(String[] args) {
        AddBinary67 addBinary67 = new AddBinary67();
        String s = addBinary67.addBinary("11", "1");
        System.out.println(s);

    }

    public String addBinary(String a, String b) {
        String ret = "";
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carray = 0;

        while (aIndex >= 0 || bIndex >= 0) {

            int aInt = aIndex >= 0 ? a.charAt(aIndex) - '0' : 0;
            int bInt = bIndex >= 0 ? b.charAt(bIndex) - '0' : 0;

            int sum = aInt + bInt + carray;

            ret = sum % 2 + ret;

            carray = sum / 2;

            aIndex--;
            bIndex--;
        }

        if (carray > 0) {
            ret = '1' + ret;
        }

        return ret;
    }

}