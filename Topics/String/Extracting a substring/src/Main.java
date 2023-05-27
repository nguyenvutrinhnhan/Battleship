import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String string = scanner.nextLine();
        int begin = scanner.nextInt();
        int end = scanner.nextInt() + 1;
        System.out.println(string.substring(begin, end));
    }
}