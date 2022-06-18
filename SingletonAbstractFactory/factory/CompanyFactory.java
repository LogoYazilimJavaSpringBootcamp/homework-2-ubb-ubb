package SingletonAbstractFactory.factory;

import SingletonAbstractFactory.Type;
import SingletonAbstractFactory.model.Corporate;
import SingletonAbstractFactory.model.Limited;
import SingletonAbstractFactory.model.Sole;

/**
 * Factory class extending AbstractFactory to generate objects of concrete classes. *
 */
public class CompanyFactory extends AbstractFactory {

    public static CompanyFactory instance = new CompanyFactory();

    private CompanyFactory(){}

    public static CompanyFactory getInstance() {

        return instance;
    }



    @Override
    public Type getType(String compType) {
        if (compType.equalsIgnoreCase("CORPORATE")) {

            //Get the only object available
            return Corporate.getInstance();
        }
        else if (compType.equalsIgnoreCase("SOLE")) {

            //Get the only object available
            return Sole.getInstance();
        }
        else if (compType.equalsIgnoreCase("LIMITED")) {

            //Get the only object available
            return Limited.getInstance();
        }
        else {
            return null;
        }
    }
}
