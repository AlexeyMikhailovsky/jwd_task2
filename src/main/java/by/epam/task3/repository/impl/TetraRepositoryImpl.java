package by.epam.task3.repository.impl;

import by.epam.task3.entity.Tetraedr;
import by.epam.task3.repository.Specification;
import by.epam.task3.repository.TetraRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TetraRepositoryImpl implements TetraRepository {

    private static TetraRepositoryImpl instance;
    private List<Tetraedr> tetraList;
    public TetraRepositoryImpl() {
        tetraList = new ArrayList<>();
    }

    public static TetraRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new TetraRepositoryImpl();
        }
        return instance;
    }

    public List<Tetraedr> getTetraList() {
        return new ArrayList<Tetraedr>(tetraList);
    }

    public int size() {
        return tetraList.size();
    }

    public Tetraedr get(int index) {
        return tetraList.get(index);
    }

    @Override
    public void addTetraedr(Tetraedr tetra) {
        tetraList.add(tetra);
    }

    @Override
    public void addAllTetraedrs(List<Tetraedr> tetra) {
        tetraList.addAll(tetra);
    }

    @Override
    public boolean removeTetraedr(Tetraedr tetra) {
        return tetraList.remove(tetra);
    }

    @Override
    public boolean removeAllTetraedrs(List<Tetraedr> tetra) {
        return tetraList.removeAll(tetra);
    }

    @Override
    public List<Tetraedr> query(Specification specification) {
        List<Tetraedr> foundTetraeders = tetraList.stream().filter(e -> specification.specify(e))
                .collect(Collectors.toList());
        return foundTetraeders;
    }

    @Override
    public List sort(Comparator<Tetraedr> comparator) {
        List<Tetraedr> finalList = tetraList.stream().
                sorted(comparator).
                collect(Collectors.toList());
        return finalList;
    }
}
