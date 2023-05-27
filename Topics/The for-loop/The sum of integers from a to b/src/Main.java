import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = 0;
        while (a <= b) {
            sum += a++;
        }
        System.out.println(sum);
    }
}