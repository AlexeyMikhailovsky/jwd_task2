package by.epam.task3.reader;

import by.epam.task3.exception.CustomException;
import by.epam.task3.validator.impl.StringValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReader {

    private final static Logger logger = LogManager.getLogger();

    public static List<String> read(String pathToFile) throws CustomException {
        List<String> list;
        Path path = Paths.get(pathToFile);
        try(Stream<String> streamFromFile = Files.lines(path)) {
            StringValidatorImpl validator = StringValidatorImpl.getInstance();
            list = streamFromFile
                    .filter(s -> validator.validateString(s))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new CustomException("File not found " + pathToFile,e);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
            throw new CustomException(ex.getMessage());
        }
        return list;
    }
}
