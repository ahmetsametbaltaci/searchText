package tr.com.selenium.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {


    public static List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                list.add(st);
        } catch (IOException e) {
            throw new SeleniumExceptionHandle(e.getMessage());
        }finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
