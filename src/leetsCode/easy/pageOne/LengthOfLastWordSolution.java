package leetsCode.easy.pageOne;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWordSolution {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(""));
    }

    public static int lengthOfLastWord(String s) {
        if (!s.trim().isEmpty() && s.contains(" ")) {
            String[] strs = s.split("\\s");
            return strs[strs.length - 1].length();
        } else if (!s.trim().isEmpty() && s.trim().toLowerCase().matches("[a-z]{1,}"))
            return s.trim().length();

        return 0;
    }
}
