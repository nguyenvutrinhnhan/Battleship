import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int number = scanner.nextInt();
        int square = 0;
        for (int i = 1; square <= number; i++) {
            square = i * i;
            if (square <= number) {
                System.out.println(square);
            }
        }
    }
}