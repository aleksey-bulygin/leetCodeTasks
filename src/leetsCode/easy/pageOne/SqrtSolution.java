package leetsCode.easy.pageOne;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 *
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class SqrtSolution {

    public static void main(String[] args) {
        System.out.print(mySqrt( 2147395600));
    }

    public static int mySqrt(int x) {
        if (x == 1)
            return 1;

        double step = 1;
        for (;;) {
            double nx = (step + x / step) / 2;
            if (Math.abs(step - nx) < 1e-10)
                break;
            step = nx;
        }
        return Integer.parseInt(String.valueOf(step).split("\\.")[0]);
    }
}
