import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String str = scanner.next();
        boolean result = "J".equalsIgnoreCase(String.valueOf(str.charAt(0)));
        System.out.println(result);
    }
}