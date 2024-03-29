package leetsCode.easy.pageOne;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 *     Your returned answers (both index1 and index2) are not zero-based.
 *     You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumAndInputArrayIsSortedSolution {
    public static void main(String[] args) {
        int[] answer = new TwoSumAndInputArrayIsSortedSolution()
                .twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] indexs = new int[2];
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {

            if (numbers[i] + numbers[j] == target) {
                indexs[0] = ++i;
                indexs[1] = ++j;
                break;
            } else if (numbers[i] + numbers[j] < target)
                i++;
            else if (numbers[i] + numbers[j] > target)
                j--;
        }

        return indexs;
    }
}
