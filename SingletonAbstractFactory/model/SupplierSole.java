package SingletonAbstractFactory.model;

import SingletonAbstractFactory.Type;

public class SupplierSole implements Type {

    private static SupplierSole instance = new SupplierSole();

    private SupplierSole() {}

    // Get only object available
    public static SupplierSole getInstance() {
        return instance;
    }

    @Override
    public void getAccountType() {
        System.out.println("Supplier Sole");
    }

}
