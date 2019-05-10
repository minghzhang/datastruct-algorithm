package com.lewis.learn.algorithm.leetcode.array;

import java.util.*;

/**
 * @author minghzhang
 * @date 2019/05/08
 * https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0});
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return retList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        retList.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;

                    } else if (nums[low] + nums[high] > sum) {
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        high--;
                    } else {
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        low++;
                    }
                }
            }

        }
        return retList;
    }


}
