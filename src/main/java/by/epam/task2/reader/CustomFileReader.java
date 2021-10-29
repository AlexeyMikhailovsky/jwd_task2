package by.epam.task2.reader;

import by.epam.task2.exception.CustomException;
import java.util.List;

public interface CustomFileReader {

    List<String> read(String pathToFile) throws CustomException;

}
