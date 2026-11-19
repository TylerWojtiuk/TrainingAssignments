package practice.assignment;

public class Q5AnagramCheck {
    public static boolean areAnagrams(String s1, String s2) {
        int[] freq = new int[256];
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            char ch = Character.toLowerCase(s1.charAt(i));
            if (ch != ' ') {
                freq[ch]++;
                count++;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = Character.toLowerCase(s2.charAt(i));
            if (ch != ' ') {
                freq[ch]--;
                count--;
                if (freq[ch] < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent") ? "Anagram" : "Not Anagram");
        System.out.println(areAnagrams("hello", "world") ? "Anagram" : "Not Anagram");
    }
}
