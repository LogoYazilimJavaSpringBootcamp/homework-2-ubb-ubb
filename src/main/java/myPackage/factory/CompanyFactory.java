package myPackage.factory;

import myPackage.model.Company;
import myPackage.model.Customer;
import myPackage.model.Supplier;

/**
 * Represents Factory Class to create new objects of Supplier or Customer
 *
 */
public class CompanyFactory {

    /**
     *
     * @param str, SUPPLIER or CUSTOMER
     * @param name , company name
     * @param sector, company sector
     * @return Company, supplier object or customer object.
     */
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
