package by.epam.task2.observer;

import by.epam.task2.entity.Point;
import by.epam.task2.entity.Tetraedr;
import by.epam.task2.exception.CustomException;
import by.epam.task2.observer.impl.TetraObserverImpl;
import by.epam.task2.warehouse.TetraParameters;
import by.epam.task2.warehouse.TetraWarehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TetraObserverImplTest {

    private TetraObserver observer;
    private Tetraedr tetraedr;
    private TetraEvent event;
    private TetraWarehouse warehouse;

    @BeforeMethod
    public void initialize() {
        observer = new TetraObserverImpl();
        tetraedr = new Tetraedr(new Point(1, 2,3),4,5);
        tetraedr.attach(observer);
        event = new TetraEvent(tetraedr);
        warehouse = TetraWarehouse.getInstance();
        warehouse.putParameters(tetraedr.getTetraId(), new TetraParameters(5, 5));
    }

    @Test
    public void testUpdateParamrters() throws CustomException {
        observer.updateParameters(event);
        TetraParameters actual = warehouse.getParameters(tetraedr.getTetraId());
        TetraParameters expected = new TetraParameters(27.71, 7.54);
        Assert.assertEquals(actual, expected);
    }

}
