package other;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NormalizingPagesSolution {
    private final List<String> tests = Arrays.asList(
            "6 ,   8-10 ,   9 -   11, 1,   3 -5",
            "3   , 5,11,  2",
            "1, 2-30, 25-26, 7, 80, 124, 28-35, 36-42, 43",
            "0-10, 7- 19, 15-234, 12-1764, 2143-6345");

    public static void main(String[] args) {
        NormalizingPagesSolution normalizingPagesSolution = new NormalizingPagesSolution();

        for (String test : normalizingPagesSolution.tests) {
            System.out.println("Input: " + test);

            String result = normalizingPagesSolution.
                    normalize(test.trim().replaceAll("\\s+", ""));

            System.out.println("Output: " + result);
            System.out.println();
        }


    }

    private String normalize(String input) {
        List<String> parts = Arrays.asList(input.split("\\,"));
        int[] numbersInInterval = geеIntervalNumbers(parts);
        List<Pair<Integer, Integer>> intervals = getAllIntervals(numbersInInterval, parts);

        intervals.sort(Comparator.comparing(Pair::getKey));
        SegmentNode root = new SegmentNode(intervals.get(0).getKey());
        root.right = new SegmentNode(intervals.get(0).getValue());

        SegmentNode tmp = root.right;

        for (int i = 1; i < intervals.size(); i++) {
            if (isContact(intervals.get(i).getKey(), tmp)) {

                if (intervals.get(i).getValue() > tmp.val) {
                    tmp.right = new SegmentNode(intervals.get(i).getValue());
                    tmp = tmp.right;
                }

            } else {
                tmp.down = new SegmentNode(intervals.get(i).getKey());
                tmp.down.right = new SegmentNode(intervals.get(i).getValue());
                tmp = tmp.down.right;
            }
        }

        StringBuilder output = new StringBuilder("");
        detour(root, output);

        String result = output.toString().trim();

        return result.substring(0, result.length() - 1);
    }

    private void detour(SegmentNode root, StringBuilder stringBuilder) {
        int start = root.val;
        while (root.right != null)
            root = root.right;

        int end = root.val;

        if (start == end)
            stringBuilder.append(start + ", ");
        else
            stringBuilder.append(start + " - " + end + ",");

        if (root.down != null)
            detour(root.down, stringBuilder);
    }

    private boolean isContact(Integer key, SegmentNode tmp) {
        while (tmp.right != null)
            tmp = tmp.right;

        return --key <= tmp.val? true : false;
    }

    private List<Pair<Integer, Integer>> getAllIntervals(int[] numbersInInterval, List<String> parts) {
        List<Pair<Integer, Integer>> intervals = new ArrayList<>();

        for (int i = 0; i < numbersInInterval.length; i = i + 2)
            intervals.add(new Pair<>(numbersInInterval[i], numbersInInterval[i + 1]));

        parts.stream().filter(s -> s.matches("\\d+"))
                .forEach(s -> intervals.add(new Pair<>(Integer.parseInt(s),
                Integer.parseInt(s))));

        return intervals;
    }

    private int[] geеIntervalNumbers(List<String> parts) {
        return parts.stream()
                .filter(s -> s.matches("(\\d+\\-\\d+)"))
                .map(s -> s.split("\\-"))
                .flatMap(s -> Arrays.stream(s))
                .mapToInt(s -> Integer.parseInt(s)).toArray();
    }
}

class SegmentNode {
    int val;
    SegmentNode down;
    SegmentNode right;

    SegmentNode(int val) {
        this.val = val;
    }
}