import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static final char  EMPTY_CHAR = '\u0000';

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        char[] array = new char[50];
        reader.read(array);
        for (int i = array.length - 1; i >= 0; i--) {
            if (EMPTY_CHAR == array[i]) {
                continue;
            }
            System.out.print(array[i]);
        }
        reader.close();
    }
}