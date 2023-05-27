import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();
        boolean result;
        if (h1 > h2) {
            result = h2 >= h3 ? true : false;
        } else if (h1 == h2) {
            result = true;
        } else {
            result = h2 <= h3 ? true : false;
        }
        System.out.println(result);
    }
}