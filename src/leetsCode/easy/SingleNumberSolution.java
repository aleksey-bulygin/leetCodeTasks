package leetsCode.easy;

import java.util.Arrays;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumberSolution {
    public static void main(String[] args) {
        int result = new SingleNumberSolution().singleNumber(new int[]{1, 3, 2, 3, 2});
        System.out.println(result);
    }

    public int singleNumber(int[] nums) {
        int a = nums[0];

        for (int i = 1; i < nums.length; i++)
            a = a ^ nums[i];

        return a;
    }
}
