package leetsCode.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinarySolution {
    public static void main(String[] args) {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder out = new StringBuilder();
        int increase = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int n = i >= 0? Character.getNumericValue(a.charAt(i)) : 0;
            int m = j >= 0? Character.getNumericValue(b.charAt(j)) : 0;
            int sum = n + m + increase;

            increase = 0;

            if (sum > 1)
                increase = 1;
            out.append(sum % 2);
        }

        if (increase == 1)
            out.append(increase);

        return out.reverse().toString();
    }
}
