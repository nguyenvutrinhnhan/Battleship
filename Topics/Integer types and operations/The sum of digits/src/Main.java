import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number = scanner.nextInt();
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number = number / 10;
        }
        System.out.println(result);
    }
}