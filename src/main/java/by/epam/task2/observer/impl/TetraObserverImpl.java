package by.epam.task2.observer.impl;

import by.epam.task2.entity.Tetraedr;
import by.epam.task2.exception.CustomException;
import by.epam.task2.observer.TetraEvent;
import by.epam.task2.observer.TetraObserver;
import by.epam.task2.service.impl.TetraServiceImpl;
import by.epam.task2.warehouse.TetraParameters;
import by.epam.task2.warehouse.TetraWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetraObserverImpl implements TetraObserver {

    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateParameters(TetraEvent event) {
        Tetraedr tetraedr = event.getSource();
        long id = tetraedr.getTetraId();
        TetraWarehouse warehouse = TetraWarehouse.getInstance();
        TetraParameters parameters = null;
        try {
            parameters = warehouse.getParameters(id);
        } catch (CustomException e) {
            logger.error(e.getMessage());
        }
        TetraServiceImpl service = new TetraServiceImpl();
        double volume = service.tetraedrVolume(tetraedr);
        double area = service.tetraedrArea(tetraedr);
        parameters.setVolume(volume);
        parameters.setArea(area);
    }
}
