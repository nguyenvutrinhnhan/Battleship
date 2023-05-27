import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int number = scanner.nextInt();
        while (number != 1) {
            System.out.print(number + " ");
            number = (number % 2 == 0) ? number / 2 : number * 3 + 1;
        }
        System.out.print(1);
    }
}