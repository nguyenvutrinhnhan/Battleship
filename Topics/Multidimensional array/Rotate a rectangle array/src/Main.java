import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        // [0,0] [0,1] [0,2]
        // [1,0] [1,1] [1,2]
        // =>
        // [1,0] [0,0]
        // [1,1] [0,1]
        // [1,2] [0,2]
        // 2x3 => 3x2
        // m-1 = 2 array[2,0] =
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}