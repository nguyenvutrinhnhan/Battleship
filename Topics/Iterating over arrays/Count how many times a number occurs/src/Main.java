import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                result++;
            }
        }
        System.out.println(result);
    }
}