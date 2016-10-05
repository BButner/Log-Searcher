import java.io.Console;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Console console = System.console();

        for (;;) {
            try {
                Reader.readFile(console.readLine("Insert field to search for: "));
            } catch (IOException e) {
                console.printf("Error: %s", e.getMessage());
            }
        }

    }

}
