import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        // You can use scanner.nextBoolean() to read a boolean value
        System.out.println(isSuccessfulParty(scanner.nextInt(), scanner.nextBoolean()));
    }

    public static boolean isSuccessfulParty(int noButterCups, boolean isWeekend) {
        boolean result = false;
        if (noButterCups >= 10 && noButterCups <= 25) {
            if (noButterCups <= 20 && !isWeekend) {
                return true;
            }
            if (noButterCups >= 15 && isWeekend) {
                return true;
            }
        }
        return result;
    }
}