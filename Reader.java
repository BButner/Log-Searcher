import java.io.*;
import java.util.ArrayList;

public class Reader {

    public static void readFile(String input) throws IOException {
        String[] inputTest = input.split(" ");
        if (inputTest.length < 2) {
            int lineCount = 0;

            ArrayList<String> lines = new ArrayList<>();
            File folder = new File(System.getProperty("user.dir"));
            File sortFolder = new File(System.getProperty("user.dir") + "/Sorted");
            if (!sortFolder.exists()) {
                sortFolder.mkdir();
            }
            File[] files = folder.listFiles();

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(sortFolder + File.separator + input + ".txt")));

            if (files.length == 0) {
                System.out.println("No file found!");
            } else {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile()) {
                        if (files[i].getName().contains(".txt")) {
                            BufferedReader reader = new BufferedReader(new FileReader(files[i]));

                            while (reader.ready()) {
                                lines.add(reader.readLine());
                            }

                            reader.close();

                            out.println(files[i].getName() + "\n");

                            for (int x = 0; x < lines.size() - 1; x++) {
                                String line = lines.get(x);

                                if (org.apache.commons.lang3.StringUtils.containsIgnoreCase(line, input)) {
                                    out.println(line);
                                    lineCount++;
                                }
                            }
                            out.println("\n");
                        }
                    }
                }
            }
            System.out.println("Search completed. Lines found: " + lineCount);
            out.close();
        } else {
            System.out.println("Please only insert one argument!");
        }
    }
}
