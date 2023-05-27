import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int choice = scanner.nextInt();
        String result;
        switch (choice) {
            case 1:
                result = "Yes!";
                break;
            case 2:
            case 3:
            case 4:
                result = "No!";
                break;
            default:
                result = "Unknown number";
                break;
        }
        System.out.println(result);
    }
}