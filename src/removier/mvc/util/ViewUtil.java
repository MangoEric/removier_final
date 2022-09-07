package removier.mvc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewUtil {

    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static String input(String inputMessage) {
        System.out.print(inputMessage);
        try {
            return BUFFERED_READER.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(Object object) {
        System.out.println(object);
    }


    public static void newLine() {
        System.out.println();
    }

    public static void errorMessage(String message) {
        System.out.println(message);
    }

}
