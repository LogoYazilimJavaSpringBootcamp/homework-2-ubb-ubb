package SingletonAbstractFactory.model;

import SingletonAbstractFactory.Type;

public class SupplierLimited implements Type {

    private static SupplierLimited instance = new SupplierLimited();

    private SupplierLimited() {}

    // Get only object available
    public static SupplierLimited getInstance() {
        return instance;
    }

    @Override
    public void getAccountType() {
        System.out.println("Supplier Limited");
    }
}
