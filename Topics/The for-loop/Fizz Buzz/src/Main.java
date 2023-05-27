import java.util.Scanner;

class Main {

    public static final int THREE = 3;
    public static final int FIVE = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int begin = scanner.nextInt();
        int end = scanner.nextInt();
        for (int i = begin; i <= end; i++) {
            String output = "";
            if (i % THREE == 0) {
                output += "Fizz";
            }
            if (i % FIVE == 0) {
                output += "Buzz";
            }
            System.out.println(output.isEmpty() ? i : output);
        }
    }
}