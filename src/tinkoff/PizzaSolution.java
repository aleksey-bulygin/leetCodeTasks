package tinkoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaSolution {
    public static void main(String[] args) {
        String phrase= null;
        String names = null;
        String output;

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            phrase = bufferedReader.readLine();
            names = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (!phrase.isEmpty() && !names.isEmpty()) {
            int countWords = phrase.split("\\s+").length;
            String[] namesArray = names.split("\\s+");
            int index = countWords > namesArray.length? (countWords % namesArray.length) - 1 : --countWords;
            output = namesArray[index];
            System.out.println(output);
        }
    }
}
