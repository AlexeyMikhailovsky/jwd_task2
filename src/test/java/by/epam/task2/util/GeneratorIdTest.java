package by.epam.task2.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneratorIdTest {

    @Test
    public void generate() {
        long actual = 0;
        long expected = 10;
        for (int i = 0; i <= expected; i++) {
            actual = GeneratorId.generete();
        }
        Assert.assertEquals(actual, expected);
    }
}
