package practice.assignment;

public class Test {
    static void modify(int x) {
        x = 100;
    }

    static void modifyArray(int[] arr) {
        arr[0] = 100;
    }

    static void reassignArray(int[] arr) {
        // Reassigns local reference copy 'arr', not the caller's 'numbers' reference
        arr = new int[]{999, 888, 777};
    }

    public static void main(String[] args) {
        int a = 10;
        int[] numbers = {10, 20, 30};

        modify(a);
        modifyArray(numbers);

        System.out.println(a);           // 10
        System.out.println(numbers[0]); // 100

        reassignArray(numbers);
        System.out.println(numbers[0]); // Still 100
    }
}
