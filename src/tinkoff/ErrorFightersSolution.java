package tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ErrorFightersSolution {
    public static int days = 0;

    public static void main(String[] args) {
        String input = null;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (input.matches("(\\d+\\s\\d+\\s\\d+\\s\\d+\\s\\d+)")) {
            String[] inputs = input.split("\\s");
            final int A = Integer.parseInt(inputs[0]);
            final int K = Integer.parseInt(inputs[1]);
            final int B = Integer.parseInt(inputs[2]);
            final int M = Integer.parseInt(inputs[3]);
            final int X = Integer.parseInt(inputs[4]);
            int holidayNikita = 0;
            int holidayDenis = 0;

            for (int i = 0; i < X && i != X;) {
                holidayDenis++;
                holidayNikita++;
                days++;

                if (holidayDenis < K) {
                    i += A;
                } else if (holidayDenis == K)
                    holidayDenis = 0;

                if (holidayNikita < M) {
                    i += B;
                } else if (holidayNikita == M)
                    holidayNikita = 0;
            }

            System.out.println(days);
        }
    }
}
