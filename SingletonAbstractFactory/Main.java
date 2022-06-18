package SingletonAbstractFactory;

import SingletonAbstractFactory.factory.AbstractFactory;
import SingletonAbstractFactory.factory.CompanyFactory;
import SingletonAbstractFactory.factory.FactoryProducer;

public class Main {

    public static void main(String[] args) {

        // Get CompanyFactory
        AbstractFactory companyFactory = FactoryProducer.getFactory(true);

        // Get a company object of Corporate
        Type type1 = companyFactory.getType("CORPORATE");
        type1.getAccountType();

        // Get a company object of Limited
        Type type2 = companyFactory.getType("LIMITED");
        type2.getAccountType();

        // Get a company object of Sole
        Type type3 = companyFactory.getType("SOLE");
        type3.getAccountType();

        // Get a company object of Corporate
        Type type4 = companyFactory.getType("CORPORATE");
        type4.getAccountType();

        // Printing address for type1 and type4, since classes implement Singleton pattern, both address will be the same.
        System.out.println("Type1 address: " + type1);
        System.out.println("Type4 address: " + type4);

        // Get SupplierCompanyFactory
        AbstractFactory supplierCompanyFactory = FactoryProducer.getFactory(false);

        Type type5 = supplierCompanyFactory.getType("CORPORATE");
        type5.getAccountType();

        Type type6 = supplierCompanyFactory.getType("LIMITED");
        type6.getAccountType();

        Type type7 = supplierCompanyFactory.getType("SOLE");
        type7.getAccountType();

        Type type8 = supplierCompanyFactory.getType("SOLE");
        type8.getAccountType();

        // Printing address for type7 and type8, since classes implement Singleton pattern, both address will be the same.
        System.out.println("Type7 address: " + type7);
        System.out.println("Type8 address: " + type8);


    }
}
