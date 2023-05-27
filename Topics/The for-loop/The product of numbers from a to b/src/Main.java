import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = 1;
        while (a < b) {
            result *= a++;
        }
        System.out.println(result);
    }
}