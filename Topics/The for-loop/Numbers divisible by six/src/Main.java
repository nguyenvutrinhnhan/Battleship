import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int[] array = new int[scanner.nextInt()];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (array[i] % 6 == 0) {
                sum += array[i];
            }
        }
        System.out.println(sum);
    }
}