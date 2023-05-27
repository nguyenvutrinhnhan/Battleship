import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String inputText = reader.readLine().trim();
        System.out.println(inputText.isEmpty() ? 0 : inputText.split("\\s+").length);
        reader.close();
    }
}