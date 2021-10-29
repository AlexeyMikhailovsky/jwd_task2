package by.epam.task2.filler;

import by.epam.task2.entity.Point;
import by.epam.task2.entity.Tetraedr;
import by.epam.task2.exception.CustomException;
import by.epam.task2.filler.impl.WarehouseFillerImpl;
import by.epam.task2.warehouse.TetraParameters;
import by.epam.task2.warehouse.TetraWarehouse;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseFillerTest {
    private Filler warehouseFiller = new WarehouseFillerImpl();

    @Test
    public void testFill() {
        List<Tetraedr> tetraedrs = new ArrayList<Tetraedr>();
        tetraedrs.add(new Tetraedr(new Point(1, 2,3),4,5));
        tetraedrs.add(new Tetraedr(new Point(1, 4,6), 8,10));
        tetraedrs.add(new Tetraedr(new Point(1, 6,3), 2,4));
        warehouseFiller.fillAll(tetraedrs);
        TetraWarehouse warehouse = TetraWarehouse.getInstance();
        Map<Long, TetraParameters> actual = warehouse.getWarehouse();
        Map<Long, TetraParameters> expected = new HashMap<Long, TetraParameters>();
        expected.put(0L, new TetraParameters(27.71, 7.54));
        expected.put(1L, new TetraParameters(110.85, 60.34));
        expected.put(2L, new TetraParameters(6.93, 0.94));
        Assert.assertEqualsDeep(actual, expected);
    }

    @Test
    public void testOne() throws CustomException {
        Tetraedr tetraedr = new Tetraedr(new Point(1, 2,3),4, 5);
        warehouseFiller.fillOne(tetraedr);
        TetraWarehouse warehouse = TetraWarehouse.getInstance();
        TetraParameters actual = warehouse.getParameters(tetraedr.getTetraId());
        TetraParameters expected = new TetraParameters(27.71, 7.54);
        Assert.assertEquals(actual, expected);
    }
}
