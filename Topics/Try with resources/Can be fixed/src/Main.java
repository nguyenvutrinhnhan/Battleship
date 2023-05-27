import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        try (BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("I'm learning " + buffReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}