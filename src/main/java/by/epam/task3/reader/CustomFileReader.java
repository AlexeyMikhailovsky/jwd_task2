package by.epam.task3.reader;

import by.epam.task3.exception.CustomException;
import java.util.List;

public interface CustomFileReader {

    List<String> read(String pathToFile) throws CustomException;

}
