package practice.assignment;

public class Q12StringCompression {
    public static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= str.length(); i++) {
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabbccccd")); // a3b2c4d1
        System.out.println(compress("abc"));        // a1b1c1
        System.out.println(compress("z"));          // z1
    }
}
