package SingletonAbstractFactory.factory;

import SingletonAbstractFactory.Type;
import SingletonAbstractFactory.model.*;

public class SupplierCompanyFactory extends AbstractFactory {

    public static SupplierCompanyFactory instance = new SupplierCompanyFactory();

    private SupplierCompanyFactory(){}

    public static SupplierCompanyFactory getInstance() {

        return instance;
    }

    @Override
    public Type getType(String compType) {
        if (compType.equalsIgnoreCase("CORPORATE")) {

            //Get the only object available
            return SupplierCorporate.getInstance();
        }
        else if (compType.equalsIgnoreCase("SOLE")) {

            //Get the only object available
            return SupplierSole.getInstance();
        }
        else if (compType.equalsIgnoreCase("LIMITED")) {

            //Get the only object available
            return SupplierLimited.getInstance();
        }
        else {
            return null;
        }
    }
}
