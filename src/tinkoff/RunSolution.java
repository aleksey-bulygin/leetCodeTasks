package tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunSolution {
    public static void main(String[] args) {
        String input = null;

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (input.matches("(\\d+\\s+\\d+)")){
            String[] inputs = input.split("\\s+");
            int s = Integer.parseInt(inputs[0]);
            int t = Integer.parseInt(inputs[inputs.length - 1]);
            int answer = t >= s? s - (t % s) : s - t;
            System.out.println(answer);
        }
    }
}
