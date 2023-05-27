import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int result = 0;
        for (int i = 0; i < size - 1; i++) {
            int temp = array[i] * array[i + 1];
            if (temp > result) {
                result = temp;
            }
        }
        System.out.println(result);
    }
}