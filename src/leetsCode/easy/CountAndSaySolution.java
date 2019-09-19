package leetsCode.easy;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * <p>
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class CountAndSaySolution {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n < 1 || n > 30)
            return null;

        String res = "1";
        while (--n > 0) {
            StringBuilder tmp = new StringBuilder();
            int count = 1;

            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {
                    count++;
                } else {
                    tmp.append(count);
                    tmp.append(res.charAt(j - 1));
                    count = 1;
                }
            }
                tmp.append(count);
                tmp.append(res.charAt(res.length() - 1));
                res = tmp.toString();

        }

        return res;
    }
}
