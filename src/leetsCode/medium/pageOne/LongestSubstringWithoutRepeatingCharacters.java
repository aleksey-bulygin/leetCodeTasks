package leetsCode.medium.pageOne;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int len = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> validationSet = new HashSet<>();
        int i = 0;
        int j = 0;
        int len = 0;

        while (i < s.length() && j < s.length()) {
            if (!validationSet.contains(s.charAt(j))) {
                validationSet.add(s.charAt(j++));
                len = Math.max(len, j - i);
            } else {
                validationSet.remove(s.charAt(i++));
            }
        }

        return len;
    }
}
