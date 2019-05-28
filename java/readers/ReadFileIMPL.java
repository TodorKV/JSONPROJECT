package readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileIMPL implements ReadFile {
    @Override
    public String readFile(String path) throws FileNotFoundException {
        StringBuilder lines = new StringBuilder();
        Scanner scanner = new Scanner(new File(path));;
        while(scanner.hasNextLine()){
            lines.append(scanner.nextLine());
        }
        scanner.close();
        return lines.toString().trim();
    }
}
