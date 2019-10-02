package leetsCode.easy.pageOne;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParenthesesSolution {
    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty())
            return true;

        while (!s.isEmpty()) {
            if ( !(s.contains("()") || s.contains("[]") || s.contains("{}")) )
                return false;

            if (s.contains("()"))
                s = s.replaceFirst("(\\(\\))", "");
            if (s.contains("[]"))
                s = s.replaceFirst("(\\[\\])", "");
            if (s.contains("{}"))
                s = s.replaceFirst("(\\{\\})", "");
        }

        return true;
    }
}
