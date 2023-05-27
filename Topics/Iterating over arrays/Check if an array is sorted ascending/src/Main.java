import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[scanner.nextInt()];
        boolean isSorted = true;
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            if (isSorted && i > 0 && array[i] < array[i - 1]) {
                isSorted = false;
            }
        }
        System.out.println(isSorted);
    }
}