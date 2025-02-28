package sorting;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] array) {
        int n = array.length;

        // Find the maximum element in the array
        int max = Arrays.stream(array).max().getAsInt();

        // Create a count array to store the frequency of each element
        int[] count = new int[max + 1];

        // Store the count of each element
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
        }

        // Modify the count array by adding the previous count to each element
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy the sorted elements into the original array
        System.arraycopy(output, 0, array, 0, n);
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original Array: " + Arrays.toString(array));
        countingSort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
