package mathematical;

public class GCD {
    // Recursive method to find GCD
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Iterative method
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int num1 = 56, num2 = 98;
        System.out.println("GCD (Recursive): " + gcd(num1, num2));
        System.out.println("GCD (Iterative): " + gcdIterative(num1, num2));
    }
}
