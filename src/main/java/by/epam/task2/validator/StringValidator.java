package by.epam.task2.validator;

public interface StringValidator {

    static final String COORDINATES_REGEX = "(-?\\d+(\\.\\d+)?;){5}";

    boolean validateString(String stringAsCoordinates);

}
