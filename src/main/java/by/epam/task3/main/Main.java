package by.epam.task3.main;

import by.epam.task3.comparator.TetraHeightComparator;
import by.epam.task3.entity.Point;
import by.epam.task3.entity.Tetraedr;
import by.epam.task3.exception.CustomException;
import by.epam.task3.factory.TetraFactory;
import by.epam.task3.filler.Filler;
import by.epam.task3.filler.impl.RepositoryFillerImpl;
import by.epam.task3.filler.impl.WarehouseFillerImpl;
import by.epam.task3.observer.impl.TetraObserverImpl;
import by.epam.task3.parser.impl.CustomStringParserImpl;
import by.epam.task3.parser.Parser;
import by.epam.task3.reader.CustomFileReader;
import by.epam.task3.reader.impl.CustomFileReaderImpl;
import by.epam.task3.repository.impl.IdSpecification;
import by.epam.task3.repository.impl.TetraRepositoryImpl;
import by.epam.task3.warehouse.TetraWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CustomException {

        Parser parser = CustomStringParserImpl.getInstance();
        CustomFileReader reader = CustomFileReaderImpl.getInstance();
        Filler repositoryFillerImpl = new RepositoryFillerImpl();
        Filler warehouseFillerImpl = new WarehouseFillerImpl();

        List<String> strings = reader.read("resources/file.txt");
        double[] arr = parser.stringParse(strings.get(0));
        List<double[]> doubleList = Arrays.asList(arr);

        List<Tetraedr> tetraList = TetraFactory.createTetraedrList(doubleList);
        repositoryFillerImpl.fillAll(tetraList);
        Point point = new Point(1, 2, 3);
        Tetraedr tetraedr = new Tetraedr(point, 4, 5);
        warehouseFillerImpl.fillOne(tetraedr);
        repositoryFillerImpl.fillOne(tetraedr);
        repositoryFillerImpl.fillOne(new Tetraedr(new Point(5, 7, 8), 2, 1));
        repositoryFillerImpl.fillOne(new Tetraedr(new Point(2, 8, 5), 2, 9));
        warehouseFillerImpl.fillOne(new Tetraedr(new Point(1, 9, 2), 2, 2));

        TetraWarehouse warehouse = TetraWarehouse.getInstance();
        TetraRepositoryImpl repositoryimpl = TetraRepositoryImpl.getInstance();
        logger.info(repositoryimpl.get(0));
        logger.info(repositoryimpl.get(1));
        logger.info(repositoryimpl.get(2));
        logger.info(repositoryimpl.get(3));

        TetraObserverImpl observer = new TetraObserverImpl();
        repositoryimpl.get(0).attach(observer);
        repositoryimpl.get(0).setEdge(9);
        repositoryimpl.get(1).setEdge(2);
        repositoryimpl.get(1).attach(observer);
        repositoryimpl.get(1).setHeight(7);

        logger.info(warehouse.getParameters(0L));
        logger.info(warehouse.getParameters(1L));
        logger.info(warehouse.getParameters(2L));
        logger.info(warehouse.getParameters(3L));

        logger.info(repositoryimpl.sort(new TetraHeightComparator()));
        logger.info(repositoryimpl.query(new IdSpecification(1)));
    }
}
