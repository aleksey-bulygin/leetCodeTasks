package leetsCode;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSumSolution {
    public static void main(String[] args) {
        int[] out = twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(out[0] + " " + out[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];

        twoSum:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    out[0] = i;
                    out[1] = j;
                    break twoSum;
                }
            }
        }

        return out;
    }
}
