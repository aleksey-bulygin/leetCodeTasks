package leetsCode.medium.pageOne;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstringSolution {
    public static void main(String[] args) {
        String answer = new LongestPalindromicSubstringSolution()
                .longestPalindrome("cbbd");
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = extendByCenter(s, i, i);
            int len2 = extendByCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int extendByCenter(String s, int lo, int hi) {
        while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
            lo--;
            hi++;
        }

        return hi - lo - 1;
    }

    /**
        public String longestPalindrome(String s) {
            if (isPalindrome(s) || s.length() < 2)
                return s;

            String right = longestPalindrome(s.substring(0, (s.length() - 1)));
            String left = longestPalindrome(s.substring(1));

            return (right.length() > left.length())? right : left;
        }


        private boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++)
                if (! (chars[i] == chars[chars.length - 1 - i]) )
                    return false;

            return true;
        }
         **/

}
