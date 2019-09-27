package korman;

public class MergeSortExample {
    public static void main(String[] args) {
        int[] array = new int[]{3, 41, 52, 26, 38, 57, 9, 49};
        new MergeSortExample().mergeSort(array, 1, array.length);

        for (int x : array)
            System.out.print(x + " ");
    }

    public void merge(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1 - 1; i++)
            L[i] = array[p + i - 1];
        for (int i = 0; i < n2 - 1; i++)
            R[i] = array[q + i];
        L[n1 - 1] = Integer.MAX_VALUE;
        R[n2 - 1] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = p; k < r; k++) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
        }
    }

    public void mergeSort(int[] array, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(array, p, q);
            mergeSort(array, q + 1, r);
            merge(array, p, q, r);
        }
    }
}
