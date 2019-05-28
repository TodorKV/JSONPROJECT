import com.google.gson.Gson;
import readers.ReadFile;
import readers.ReadFileIMPL;
import userandreport.Report;
import userandreport.User;
import writer.WriteToFile;
import writer.WriteToFileIMPL;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program {
    private static final String pathToResult = "E:\\intelij projects\\JsonProject\\src\\main\\resources\\result";
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();
        String path1, path2;
        path1 = scanner.nextLine();
        path2 = scanner.nextLine();
        scanner.close();

        ReadFile rdf = new ReadFileIMPL();
        String jsonString = rdf.readFile(path1);

        PrintWriter printWriter = new PrintWriter(new FileWriter(pathToResult));
        User[] users = gson.fromJson(jsonString,User[].class);

        jsonString = rdf.readFile(path2);
        Report report = gson.fromJson(jsonString,Report.class);

        WriteToFile writeToFile = new WriteToFileIMPL(report,users);
        writeToFile.WriteValidUsersToFile(printWriter);

    }
}
