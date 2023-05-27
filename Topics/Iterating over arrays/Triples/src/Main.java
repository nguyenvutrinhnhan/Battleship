import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (i > 1 && array[i] - array[i - 1] == 1 && array[i - 1] - array[i - 2] == 1) {
                result++;
            }
        }
        System.out.println(result);
    }
}