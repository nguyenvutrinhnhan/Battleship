import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int busHeight = scanner.nextInt();
        int[] bridges = new int[scanner.nextInt()];
        for (int i = 0; i < bridges.length; i++) {
            bridges[i] = scanner.nextInt();
        }
        int result = 0;
        for (int i = 0; i < bridges.length; i++) {
            if (busHeight >= bridges[i]) {
                result = i + 1;
                break;
            }
        }
        System.out.println(result == 0 ? "Will not crash" : "Will crash on bridge " + result);
    }
}