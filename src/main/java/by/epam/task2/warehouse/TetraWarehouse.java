package by.epam.task2.warehouse;

import by.epam.task2.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TetraWarehouse {

    private static final Logger logger = LogManager.getLogger();

    private static TetraWarehouse instance;

    private Map<Long, TetraParameters> warehouse;

    private TetraWarehouse() {
        this.warehouse = new HashMap<Long, TetraParameters>();
    }

    public static TetraWarehouse getInstance() {
        if (instance == null) {
                instance = new TetraWarehouse();
        }
        return instance;
    }

    public Map<Long, TetraParameters> getWarehouse (){
        return Collections.unmodifiableMap(warehouse);
    }

    public TetraParameters putParameters(Long tetraId, TetraParameters tetraParam) {
        return warehouse.put(tetraId, tetraParam);
    }

    public TetraParameters getParameters(Long tetraId) throws CustomException {
        TetraParameters parameters = warehouse.get(tetraId);
        if (parameters == null) {
            logger.error("Tetraedr with such ID is not found - " + tetraId);
            throw new CustomException("Tetraedr with such ID is not found - "+ tetraId);
        }
        return parameters;
    }

    public TetraParameters remove(Long tetraId) {
        return warehouse.remove(tetraId);
    }

    public boolean updateParameters(long tetraId, double area, double volume) {
        TetraParameters parameters = this.warehouse.get(tetraId);
        if (parameters == null) {
            logger.error("Tetraedr with such ID is not found.");
            return false;
        }
        parameters.setArea(area);
        parameters.setVolume(volume);
        return true;
    }
}
