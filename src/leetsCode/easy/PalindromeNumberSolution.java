package leetsCode.easy;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 *
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumberSolution {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int y = 0;
        int tmp = x;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            y = y * 10 + pop;
        }

        return y == tmp;
    }
}
