import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int group1 = scanner.nextInt();
        int group2 = scanner.nextInt();
        int group3 = scanner.nextInt();
        int table1 = group1 / 2 + group1 % 2;
        int table2 = group2 / 2 + group2 % 2;
        int table3 = group3 / 2 + group3 % 2;
        int result = table1 + table2 + table3;
        System.out.println(result);
    }
}