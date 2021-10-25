package by.epam.task3.parser;

public class CustomStringParser{

    private static final String DELIMETER = ";";

    public static double[] stringParse(String str) {
        String[] numbersArray = str.split(DELIMETER);
        double[] numbers = new double[numbersArray.length];
        for (int i = 0; i < numbersArray.length; i++) {
            numbers[i] = Double.parseDouble(numbersArray[i]);
        }
        return numbers;
    }

}
