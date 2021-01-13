package by.tc.task03.service;

import by.tc.task03.entity.Attribute;

public class AttributeService {

    private static final String FIND_START_TAG = "<";
    private static final String FIND_END_TAG = ">";
    private static final char FIND_OPENING_BRACKET = '<';
    private static final char FIND_END_BRACKET = '>';


    public Attribute processInformationAttribute(String line) { 
        Attribute attribute = new Attribute();
        String tempProcessingResult;
        String[] result = line.split(FIND_END_TAG);
        tempProcessingResult = result[0];
        String[] resultName = tempProcessingResult.split(FIND_START_TAG);
        tempProcessingResult = result[1];
        String[] resultValue = tempProcessingResult.split(FIND_START_TAG);
        attribute.setNameAttribute(resultName[1]);
        attribute.setValueAttribute(resultValue[0]);
        return attribute;
    }

    public boolean isStringWithAttribute(String str) {
        int countLeft = 0, countRight = 0;
        for (char element : str.toCharArray()) {
            if (element == FIND_OPENING_BRACKET) countLeft++;
            if (element == FIND_END_BRACKET) countRight++;
        }
        return countLeft == 2;
    }

}
