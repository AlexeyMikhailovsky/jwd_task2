package by.epam.task2.parser;

import by.epam.task2.parser.impl.CustomStringParserImpl;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

public class CustomStringParserImplTest {

    @Test
    public void stringParse()  {
        Parser parser = CustomStringParserImpl.getInstance();
        String string = "2.0;1.0;-6.0;5.2;0.8;";
        double[] actual = parser.stringParse(string);
        double[] expected = {2.0,1.0,-6.0,5.2,0.8};
        boolean condition = Arrays.equals(actual, expected);
        Assert.assertTrue(condition);
    }
}
