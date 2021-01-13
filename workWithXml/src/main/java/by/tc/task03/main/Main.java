package by.tc.task03.main;


import by.tc.task03.entity.Element;
import by.tc.task03.service.ElementService;
import by.tc.task03.service.FileService;
import by.tc.task03.validator.ValidatorInformation;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        ElementService elementService = new ElementService();
        FileService fileReader = new FileService();
        ValidatorInformation validator = new ValidatorInformation();
        Element element;
        List<String> listFile = fileReader.readXmlFile();

        element = elementService.findAllElementsInFile(validator.editInformationInTheSourceFileXml(listFile));
        PrintElementInfo.print(element);

    }
}
