package practice.assignment;

public class Q13ReverseWords {
    public static String reverseWords(String sentence) {
        StringBuilder result = new StringBuilder();
        int i = sentence.length() - 1;

        while (i >= 0) {
            while (i >= 0 && sentence.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) {
                break;
            }

            int wordEnd = i;
            while (i >= 0 && sentence.charAt(i) != ' ') {
                i--;
            }
            int wordStart = i + 1;

            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(sentence, wordStart, wordEnd + 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Java is easy to learn"));      // learn to easy is Java
        System.out.println(reverseWords("  multiple   spaces  here  ")); // here spaces multiple
    }
}