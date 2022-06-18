package SingletonAbstractFactory.factory;
import SingletonAbstractFactory.Type;

/**
 * Abstract class to get factories.
 */
public abstract class AbstractFactory {
    public abstract Type getType(String compType);
}
