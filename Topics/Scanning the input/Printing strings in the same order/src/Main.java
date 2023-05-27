import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String word1 = scanner.next();

        String word2 = scanner.next();
        if (word2.isEmpty()) {
            scanner.nextLine();
            word2 = scanner.next();
        }

        String word3 = scanner.next();
        if (word3.isEmpty()) {
            scanner.nextLine();
            word3 = scanner.next();
        }

        String word4 = scanner.next();
        if (word4.isEmpty()) {
            scanner.nextLine();
            word4 = scanner.next();
        }

        System.out.println(word1);
        System.out.println(word2);
        System.out.println(word3);
        System.out.println(word4);
    }
}