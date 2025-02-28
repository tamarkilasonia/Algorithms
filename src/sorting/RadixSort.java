package sorting;

import java.util.Arrays;

public class RadixSort {

    // A utility function to get the maximum value in an array
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    
    // Counting sort for a specific digit represented by exp (1s, 10s, 100s, ...)
    public static void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        // Change count[i] so that it contains the actual position of the digit
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // Copy the output array to the original array
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    // Main function to implement Radix Sort
    public static void radixSort(int[] array) {
        int max = getMax(array);

        // Apply counting sort for every digit (1s, 10s, 100s, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original Array: " + Arrays.toString(array));
        radixSort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}

