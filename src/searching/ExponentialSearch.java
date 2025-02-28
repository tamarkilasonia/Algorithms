package searching;

public class ExponentialSearch {

    // Function to perform exponential search on a sorted array
    public static int exponentialSearch(int[] array, int target) {
        int n = array.length;

        // If the target is the first element
        if (array[0] == target) {
            return 0;
        }

        // Find range for binary search by repeated doubling
        int i = 1;
        while (i < n && array[i] <= target) {
            i *= 2;
        }

        // Perform binary search in the found range
        return binarySearch(array, target, i / 2, Math.min(i, n - 1));
    }

    // Binary search function for exponential search
    public static int binarySearch(int[] array, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 9;
        int result = exponentialSearch(array, target);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
