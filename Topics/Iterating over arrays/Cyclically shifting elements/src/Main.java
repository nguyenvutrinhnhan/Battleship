import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int length = scanner.nextInt();
        int[] a = new int[length];
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = scanner.nextInt();
            if (i == length - 1) {
                numbers[0] = a[i];
            } else {
                numbers[i + 1] = a[i];
            }
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}