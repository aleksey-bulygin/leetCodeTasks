package leetsCode.easy.pageOne;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindromeSolution {
    public static void main(String[] args) {
        System.out.println(new ValidPalindromeSolution().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\W", "").
                replaceAll("\\_","").toLowerCase();

        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
