package ygorgarofalo.SpringU2W2Project.exceptions;

public class NotFoundExc extends RuntimeException {

    public NotFoundExc(long id) {
        super("Item with id: " + id + " not found");
    }
}