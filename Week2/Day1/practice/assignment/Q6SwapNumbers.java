package practice.assignment;

public class Q6SwapNumbers {
    public static void swapArithmetic(int a, int b) {
        // Use long internally to prevent overflow during addition/subtraction
        long sum = (long) a + b;
        b = (int) (sum - b);
        a = (int) (sum - b);
        System.out.println("Arithmetic -> a = " + a + ", b = " + b);
    }

    public static void swapXor(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("XOR -> a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        swapArithmetic(a, b);
        swapXor(a, b);
    }
}
