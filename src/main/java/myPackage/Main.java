package myPackage;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        User user = new User();

        user.createNewCustomer("Enka", "Construction");
        user.createNewCustomer("Otokoc", "Automotive");
        user.createNewCustomer("Isdemir", "Industrial");
        user.createNewCustomer("Arcelik", "Electronics");
        user.createNewCustomer("IKEA", "Furniture");
        user.createNewCustomer("Casa", "Furniture");


        user.createNewMaterial(2, 1000, "Screwdriver");
        user.createNewMaterial(3, 500, "Saw");
        user.createNewMaterial(4, 300, "Screws");
        user.createNewMaterial(2, 300, "Fastener");
        user.createNewMaterial(1, 1000, "Power Tools");

        user.createNewOrder();
        user.createNewOrder();
        user.createNewOrder();
        user.createNewOrder();

        user.assignMaterialToOrder(0,0);
        user.assignMaterialToOrder(0,1);
        user.assignMaterialToOrder(0,2);
        user.assignMaterialToOrder(0,3);

        user.assignMaterialToOrder(1,0);
        user.assignMaterialToOrder(1,2);
        user.assignMaterialToOrder(1,4);

        user.assignMaterialToOrder(2,4);

        user.assignMaterialToOrder(3,3);

        user.assignCustomerToInvoice(0,0);
        user.assignCustomerToInvoice(2,1);
        user.assignCustomerToInvoice(4,2);
        user.assignCustomerToInvoice(5,3);


        user.listAllCustomer();
        user.listCustomerByLetter("C");
        user.listInvoiceByCustomerMonth(5);
        user.listAllInvoice();
        user.listInvoiceByAmount(1500, true);
        user.getAverageByInvoice(1500, true);
        user.listCustomerByInvoice(500, false);
        user.listSectorByAverageInvoice(5, 750, false);



        /**


         List<Material> materialList = new ArrayList<>();
         List<Material> materialList2 = new ArrayList<>();
         List<Material> materialList3 = new ArrayList<>();
         List<Material> materialList4 = new ArrayList<>();
         List<Material> materialList5 = new ArrayList<>();

         materialList.add(driver);
         materialList.add(saw);
         materialList.add(tool);

         materialList2.add(driver);
         materialList2.add(tool);

         materialList3.add(tool);

         materialList4.add(chair);

         materialList5.add(chair);
         materialList5.add(chair);

         Order invoice = new Order(materialList);
         Order invoice2 = new Order(materialList2);
         Order invoice3 = new Order(materialList3);
         Order invoice4 = new Order(materialList4);
         Order invoice5 = new Order(materialList5);




         user.assignCustomerToInvoice(1, 5);
         user.assignCustomerToInvoice(2, 1);
         user.assignCustomerToInvoice(2, 2);
         user.assignCustomerToInvoice(3, 3);
         user.assignCustomerToInvoice(4, 4);


         user.listAllCustomer();
         user.listCustomerByLetter("A");
         user.listInvoiceByCustomerMonth(5);
         user.listAllInvoice();
         user.listInvoiceByAmount(1500, false);
         user.getAverageByInvoice(800, true);
         user.listCustomerByInvoice(800, true);
         user.listSectorByAverageInvoice(5, 750, false);

         */
    }
}
