package practice.assignment;

public class CastingTest {
    public static void main(String[] args) {
        int a = 10;
        double b = 3.5;

        // Implicit widening of int 'a' to double, then explicit narrowing cast to int (truncates .5)
        int result = (int) (a + b);
        System.out.println(result); // 13

        // 'ch' (65) promotes to int during addition with 5
        char ch = 'A';
        int value = ch + 5;
        System.out.println(value);          // 70
        System.out.println((char) value);   // F

        // Additional challenge: implicit (widening) vs explicit (narrowing) casting
        int intVal = 100;
        long longVal = intVal;              // Implicit widening: int -> long
        double doubleVal = longVal;         // Implicit widening: long -> double

        double pi = 3.99;
        int truncatedPi = (int) pi;         // Explicit narrowing: double -> int (3)
        byte smallByte = (byte) 130;        // Explicit narrowing overflow: -126

        System.out.println("Widened double: " + doubleVal);
        System.out.println("Narrowed int: " + truncatedPi);
        System.out.println("Narrowed byte: " + smallByte);
    }
}