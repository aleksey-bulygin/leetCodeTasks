package korman;

public class MergeSortExample {
    public static void main(String[] args) {
        int[] array = new int[]{3, 41, 52, 26, 38, 57, 9, 49};
        array = new MergeSortExample().mergeSort(array);

        for (int x : array)
            System.out.print(x + " ");
    }

    public int[] merge(int[] left, int[] right) {
        int leftPoint = 0,
            rightPoint = 0,
            resultPoint = 0;

        int[] result = new int[left.length + right.length];

        while (leftPoint < left.length || rightPoint < right.length) {

            if (leftPoint < left.length && rightPoint < right.length) {
                if (left[leftPoint] < right[rightPoint])
                    result[resultPoint++] = left[leftPoint++];
                else
                    result[resultPoint++] = right[rightPoint++];

            } else if (leftPoint < left.length)
                result[resultPoint++] = left[leftPoint++];
            else if (rightPoint < right.length)
                result[resultPoint++] = right[rightPoint++];
        }

        return result;
    }

    public int[] mergeSort(int[] array) {
        if (array.length < 2)
            return array;

        final int mid = array.length / 2;

        int[] left = new int[mid];
        int[] right = new int[array.length % 2 == 0? mid : mid + 1];

        for (int i = 0; i < left.length; i++)
            left[i] = array[i];

        for (int j = 0; j < right.length; j++)
            right[j] = array[mid + j];

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }
}
