import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String shape = scanner.next();
        double a;
        double b;
        double c;
        double result = 0;
        switch (shape) {
            case "triangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();
                double s = (a + b + c) / 2;
                result = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                break;
            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                result = a * b;
                break;
            case "circle":
                double r = scanner.nextDouble();
                result = 3.14 * Math.pow(r, 2);
                break;
            default:
                break;
        }
        System.out.println(result);
    }
}