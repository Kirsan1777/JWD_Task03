package by.tc.task03.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public List<String> readXmlFile() throws IOException {
        List<String> listWithAllSubjects = new ArrayList<>();

        FileReader fileReader = new FileReader("D:\\Java\\workWithXml\\src\\main\\resources\\test.xml");
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                listWithAllSubjects.add(s);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

        return listWithAllSubjects;
    }

}
