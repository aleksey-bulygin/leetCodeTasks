package leetsCode.easy.pageOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleTwoSolution {

    public static void main(String[] args) {
        List<Integer> triangle = new PascalTriangleTwoSolution().getRow(3);
    }

    public List<Integer> getRow(int rowIndex)  {
        int numRows = rowIndex + 1;
        List<List<Integer>> answer = new ArrayList<>(numRows);

        if (numRows == 0)
            return Arrays.asList();

        List<Integer> nums1 = Arrays.asList(1);
        answer.add(nums1);

        if (numRows == 1)
            return nums1;

        List<Integer> nums2 = Arrays.asList(1, 1);
        answer.add(nums2);

        if (numRows == 2)
            return nums2;

        for (int i = 2; i < numRows; i++) {
            List<Integer> nums = new ArrayList<>(i + 1);
            nums.add(0, 1);
            nums.add(nums.size() - 1, 1);

            for (int j = 1; j < i; j++)
                nums.add(j, answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));

            answer.add(nums);
        }

        return answer.get(answer.size() - 1);
    }
}
