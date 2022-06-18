package SingletonAbstractFactory.model;
import SingletonAbstractFactory.Type;

/**
 * Concrete class implementing Type.
 * Represents Single partner user company-sole trader.
 */
public class Sole implements Type {


    // Create single instance Sole object
    private static Sole instance = new Sole();

    // Constructor is private since we do not want to be instantiated.
    private Sole() {}

    // Get only object available
    public static Sole getInstance() {
        return instance;
    }

    @Override
    public void getAccountType() {
        System.out.println("Sole");
    }

}
