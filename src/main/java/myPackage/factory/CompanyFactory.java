package myPackage.factory;

import myPackage.model.Company;
import myPackage.model.Customer;
import myPackage.model.Supplier;

public class CompanyFactory {

    public Company getType(String str, String name, String sector) {

        if (str.equalsIgnoreCase("SUPPLIER")) {
            return new Supplier(name,sector);
        }
        else if (str.equalsIgnoreCase("CUSTOMER")) {
            return new Customer(name,sector);
        }
        else {
            return null;
        }
    }
}
