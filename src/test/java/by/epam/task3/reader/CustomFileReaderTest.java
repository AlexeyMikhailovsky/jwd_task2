package by.epam.task3.reader;

import by.epam.task3.exception.CustomException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomFileReaderTest {

    @Test
    public void readValues() throws CustomException {

        List<String> actualList = CustomFileReader.read("resources/file.txt");
        List<String> expectedList = List.of("-4.0;8.0;5.0;1.4;1.6;");
        assertEquals(actualList, expectedList);

    }

}
