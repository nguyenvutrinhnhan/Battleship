import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int number;
        int sum = 0;
        boolean isValid = true;
        do {
            number = scanner.nextInt();
            if (isValid) {
                sum += number;
                if (sum >= 1000) {
                    isValid = false;
                    sum -= 1000;
                }
            }
        } while (number != 0);
        System.out.println(sum);
    }
}