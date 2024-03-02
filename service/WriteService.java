package homework.src.service;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteService {

    public void tryWriteInFile(String data) throws IOException{
        String lastName = data.split(" ")[0];
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.format("db/%s.txt", lastName), true));
        writer.append(data);
        writer.newLine();
        writer.close();

    }
}
