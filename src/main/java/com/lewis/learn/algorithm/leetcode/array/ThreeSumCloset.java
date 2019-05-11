package com.lewis.learn.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author fanhuai.zmh@alibaba-inc.com
 * @date 2019/05/10
 */
public class ThreeSumCloset {

    public static void main(String[] args) {
        ThreeSumCloset sumCloset = new ThreeSumCloset();
        int sum = sumCloset.threeSumClosest(new int[]{0, 2, 1, -3}, 1);
        System.out.println(sum);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sumCloset = 0;
        int absSumCloset = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    int absBalance = Math.abs(sum - target);
                    int min = Math.min(absSumCloset, absBalance);
                    if (min != absSumCloset) {
                        absSumCloset = min;
                        sumCloset = sum;
                    }
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return sumCloset;
    }
}
