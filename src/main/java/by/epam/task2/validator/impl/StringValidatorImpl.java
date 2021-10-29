package by.epam.task2.validator.impl;

import by.epam.task2.validator.StringValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidatorImpl implements StringValidator {

    private static final StringValidatorImpl instanse = new StringValidatorImpl();

    private StringValidatorImpl() {

    }

    public static StringValidatorImpl getInstance() {
        return instanse;
    }

    @Override
    public boolean validateString(String stringAsCoordinates) {
        Pattern pattern = Pattern.compile(COORDINATES_REGEX);
        Matcher matcher = pattern.matcher(stringAsCoordinates);
        return matcher.matches();
    }
}
