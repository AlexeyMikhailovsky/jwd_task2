package by.epam.task3.main;

import by.epam.task3.comparator.TetraHighComparator;
import by.epam.task3.entity.Point;
import by.epam.task3.entity.Tetraedr;
import by.epam.task3.exception.CustomException;
import by.epam.task3.factory.TetraFactory;
import by.epam.task3.filler.impl.RepositoryFiller;
import by.epam.task3.filler.impl.WarehouseFiller;
import by.epam.task3.observer.impl.TetraObserverImpl;
import by.epam.task3.parser.CustomStringParser;
import by.epam.task3.reader.CustomFileReader;
import by.epam.task3.repository.impl.IdSpecification;
import by.epam.task3.repository.impl.TetraRepositoryImpl;
import by.epam.task3.warehouse.TetraWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Main
{
    static Logger logger = LogManager.getLogger();

    public static void main( String[] args )
    {
        try{
            RepositoryFiller repositoryService = new RepositoryFiller();
            WarehouseFiller warehouseService = new WarehouseFiller();
            List<String> str = CustomFileReader.read("resources/file.txt");
            String string = String.join(" ",str);
            double [] arr = CustomStringParser.stringParse(string);
            List<double[]> la = Arrays.asList(arr);
            List<Tetraedr> ll = TetraFactory.createTetraList(la);
            repositoryService.fillAll(ll);
            /*warehouseService.fillConeWarehouse(arr);*/
            Point point = new Point(-2,4,4);
          //  repositoryService.fillOne(1,2,3,4,10);
          //  repositoryService.fillConeRepository(point,3.4,5.6);
         //   warehouseService.fillConeWarehouse(point,3.4,5.6);

            TetraWarehouse warehouse = TetraWarehouse.getInstance();
            TetraRepositoryImpl repositoryimpl = TetraRepositoryImpl.getInstance();
            System.out.println(repositoryimpl.get(0));
          //  System.out.println(repositoryimpl.get(1));
         //   System.out.println(repositoryimpl.get(2));

            TetraObserverImpl observer = new TetraObserverImpl();
         //   repositoryimpl.get(1).attach(observer);
            repositoryimpl.get(0).setHeight(0.5);
            System.out.println(warehouse.getParameters(0L));
        //    System.out.println(warehouse.getParameters(2L));
        //    System.out.println(warehouse.getParameters(3L));

            System.out.println(repositoryimpl.sort(new TetraHighComparator()));
            System.out.println(repositoryimpl.query(new IdSpecification(1)));
        }catch (CustomException e) {
            logger.error(e);
            e.printStackTrace();
        }
    }
}
