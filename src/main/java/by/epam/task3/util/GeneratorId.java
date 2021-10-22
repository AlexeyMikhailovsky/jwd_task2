package by.epam.task3.util;

public class GeneratorId {
    private static long counter;

    public static long generete() {
        return counter++;
    }
}
