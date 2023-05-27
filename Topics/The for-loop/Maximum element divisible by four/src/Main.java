import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int noElements = scanner.nextInt();
        int maxNumberDivBy4 = 0;
        for (int i = 0; i < noElements; i++) {
            int number = scanner.nextInt();
            if (number % 4 == 0 && number > maxNumberDivBy4) {
                maxNumberDivBy4 = number;
            }
        }
        System.out.println(maxNumberDivBy4);
    }
}