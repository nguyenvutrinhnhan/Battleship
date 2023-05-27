import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String[] words = new String[5];
        for (int i = 0; i < words.length; i++) {
            words[i] = scanner.next();
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}