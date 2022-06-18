package SingletonAbstractFactory.model;
import SingletonAbstractFactory.Type;


public class SupplierCorporate implements Type {

    private static SupplierCorporate instance = new SupplierCorporate();

    private SupplierCorporate() {}

    // Get only object available
    public static SupplierCorporate getInstance() {
        return instance;
    }

    @Override
    public void getAccountType() {
        System.out.println("Supplier Corporate");
    }
}
