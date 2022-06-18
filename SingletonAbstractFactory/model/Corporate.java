package SingletonAbstractFactory.model;
import SingletonAbstractFactory.Type;

/**
 * Concrete class implements Type
 * Represents Corporate company.
 */
public class Corporate implements Type {


    // Create single instance Corporate object
    private static Corporate instance = new Corporate();

    // Constructor is private since we do not want to be instantiated.
    private Corporate() {}

    // Get only object available
    public static Corporate getInstance() {
        return instance;
    }

    @Override
    public void getAccountType() {
        System.out.println("Corporate");
    }
}
