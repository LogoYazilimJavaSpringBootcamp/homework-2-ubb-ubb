package SingletonAbstractFactory.factory;

public class FactoryProducer {

    public static AbstractFactory getFactory(boolean customer) {

        if (customer) {
            return CompanyFactory.getInstance();
        }

        else {
            return SupplierCompanyFactory.getInstance();
        }
    }
}
