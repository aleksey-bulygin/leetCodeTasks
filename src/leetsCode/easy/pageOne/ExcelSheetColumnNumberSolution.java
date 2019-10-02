package leetsCode.easy.pageOne;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 */
public class ExcelSheetColumnNumberSolution {
    public static void main(String[] args) {
        int answer = new ExcelSheetColumnNumberSolution().titleToNumber("ZY");
    }

    public int titleToNumber(String s) {
        int n = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int i1 = chars[chars.length - i - 1] - 'A' + 1;
            n += Math.pow(26, i) * i1;

        }
        return n;
    }
}
