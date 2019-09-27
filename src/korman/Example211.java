package korman;

public class Example211 {
    public static void main(String[] args) {
        int[] arr = new Example211().insertionSort(new int[]{31, 41, 59, 26, 41, 58});
        for (int x : arr)
            System.out.print(x + " ");
    }

    public int[] insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] < key) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = key;
        }

        return arr;
    }
}
