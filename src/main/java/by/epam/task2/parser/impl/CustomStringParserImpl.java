package by.epam.task2.parser.impl;

import by.epam.task2.parser.Parser;

public class CustomStringParserImpl implements Parser {

    private static final String DELIMETER = ";";

    private static final CustomStringParserImpl instanse = new CustomStringParserImpl();

    private CustomStringParserImpl() {

    }

    public static CustomStringParserImpl getInstance() {
        return instanse;
    }

    public double[] stringParse(String str) {
        String[] numbersArray = str.split(DELIMETER);
        double[] numbers = new double[numbersArray.length];
        for (int i = 0; i < numbersArray.length; i++) {
            numbers[i] = Double.parseDouble(numbersArray[i]);
        }
        return numbers;
    }

}
