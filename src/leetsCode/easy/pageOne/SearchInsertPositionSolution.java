package leetsCode.easy.pageOne;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 *
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPositionSolution {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7 ));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums[0] >= target)
            return 0;
        if (nums[nums.length - 1] < target)
            return nums.length;

        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] <= target && nums[i + 1] >= target)
                return ++i;

        return -1;
    }
}
