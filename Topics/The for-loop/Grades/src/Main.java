import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int students = scanner.nextInt();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        while (students > 0) {
            String grade = scanner.next();
            switch (grade) {
                case "A":
                    a++;
                    break;
                case "B":
                    b++;
                    break;
                case "C":
                    c++;
                    break;
                case "D":
                    d++;
                    break;
                default:
                    break;
            }
            students--;
        }
        System.out.println(d + " " + c + " " + b + " " + a);
    }
}