package SingletonAbstractFactory.model;
import SingletonAbstractFactory.Type;

/**
 * Concrete class implements Type
 * Represents Limited company.
 */
public class Limited implements Type{


    // Create single instance Limited object
    private static Limited instance = new Limited();

    // Constructor is private since we do not want to be instantiated.
    private Limited() {}

    // Get only object available
    public static Limited getInstance() {
        return instance;
    }

    @Override
    public void getAccountType() {
        System.out.println("Limited");
    }

}
