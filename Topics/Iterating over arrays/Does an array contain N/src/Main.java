import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int number = scanner.nextInt();
        boolean result = false;
        for (int value : array) {
            if (value == number) {
                result = true;
                break;
            }
        }
        System.out.println(result);
    }
}