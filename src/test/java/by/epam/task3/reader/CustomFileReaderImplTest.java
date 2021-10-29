package by.epam.task3.reader;

import by.epam.task3.exception.CustomException;
import by.epam.task3.reader.impl.CustomFileReaderImpl;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class CustomFileReaderImplTest {

    @Test
    public void readValues() throws CustomException {
        CustomFileReader reader = CustomFileReaderImpl.getInstance();
        List<String> actualList = reader.read("resources/file.txt");
        List<String> expectedList = List.of("2.1;6.4;2.7;6.4;2.6;");
        assertEquals(actualList, expectedList);
    }

}
