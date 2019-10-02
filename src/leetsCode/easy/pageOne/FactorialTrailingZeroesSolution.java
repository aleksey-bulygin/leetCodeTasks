package leetsCode.easy.pageOne;

/**
 *
 */
public class FactorialTrailingZeroesSolution {
    public static void main(String[] args) {
        int answer = new FactorialTrailingZeroesSolution().trailingZeroes(5);
    }

    public int trailingZeroes(int n) {
        return n >= 5? n/5 + trailingZeroes(n/5) : 0;
    }
}
