package mathematical;

public class ExponentiationBySquaring {
    public static long power(long base, long exp) {
        if (exp == 0) return 1;
        if (exp % 2 == 0) {
            long half = power(base, exp / 2);
            return half * half;
        } else {
            return base * power(base, exp - 1);
        }
    }

    public static void main(String[] args) {
        long base = 3, exp = 10;
        System.out.println(base + "^" + exp + " = " + power(base, exp));
    }
}
