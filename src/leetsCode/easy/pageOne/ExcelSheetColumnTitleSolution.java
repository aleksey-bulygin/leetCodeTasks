package leetsCode.easy.pageOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */
public class ExcelSheetColumnTitleSolution {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Input numbers:");
            String input = bufferedReader.readLine();

            while (input.matches("\\d+")) {
                numbers.add(Integer.parseInt(input));
                input = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!numbers.isEmpty()) {
            ExcelSheetColumnTitleSolution excel = new ExcelSheetColumnTitleSolution();
            System.out.println("Output:");
            numbers.stream().forEach(n -> System.out.println(n + " : " + excel.convertToTitle(n)));
        } else {
            System.out.println("Sorry, inputs is empty , try again");
        }
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
