package by.epam.task3.parser;

public class CustomStringParser {

    private static final String DELIMETER = ";";

    public static double[] stringParse(String str) {
        String[] strArr = str.split(DELIMETER);
        double[] num = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            num[i] = Double.parseDouble(strArr[i]);
        }
        return num;
    }

}
