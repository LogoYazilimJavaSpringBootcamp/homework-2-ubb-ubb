package myPackage;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class User {

    Order invoice;
    Customer customer;

    public User() {


    }

    public User(Customer customer, Order invoice) {
        this.invoice = invoice;
        this.customer = customer;
    }

    public User(Customer customer) {
        this.customer = customer;
    }

    public User(Order invoice) {
        this.invoice = invoice;
    }



    public void createNewCustomer(String name, String sector) {
        Customer c1 = new Customer(name, sector);


    }

    public void createNewMaterial(int quantity, int price, String name) {
        Material driver = new Material(quantity,price,name);

    }

    public void createNewOrder() {
        Order order = new Order();
    }

    public void assignCustomerToInvoice(int CID, int IID) {
        Optional<Company> customer = Customer.companySet.stream()
                .filter(elem -> elem.getCID() == CID)
                .findFirst();

        Optional<Order> invoice = Order.invoiceList.stream()
                .filter(inv -> inv.getIID() == IID)
                .findFirst();

        invoice.get().setCID(customer.get().getCID());
        customer.get().getInvoiceList().add(invoice.get());
    }


    public void assignMaterialToOrder(int IID, int MID) {
        Optional<Order> order = Order.invoiceList.stream()
                .filter(elem -> elem.getIID() == IID)
                .findFirst();

        Optional<Material> material = Material.materialDatabase.stream()
                .filter(elem -> elem.getMID() == MID)
                .findFirst();

        order.get().addMaterial(material.get());

    }



    public void listAllCustomer() {
        System.out.println("List of all customers: ");
        Company.companySet.stream()
                .forEach(elem -> System.out.println(elem.getCID() + " " + elem));
    }

    public void listAllInvoice() {
        System.out.println("List of all invoices: ");
        Order.invoiceList.stream()
                .forEach(order -> System.out.println(order));
    }

    public void listCustomerByLetter(String s) {
        System.out.println("List of customers that contains letter: " + s);
        Customer.companySet.stream()
                .filter(customer -> customer.getName().contains(s.toLowerCase()) || customer.getName().contains(s.toUpperCase()))
                .forEach(elem -> System.out.println(elem.getCID() + " " + elem));
    }

    public void listInvoiceByCustomerMonth(int month) {
        System.out.println("List of total invoice amount for customers that are registered in month: " + Month.of(month + 1).name());
        Customer.companySet.stream()
                .filter(elem -> elem.getDate().getMonth() == month)
                .forEach(elem -> System.out.println(elem + " " + elem.getInvoiceList().stream()
                        .mapToDouble(sum -> sum.getAmount()).sum()));
    }


    public void listCustomerByInvoice(int price, boolean greater) {

        String operator = ((greater == true) ? "greater" : "less");

        System.out.println("List of customers that has invoices " + operator + " than " + price);
        Customer.companySet.stream().filter(elem -> Order.invoiceList.stream()
                        .anyMatch(inv -> (inv.getAmount() > price || !greater) && (inv.getAmount() < price || greater) && inv.getCID() == elem.getCID()))
                .forEach(elem -> System.out.println(elem.getName()));
    }

    // this!!!
    public void listSectorByAverageInvoice(int month, int price, boolean greater) {

        String operator = ((greater == true) ? "greater" : "less");
        System.out.println("List of customer sectors that customer has average invoices " + operator + " than " + price + " in month: " + Month.of(month + 1).name());


        Customer.companySet.stream()
                .filter(elem-> !elem.getInvoiceList().isEmpty())
                .filter(elem -> (elem.getInvoiceList().stream().mapToDouble(Order::getAmount).average().getAsDouble() > price || !greater))
                .filter(elem -> (elem.getInvoiceList().stream().mapToDouble(Order::getAmount).average().getAsDouble() < price || greater))
                .distinct()
                .forEach(elem ->  System.out.println(elem.getSector()));
/**
        Customer.companySet.stream()
                .filter(elem-> elem.getInvoiceList().isEmpty() && !greater)
                .distinct()
                .forEach(elem ->  System.out.println(elem.getSector()));*/

    }



    public void listInvoiceByAmount(int price, boolean greater) {
        String operator = ((greater == true) ? "greater" : "less");
        System.out.println("List of invoices that are " + operator + " than " + price);
        Order.invoiceList.stream()
                .filter(invoice -> invoice.getAmount() > price || !greater)
                .filter(invoice -> invoice.getAmount() < price || greater)
                .forEach(elem -> System.out.println(elem));


    }

    public void getAverageByInvoice(int price, boolean greater) {
        String operator = ((greater == true) ? "greater" : "less");
        System.out.println("Average of invoices that are " + operator + " than " + price);

        DoubleSummaryStatistics stats = Order.invoiceList.stream()
                .filter(order -> order.getAmount() > price || !greater)
                .filter(order -> order.getAmount() < price || greater)
                .mapToDouble(Order::getAmount)
                .summaryStatistics();

        System.out.println(stats.getAverage());


    }



}
