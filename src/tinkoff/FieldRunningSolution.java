package tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FieldRunningSolution {
    public static int answer = 0;
    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] points = bufferedReader.readLine().split("\\s+");
            int x = Integer.parseInt(points[0]);
            int y = Integer.parseInt(points[points.length - 1]);

            searchPaths(x, y);
            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void searchPaths(int x, int y) {
        if ( (x > 0 && x <= 8) && y == 8) {
            ++answer;
            return;
        }

        int x_right = x + 1;
        int y_right = y + 1;
        int x_left = x - 1;
        int y_left = y + 1;

        searchPaths(x_right, y_right);
        searchPaths(x_left, y_left);
    }
}
