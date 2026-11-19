package practice.assignment;

public class Q8RemoveDuplicates {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            boolean alreadySeen = false;

            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == current) {
                    alreadySeen = true;
                    break;
                }
            }

            if (!alreadySeen) {
                sb.append(current);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("programming")); // progamin
    }
}
