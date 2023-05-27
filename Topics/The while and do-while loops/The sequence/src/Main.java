import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int noElements = scanner.nextInt();
        int maxElementDiv4 = 0;
        while (noElements > 0) {
            int number = scanner.nextInt();
            if (number % 4 == 0 && number > maxElementDiv4) {
                maxElementDiv4 = number;
            }
            noElements--;
        }
        System.out.println(maxElementDiv4);
    }
}