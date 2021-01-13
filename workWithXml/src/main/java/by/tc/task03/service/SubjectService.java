package by.tc.task03.service;

import by.tc.task03.entity.Subject;

public class SubjectService {

    private static final String FIND_ENDING_TAG_BRACKET = ">";
    private static final String FIND_OPENING_TAG_BRACKET = "<";
    private static final String BACKSPACE = " ";//используется для разных задач, значит имеет обобщенное название символа
    private static final String FIND_SINGLE_IDENTIFIER_LABEL = "'";
    private static final String FIND_DOUBLE_IDENTIFIER_LABEL = "\"";

    private Subject findOnlyNameInString(String resultingString) {//Получаем только имя переменной
        Subject returnedSubjectName = new Subject();
        String[] temp = resultingString.split(FIND_OPENING_TAG_BRACKET);
        String returnedString = temp[1];
        temp = returnedString.split(FIND_ENDING_TAG_BRACKET);
        returnedSubjectName.setSubjectName(temp[0]);
        returnedSubjectName.setSubjectValue(BACKSPACE);
        return returnedSubjectName;
    }

    private Subject findNameAndValueInString(String resultingString) {//Получаем имя переменное и её значение

        Subject subject = new Subject();
        String valueSubject;
        String nameSubject;

        String[] tempGetValue = resultingString.split(FIND_DOUBLE_IDENTIFIER_LABEL);
        valueSubject = tempGetValue[1];

        String[] tempGetName = resultingString.split(FIND_OPENING_TAG_BRACKET);
        tempGetName = tempGetName[1].split(BACKSPACE);
        nameSubject = tempGetName[0];

        subject.setSubjectName(nameSubject);
        subject.setSubjectValue(valueSubject);

        return subject;
    }

    public Subject discoverNameAndValueSubject(String str) {
        Subject subject = new Subject();
        if (str.contains(FIND_SINGLE_IDENTIFIER_LABEL) || str.contains(FIND_DOUBLE_IDENTIFIER_LABEL)) {
            subject.setSubjectName(findNameAndValueInString(str).getSubjectName());
            subject.setSubjectValue(findNameAndValueInString(str).getSubjectValue());
            // ' and " означают о наличии значения присвоеного объекту
        } else {
            subject.setSubjectName(findOnlyNameInString(str).getSubjectName());
            subject.setSubjectValue(findOnlyNameInString(str).getSubjectValue());
        }
        return subject;
    }

}
