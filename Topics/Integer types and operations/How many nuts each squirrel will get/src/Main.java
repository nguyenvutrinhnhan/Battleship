import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int noSquirrel = scanner.nextInt();
        int noNut = scanner.nextInt();
        int result = noNut / noSquirrel;
        System.out.println(result);
    }
}