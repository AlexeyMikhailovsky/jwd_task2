package by.epam.task3.observer;

import by.epam.task3.entity.Tetraedr;
import java.util.EventObject;

public class TetraEvent extends EventObject {

    public TetraEvent(Tetraedr source) {
        super(source);
    }

    @Override
    public Tetraedr getSource() {
        return (Tetraedr) super.getSource();
    }

}
