import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String result;
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                result = "You have chosen a square";
                break;
            case 2:
                result = "You have chosen a circle";
                break;
            case 3:
                result = "You have chosen a triangle";
                break;
            case 4:
                result = "You have chosen a rhombus";
                break;
            default:
                result = "There is no such shape!";
                break;
        }
        System.out.println(result);
    }
}