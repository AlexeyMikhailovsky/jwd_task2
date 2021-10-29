package by.epam.task3.observer.impl;

import by.epam.task3.entity.Tetraedr;
import by.epam.task3.exception.CustomException;
import by.epam.task3.observer.TetraEvent;
import by.epam.task3.observer.TetraObserver;
import by.epam.task3.service.impl.TetraServiceImpl;
import by.epam.task3.warehouse.TetraParameters;
import by.epam.task3.warehouse.TetraWarehouse;
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
