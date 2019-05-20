package com.lewis.learn.algorithm.leetcode.array;

/**
 * @author minghzhang
 * @date 2019/05/19
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        LargestNumberAtLeastTwiceOfOthers demo = new LargestNumberAtLeastTwiceOfOthers();
        int i = demo.dominantIndex(new int[]{0, 0, 0, 1});
        System.out.println(i);
    }

    public int dominantIndex(int[] nums) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && max < nums[i] * 2) {
                return -1;
            }

        }
        return maxIndex;
    }
}
