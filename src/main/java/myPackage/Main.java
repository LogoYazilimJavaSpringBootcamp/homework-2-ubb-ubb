package myPackage;

import java.util.*;

/**
 * Main method to run User class methods.
 */
public class Main {

    public static void main(String[] args) {

        // Create new User object
        User user = new User();

        // Create new Customer
        user.createNewCustomer("Enka", "Construction");
        user.createNewCustomer("Otokoc", "Automotive");
        user.createNewCustomer("Isdemir", "Industrial");
        user.createNewCustomer("Arcelik", "Electronics");
        user.createNewCustomer("IKEA", "Furniture");
        user.createNewCustomer("Casa", "Furniture");

        //Create new Materials
        user.createNewMaterial(2, 1000, "Screwdriver");
        user.createNewMaterial(3, 500, "Saw");
        user.createNewMaterial(4, 300, "Screws");
        user.createNewMaterial(2, 300, "Fastener");
        user.createNewMaterial(1, 1000, "Power Tools");

        // Create blank order
        user.createNewOrder();
        user.createNewOrder();
        user.createNewOrder();
        user.createNewOrder();

        // Assign material to Order with ID's.
        user.assignMaterialToOrder(0, 0);
        user.assignMaterialToOrder(0, 1);
        user.assignMaterialToOrder(0, 2);
        user.assignMaterialToOrder(0, 3);

        user.assignMaterialToOrder(1, 0);
        user.assignMaterialToOrder(1, 2);
        user.assignMaterialToOrder(1, 4);

        user.assignMaterialToOrder(2, 4);

        user.assignMaterialToOrder(3, 3);

        // Assign Order to Customer with ID's.
        user.assignCustomerToInvoice(0, 0);
        user.assignCustomerToInvoice(2, 1);
        user.assignCustomerToInvoice(4, 2);
        user.assignCustomerToInvoice(5, 3);

        // List all customers.
        user.listAllCustomer();
        // List all customers that contains letter C.
        user.listCustomerByLetter("C");
        // List customers that registered in month june
        user.listInvoiceByCustomerMonth(5);
        // List all invoices
        user.listAllInvoice();
        // List invoices greater than 1500.
        user.listInvoiceByAmount(1500, true);
        // Get average invoice for invoices greater than 1500
        user.getAverageByInvoice(1500, true);
        // List customer names, has invoices less 500
        user.listCustomerByInvoice(500, false);
        // List customer sectors average is less than 750 and invoices are in month June.
        user.listSectorByAverageInvoice(5, 750, false);
    }
}
