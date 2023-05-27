import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int max = 0;
        int number;
        do {
            number = scanner.nextInt();
            max = number > max ? number : max;
        } while (number != 0);
        System.out.println(max);
    }
}