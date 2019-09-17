package leetsCode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefixSolution {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aa","a"}));
    }
    
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        for (String string : strs)
            if (string.matches("\\s+") || string.matches(""))
                return "";

        StringBuilder output = new StringBuilder("");

        Arrays.sort(strs, Comparator.comparingInt(String::length));

        char[] words = strs[0].toCharArray();
        StringBuilder out = new StringBuilder();

        searchPrefix:
        for (int i = 0; i < words.length; i++) {
            boolean containsWord = true;

            runStrs:
            for (int j = 1; j < strs.length; j++) {
                if (!(words[i] == strs[j].charAt(i))) {
                    containsWord = false;
                    break runStrs;
                }
            }

            if (containsWord)
                out.append(words[i]);
            else
                break searchPrefix;
        }

        return out.toString();
    }
}
