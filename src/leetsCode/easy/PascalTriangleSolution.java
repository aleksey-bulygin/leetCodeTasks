package leetsCode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangleSolution {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new PascalTriangleSolution().generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>(numRows);

        if (numRows == 0)
            return answer;

        List<Integer> nums1 = Arrays.asList(1);
        answer.add(nums1);

        if (numRows == 1)
            return answer;

        List<Integer> nums2 = Arrays.asList(1, 1);
        answer.add(nums2);

        if (numRows == 2)
            return answer;

        for (int i = 2; i < numRows; i++) {
            List<Integer> nums = new ArrayList<>(i + 1);
            nums.add(0, 1);
            nums.add(nums.size() - 1, 1);

            for (int j = 1; j < i; j++)
                nums.add(j, answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));

            answer.add(nums);
        }

        return answer;
    }
}
