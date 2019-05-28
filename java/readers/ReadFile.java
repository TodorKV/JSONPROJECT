package readers;

import java.io.FileNotFoundException;

public interface ReadFile {

    String readFile(String path) throws FileNotFoundException;
}
