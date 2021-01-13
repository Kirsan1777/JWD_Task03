package by.tc.task03.service;

import by.tc.task03.entity.Attribute;
import by.tc.task03.entity.Element;
import by.tc.task03.entity.Subject;


import java.util.ArrayList;
import java.util.List;

public class ElementService {


    private static final String CLOSING_SUBJECT_SLASH = "/";

    //todo избавиться от магических значинй, расскидать большой метод на отдельные, сделать код красивым и хорошо читабельным
    public Element findAllElementsInFile(List<String> listWithAllElements) {
        List<Attribute> listWithAttribute = new ArrayList<>();
        List<Subject> listWithSubject = new ArrayList<>();
        Subject mainSubject = new Subject();
        Element mainElement = new Element();
        AttributeService attributeService = new AttributeService();
        SubjectService subjectService = new SubjectService();

        int count = 0;

        for (String str : listWithAllElements) {
            if (count == 0) {
                mainElement.setMainElementName(subjectService.discoverNameAndValueSubject(str).getSubjectName());
                count++;
            } else {
                count++;
                if (count == listWithAllElements.size()) {
                    mainElement.setListWithSubject(listWithSubject);
                    return mainElement;
                }

                if (attributeService.isStringWithAttribute(str)) {
                    listWithAttribute.add(attributeService.processInformationAttribute(str));
                }

                if (!attributeService.isStringWithAttribute(str)) {
                    if (str.contains(CLOSING_SUBJECT_SLASH)) {

                        mainSubject.setListWithAttribute(listWithAttribute);
                        listWithSubject.add(mainSubject);

                        mainSubject = new Subject();
                        listWithAttribute = new ArrayList<>();

                    } else {
                        mainSubject.setSubjectName(subjectService.discoverNameAndValueSubject(str).getSubjectName());
                        mainSubject.setSubjectValue(subjectService.discoverNameAndValueSubject(str).getSubjectValue());
                    }
                }
            }
        }
        return mainElement;
    }

}
