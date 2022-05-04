package daos;

/**
 * An abstract Data Access Object class
 * which specifies the functionality required
 * to interact with a data store and implemented
 * in concrete subclasses
 */
public abstract class DAO<E> {

    public abstract void loadFromFile(String filename);
    public abstract void writeToFile(String filename);
    public abstract void add(E theData);
    public abstract void update(E theData);
    public abstract void findData(double theData);
    public abstract E getData(String theData);
    public abstract void removeData(int theData);
}