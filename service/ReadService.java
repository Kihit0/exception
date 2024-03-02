package homework.src.service;

import java.io.*;
import java.util.Scanner;

public class ReadService {
    public void tryReadFile(String payload) throws IOException{
        BufferedReader reader = new BufferedReader( new FileReader(String.format("db/%s.txt", payload)));
        Scanner scanner = new Scanner(reader);

        int count = 1;
        System.out.println("=====================================");
        while(scanner.hasNextLine()){
            System.out.printf("%d: %s \n", count, scanner.nextLine());
            count++;
        }
        System.out.println("=====================================");
        reader.close();

    }
}
