package searching;

public class BinarySearch {

    // Function to perform binary search on a sorted array
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if target is present at mid
            if (array[mid] == target) {
                return mid;
            }
            // If target is greater, ignore left half
            if (array[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                high = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int target = 4;
        int result = binarySearch(array, target);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
