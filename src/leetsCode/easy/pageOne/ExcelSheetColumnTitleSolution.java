package leetsCode.easy.pageOne;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */
public class ExcelSheetColumnTitleSolution {

    public static void main(String[] args) {
        String answer = new ExcelSheetColumnTitleSolution().convertToTitle( 701);
    }

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while (n > 0) {
            result.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }

        return result.reverse().toString();
    }
}
