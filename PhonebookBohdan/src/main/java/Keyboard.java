
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Keyboard {
    private static final BufferedReader keyboard =
            new BufferedReader(new InputStreamReader(System.in));

    public static String readString() {
        String line = null;

        try {
            line = keyboard.readLine();
        }
        catch(IOException e) {
            show("Помилка читання рядка символів.");
        }

        return line;
    }

    public static int readInteger() {
        int integer = 0;
        String line = readString();

        if(line != null) integer = Integer.parseInt(line);

        return integer;

    }

    public static float readFloat() {
        float real = 0.0f;
        String line = readString();

        if(line != null) real = Float.parseFloat(line);

        return real;
    }

    public static double readDouble() {
        double real = 0.0;
        String line = readString();

        if(line != null) real = Double.parseDouble(line);

        return real;
    }

    private static void show(String line) {
        System.err.println(line);
    }
}