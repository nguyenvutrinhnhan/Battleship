import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        int result = 0;
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            result += array[i];
        }
        System.out.println(result);
    }
}