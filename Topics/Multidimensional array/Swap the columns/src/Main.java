import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int col1 = scanner.nextInt();
        int col2 = scanner.nextInt();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == col1) {
                    System.out.print(array[i][col2] + " ");
                    continue;
                }
                if (j == col2) {
                    System.out.print(array[i][col1] + " ");
                    continue;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}