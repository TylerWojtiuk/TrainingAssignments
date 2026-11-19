package practice.assignment;

public class Q1ReverseNumber {
    public static int reverseNumber(int num) {
        long reversed = 0;
        int temp = num;

        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                throw new ArithmeticException("Integer overflow while reversing: " + num);
            }
            temp /= 10;
        }

        return (int) reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverseNumber(12345)); // 54321
        System.out.println(reverseNumber(908));   // 809
        System.out.println(reverseNumber(-1230)); // -321
    }
}
