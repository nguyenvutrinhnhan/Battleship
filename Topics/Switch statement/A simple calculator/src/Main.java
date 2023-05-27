import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        long number1 = scanner.nextLong();
        String operation = scanner.next();
        long number2 = scanner.nextLong();
        String result;
        switch (operation) {
            case "+":
                result = String.valueOf(number1 + number2);
                break;
            case "-":
                result = String.valueOf(number1 - number2);
                break;
            case "/":
                result = number2 == 0 ? "Division by 0!" : String.valueOf(number1 / number2);
                break;
            case "*":
                result = String.valueOf(number1 * number2);
                break;
            default:
                result = "Unknown operator";
                break;
        }
        System.out.println(result);
    }
}