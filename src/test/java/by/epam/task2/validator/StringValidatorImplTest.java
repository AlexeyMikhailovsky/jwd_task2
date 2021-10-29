package by.epam.task2.validator;

import by.epam.task2.validator.impl.StringValidatorImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringValidatorImplTest {

    public StringValidator validator = StringValidatorImpl.getInstance();

    @DataProvider(name = "Strings")
    public Object[][] createData() {
        return new Object[][] {
                { "3.2;-1.9;2.2;1.5;7;", true },
                { "0;1;0;0;0;", true },
                { "1;2;3;4;5;", true },
                { "-8;-6;-7;-9;-5;", true },
                { "2;5.1;1.0;", false },
                { "13;12f;11.5;c;", false },
                { "2.1;1.25.5;2;6;", false }, };
    }

    @Test(dataProvider = "Strings")
    public void testValidateString(String str, boolean expected) {
        boolean actual = validator.validateString(str);
        Assert.assertEquals(actual, expected);
    }
}
