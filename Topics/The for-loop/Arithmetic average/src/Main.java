import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double result = 0;
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % 3 == 0 ) {
                result += i;
                count++;
            }
        }
        System.out.println(result / count);
    }
}