package practice.assignment;

public class Q9FirstNonRepeatedChar {
    public static String firstNonRepeated(String str) {
        int[] counts = new int[256];

        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (counts[ch] == 1) {
                return String.valueOf(ch);
            }
        }

        return "No non-repeated character";
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeated("swiss"));  // w
        System.out.println(firstNonRepeated("aabbcc")); // No non-repeated character
    }
}
