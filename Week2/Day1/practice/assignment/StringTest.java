package practice.assignment;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println(s1 == s2);        // true  (both reference the same String Pool literal)
        System.out.println(s1 == s3);        // false (s3 is a distinct heap object from 'new')
        System.out.println(s1.equals(s3));   // true  (same character sequence)

        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");

        System.out.println(sb);              // Java Programming
        System.out.println(s1);              // Java
    }
}
