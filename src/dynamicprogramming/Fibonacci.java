
package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    // Memoization approach for Fibonacci
    private static Map<Integer, Long> memo = new HashMap<>();

    public static long fibonacci(int n) {
        // Base case
        if (n <= 1) return n;

        // Check if the result is already in the memo
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Recursive calculation with memoization
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 10;  // Example input
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }
}
