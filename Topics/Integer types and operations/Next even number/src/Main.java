import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int input = scanner.nextInt();
        int result = input % 2 == 0 ? input + 2 : input + 1;
        System.out.println(result);
    }
}