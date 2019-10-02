package leetsCode.easy.pageOne;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarraySolution {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        int min_sum = 0;
        int min_pos = -1;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            int cur = sum - min_sum;

            if (cur > ans)
                ans = cur;

            if (sum < min_sum)
                min_sum = sum;
        }

        return ans;
    }
}
