import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int days = scanner.nextInt();
        int costFoodPerDay = scanner.nextInt();
        int costFlightOneWay = scanner.nextInt();
        int costOneNightPerDay = scanner.nextInt();
        int totalMoney = days * costFoodPerDay + costFlightOneWay * 2 + (days - 1) * costOneNightPerDay;
        System.out.println(totalMoney);
    }
}