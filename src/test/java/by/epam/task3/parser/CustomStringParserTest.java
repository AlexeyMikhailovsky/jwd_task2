package by.epam.task3.parser;

import by.epam.task3.exception.CustomException;
import by.epam.task3.reader.CustomFileReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomStringParserTest {

    @Test
    public void stringParse() throws CustomException {

        String string = "-4.0;8.0;5.0;1.4;1.6;";
        double[] actual = CustomStringParser.stringParse(string);
        double[] expected = { -4.0,8.0,5.0,1.4,1.6};
        boolean condition = Arrays.equals(actual, expected);

        Assert.assertTrue(condition);

    }

}
