package methodslab;

public class MethodLab {

    public static void main(String[] args) {
        //  Section A: Guided lab 

        // Part 1: Data types
        printProfile("Asha", 21, 5.6, true, 'A');
        printProfile("Ravi", 30, 5.9, false, 'B');

        System.out.println(average(1, 2, 2));

        System.out.println(fitsInByte(127));
        System.out.println(fitsInByte(128));
        System.out.println(fitsInByte(-129));

        // Part 2: Wrapper classes
        System.out.println(addTexts("12", "30"));

        int r = boxTwice(21);
        System.out.println(r);

        describe(10);

        Integer a1 = 127, b1 = 127;
        System.out.println("127:  equals=" + sameValue(a1, b1) + "  ==" + (a1 == b1));
        Integer a2 = 1000, b2 = 1000;
        System.out.println("1000: equals=" + sameValue(a2, b2) + "  ==" + (a2 == b2));
        //(2.4): Integer caches -128 to 127, so == compares the same object for 127
        // but two different objects for 1000. Use equals for wrapper values.

        // Part 3: Casting
        System.out.println(truncate(9.99));
        System.out.println(truncate(-9.99));

        System.out.println(widen(7));

        overflowDemo();

        System.out.println(shiftLetter('a', 2));

        // Part 4: Overloading
        describeValue(5);
        describeValue(2.5);
        describeValue("hi");
        describeValue('A');
        describeValue(5L);
        // (4.1): There is no char or long overload. Java widens char to int and
        // long to double, choosing the closest available method.

        // Part 5: Value vs reference types
        int x = 1;
        tryChange(x);
        System.out.println("x = " + x);

        StringBuilder sb = new StringBuilder("Hi");
        appendBang(sb);
        System.out.println(sb);

        StringBuilder sbReplace = new StringBuilder("Hi");
        replaceBuilder(sbReplace);
        System.out.println(sbReplace);
        // (5.3): The parameter holds a copy of the reference. Pointing the copy at a
        // new object does not move the caller's variable.

        String s = "java";
        shout(s);
        System.out.println(s);

        // Part 6: Reference variables
        StringBuilder a = new StringBuilder("cat");
        StringBuilder b = a;
        b.append("s");
        System.out.println(a);

        compareRefs();

        System.out.println(safeLength(null));
        System.out.println(safeLength("hello"));

        // Part 7: String basics
        System.out.println(initials("ashu", "jauhari"));

        System.out.println(clean("  HeLLo "));

        System.out.println(isPalindromeWord("Level"));
        System.out.println(isPalindromeWord("Java"));

        System.out.println(maskEmail("asha@mail.com"));

        // Part 8: StringBuilder and StringBuffer
        System.out.println(buildCsv("a", "b", "c"));

        System.out.println(edit("Hello World"));

        long concatNs = timeJoin(false);
        long builderNs = timeJoin(true);
        System.out.printf("String +=     : %d ns%n", concatNs);
        System.out.printf("StringBuilder : %d ns%n", builderNs);

        System.out.println(safeAppend(new StringBuffer("Hi"), " there"));
        // (8.4): Use StringBuffer when several threads may change the same text,
        // because its methods are synchronized. Otherwise use the faster StringBuilder.

        // Part 9: Capstone
        System.out.println(formatReceipt("Asha", 3, 9.99));
        System.out.println(formatReceipt("Ravi", 2, 4.5));

        //  Section B: Practice problems

        // Problem 1
        System.out.println(toFahrenheit(0));
        System.out.println(toFahrenheit(37.5));
        System.out.println(toFahrenheit(-40));

        // Problem 2
        System.out.println(percent(45, 60));
        System.out.println(percent(1, 3));

        // Problem 3
        System.out.println(describeInt(255));
        System.out.println(describeInt(8));

        // Problem 4
        int px = 1, py = 2;
        swap(px, py);
        System.out.println("outside: x=" + px + " y=" + py);
        // (Problem 4): Java passes primitive arguments by value, so swap only modified
        // local copies a and b; px and py in main remained unchanged.

        // Problem 5
        StringBuilder nameBuilder = new StringBuilder("Rao");
        addTitle(nameBuilder);
        System.out.println(nameBuilder);
        String nameStr = "Rao";
        addTitleToString(nameStr);
        System.out.println(nameStr);
        System.out.println(addTitleToString(nameStr));
        // (Problem 5): StringBuilder is mutable, so mutating through the passed
        // reference modified the shared object in place. String is immutable, and
        // addTitleToString returns a new String rather than modifying the original.

        // Problem 6
        System.out.println(countChar("banana", 'a'));
        System.out.println(countChar("banana", 'z'));
        System.out.println(capitalize("jAVA"));

        // Problem 7
        System.out.println(padLeft("42", 5, '0'));
        System.out.println(padLeft("12345", 3, '0'));
        System.out.println(joinWithDash("ab", 3));
        System.out.println(joinWithDash("x", 1));

        // Problem 8
        System.out.println(roundHalfUp(2.5));
        System.out.println(roundHalfUp(2.4));
        System.out.println(roundHalfUp(7.0));

        // Problem 9
        System.out.println(factorialInt(5));
        System.out.println(factorialLong(5));
        System.out.println(factorialInt(13));
        System.out.println(factorialLong(13));
        System.out.println(factorialLong(20));
        // (Problem 9): 13! is 6,227,020,800, which exceeds Integer.MAX_VALUE
        // (2,147,483,647) and overflows the 32-bit signed int to 1932053504.

        // Problem 10
        System.out.println(summarize("Hello World"));
        System.out.println(summarize("Sky"));

        // Summary:
        // Primitives passed by value (copies of values): 1.1, 1.2, 1.3, 2.2, 3.1, 3.2, 3.4,
        // 4.1 (int/double/char/long), 5.1, 8.3 (boolean), 9.1 (int/double), and Problems
        // 1, 2, 3, 4, 6 (char), 7 (int/char), 8, 9, 10.
        // References passed by value (copies of object references): 1.1 (String), 2.1 (String),
        // 2.3 (Integer), 2.4 (Integer), 4.1 (String), 5.2 (StringBuilder), 5.3 (StringBuilder),
        // 5.4 (String), 6.3 (String), 7.1 (String), 7.2 (String), 7.3 (String), 7.4 (String),
        // 8.1 (String), 8.2 (String), 8.4 (StringBuffer, String), 9.1 (String), and Problems
        // 5 (StringBuilder, String), 6 (String), 7 (String), 10 (String).
    }

    // Section A Methods

    // 1.1
    public static void printProfile(String name, int age, double height, boolean student, char grade) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Student: " + student);
        System.out.println("Grade: " + grade);
    }

    // 1.2
    public static double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    // 1.3
    public static boolean fitsInByte(int value) {
        return value >= -128 && value <= 127;
    }

    // 2.1
    public static int addTexts(String a, String b) {
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    // 2.2
    public static Integer boxTwice(int x) {
        Integer boxed = x;
        return Integer.valueOf(boxed * 2);
    }

    // 2.3
    public static void describe(Integer n) {
        System.out.println("Binary: " + Integer.toBinaryString(n));
        System.out.println("Max: " + Integer.MAX_VALUE);
        System.out.println("Compare with 10.5: " + Double.compare(n, 10.5));
    }

    // 2.4
    public static boolean sameValue(Integer a, Integer b) {
        return a.equals(b);
    }

    // 3.1
    public static int truncate(double d) {
        return (int) d;
    }

    // 3.2
    public static double widen(int i) {
        return i;
    }

    // 3.3
    public static void overflowDemo() {
        int big = 130;
        byte b = (byte) big;
        System.out.println(b);
        // Comment (3.3): 130 is 2 more than the byte maximum of 127, so it wraps:
        // 130 - 256 = -126.
    }

    // 3.4
    public static char shiftLetter(char c, int by) {
        return (char) (c + by);
    }

    // 4.1
    public static void describeValue(int value) {
        System.out.println("int: " + value);
    }

    public static void describeValue(double value) {
        System.out.println("double: " + value);
    }

    public static void describeValue(String value) {
        System.out.println("String: " + value);
    }

    // 5.1
    public static void tryChange(int n) {
        n = 99;
    }

    // 5.2
    public static void appendBang(StringBuilder sb) {
        sb.append("!");
    }

    // 5.3
    public static void replaceBuilder(StringBuilder sb) {
        sb = new StringBuilder("New");
    }

    // 5.4
    public static void shout(String s) {
        s = s.toUpperCase();
    }

    // 6.2
    public static void compareRefs() {
        String s1 = "java";
        String s2 = "java";
        String s3 = new String("java");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        // (6.2): The first is true because both literals share one pooled object.
    }

    // 6.3
    public static int safeLength(String s) {
        return s == null ? -1 : s.length();
    }

    // 7.1
    public static String initials(String first, String last) {
        char f = Character.toUpperCase(first.charAt(0));
        char l = Character.toUpperCase(last.charAt(0));
        return "" + f + l;
    }

    // 7.2
    public static String clean(String raw) {
        return raw.trim().toLowerCase();
    }

    // 7.3
    public static boolean isPalindromeWord(String w) {
        String reversed = new StringBuilder(w).reverse().toString();
        return w.equalsIgnoreCase(reversed);
    }

    // 7.4
    public static String maskEmail(String email) {
        int atIndex = email.indexOf('@');
        String local = email.substring(0, atIndex);
        String domain = email.substring(atIndex);
        String maskedLocal = local.charAt(0) + "*".repeat(Math.max(0, local.length() - 1));
        return maskedLocal + domain;
    }

    // 8.1
    public static String buildCsv(String a, String b, String c) {
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(",").append(b).append(",").append(c);
        return sb.toString();
    }

    // 8.2
    public static String edit(String text) {
        StringBuilder sb = new StringBuilder(text);
        sb.insert(0, "[");
        sb.append("]");
        sb.replace(7, 12, "Java");
        sb.deleteCharAt(6);
        return sb.toString();
    }

    // 8.3
    public static long timeJoin(boolean useBuilder) {
        long start = System.nanoTime();
        if (useBuilder) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 20_000; i++) {
                sb.append("x");
            }
        } else {
            String str = "";
            for (int i = 0; i < 20_000; i++) {
                str += "x";
            }
        }
        return System.nanoTime() - start;
    }

    // 8.4
    public static String safeAppend(StringBuffer sb, String part) {
        sb.append(part);
        return sb.toString();
    }

    // 9.1
    public static String formatReceipt(String customer, int quantity, double unitPrice) {
        double total = quantity * unitPrice;
        int whole = (int) total;
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customer.toUpperCase()).append("\n")
          .append("Qty: ").append(quantity).append(" | Price: ").append(unitPrice).append("\n")
          .append("Total: ").append(total).append(" (whole: ").append(whole).append(")");
        return sb.toString();
    }

    // Section B Methods

    // Problem 1
    public static double toFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    // Problem 2
    public static int percent(int obtained, int total) {
        return (int) (((double) obtained / total) * 100);
    }

    // Problem 3
    public static String describeInt(int n) {
        return n + " -> binary " + Integer.toBinaryString(n)
                + ", hex " + Integer.toHexString(n)
                + ", octal " + Integer.toOctalString(n);
    }

    // Problem 4
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("inside: a=" + a + " b=" + b);
    }

    // Problem 5
    public static void addTitle(StringBuilder name) {
        name.insert(0, "Dr. ");
    }

    public static String addTitleToString(String name) {
        return "Dr. " + name;
    }

    // Problem 6
    public static int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static String capitalize(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }

    // Problem 7
    public static String padLeft(String s, int width, char fill) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + s.length() < width) {
            sb.append(fill);
        }
        sb.append(s);
        return sb.toString();
    }

    public static String joinWithDash(String s, int times) {
        if (times <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < times; i++) {
            sb.append("-").append(s);
        }
        return sb.toString();
    }

    // Problem 8
    public static int roundHalfUp(double d) {
        return (int) (d + 0.5);
    }

    // Problem 9
    public static int factorialInt(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialLong(int n) {
        long result = 1L;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Problem 10
    public static int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static String summarize(String text) {
        int vowels = countVowels(text);
        StringBuilder sb = new StringBuilder();
        sb.append("Length: ").append(text.length())
          .append(" | Upper: ").append(text.toUpperCase())
          .append(" | Vowels: ").append(vowels);
        return sb.toString();
    }
}
