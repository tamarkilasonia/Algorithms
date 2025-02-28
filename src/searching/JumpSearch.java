package searching;

public class JumpSearch {

    // Function to perform jump search on a sorted array
    public static int jumpSearch(int[] array, int target) {
        int n = array.length;
        int step = (int) Math.sqrt(n); // Jump step size

        int prev = 0;
        while (array[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1;
            }
        }

        // Linear search within the block
        for (int i = prev; i < Math.min(step, n); i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int target = 4;
        int result = jumpSearch(array, target);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
