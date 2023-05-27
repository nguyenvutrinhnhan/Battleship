import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int number = scanner.nextInt();
        boolean check1 = number > -15 && number <= 12;
        boolean check2 = number > 14 && number < 17;
        boolean check3 = number >= 19;
        boolean isValid = check1 || check2 || check3;
        System.out.println(isValid ? "True" : "False");
    }
}