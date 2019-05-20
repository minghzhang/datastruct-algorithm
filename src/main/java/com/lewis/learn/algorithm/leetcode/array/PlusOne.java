package com.lewis.learn.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author minghzhang
 * @date 2019/05/19
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * <p>
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {9, 9};
        long sum = plusOne.getSum(digits);
        System.out.println(sum);
        int[] ints = plusOne.plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne(int[] digits) {
        int[] temp = new int[digits.length];
        int jinwei = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum;
            if (i == digits.length - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + jinwei;
            }

            int reminder = sum % 10;
            temp[i] = reminder;
            jinwei = sum / 10;
        }
        if (jinwei > 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            System.arraycopy(temp, 0, ret, 1, temp.length);
            return ret;
        }

        return temp;
    }

    private long getSum(int[] digits) {
        long sum = 0;
        for (int i = 0; i < digits.length; i++) {
            int num = 0;
            if (i != digits.length - 1) {
                num = digits[i] * 10;
                sum = sum * 10;
            } else {
                num = digits[i];
            }
            sum += num;
        }
        return sum;
    }
}
