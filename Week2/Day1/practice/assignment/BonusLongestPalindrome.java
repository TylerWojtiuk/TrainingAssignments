package practice.assignment;

public class BonusLongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            int[] odd = expandAroundCenter(s, i, i);
            if (odd[1] > maxLen) {
                start = odd[0];
                maxLen = odd[1];
            }

            int[] even = expandAroundCenter(s, i, i + 1);
            if (even[1] > maxLen) {
                start = even[0];
                maxLen = even[1];
            }
        }

        return s.substring(start, start + maxLen);
    }

    private static int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - left - 1};
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // bab (or aba)
    }
}