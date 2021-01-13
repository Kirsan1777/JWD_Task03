package by.tc.task03.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorInformation {

    private static final String FIND_PARENTHESES_CONNECTING_ATTRIBUTE = "><";
    private static final String ADD_ENDING_BRACKET = ">";
    private static final String ADD_OPENING_BRACKET = "<";
    private static final String WORD_SEPARATOR = " ";

    public List<String> editInformationInTheSourceFileXml(List<String> listWithBackgroundInformation) {
        List<String> listWithCorrectInformation;
        listWithCorrectInformation = checkClosingTag(listWithBackgroundInformation);
        listWithCorrectInformation = checkAttributeRecord(listWithCorrectInformation);
        return listWithCorrectInformation;
    }

    private List<String> checkAttributeRecord(List<String> listWithBackgroundInformation) {
        List<String> listWithCorrectInformation = new ArrayList<>();
        for (String str : listWithBackgroundInformation) {
            str = str.trim();
            if (str.contains(FIND_PARENTHESES_CONNECTING_ATTRIBUTE)) {

                listWithCorrectInformation.addAll(splitStringIntoSeparateElements(str));

            } else {
                listWithCorrectInformation.add(str);
            }
        }
        return listWithCorrectInformation;
    }

    private List<String> checkClosingTag(List<String> listWithBackgroundInformation) {
        List<String> listWithCorrectInformation = new ArrayList<>();

        for (int i = 0; i < listWithBackgroundInformation.size(); i++) {
            String str = listWithBackgroundInformation.get(i).trim();
            if (!str.endsWith(ADD_ENDING_BRACKET)) {
                str = str.concat(WORD_SEPARATOR).concat(listWithBackgroundInformation.get(i + 1).trim());
                i++;
            }
            listWithCorrectInformation.add(str);
        }
        return listWithCorrectInformation;
    }

    private List<String> splitStringIntoSeparateElements(String str){
        List<String> listWithCorrectInformation = new ArrayList<>();
        String[] rename = str.split(FIND_PARENTHESES_CONNECTING_ATTRIBUTE);

        for (int i = 0; i < rename.length; i++) {
            if (i == 0) {
                listWithCorrectInformation.add(rename[i].concat(ADD_ENDING_BRACKET));
            }
            else if (i == rename.length - 1) {
                listWithCorrectInformation.add(ADD_OPENING_BRACKET.concat(rename[i]));
            } else {
                listWithCorrectInformation.add(ADD_OPENING_BRACKET.concat(rename[i]).concat(ADD_ENDING_BRACKET));
            }
        }

        return listWithCorrectInformation;
    }

}
