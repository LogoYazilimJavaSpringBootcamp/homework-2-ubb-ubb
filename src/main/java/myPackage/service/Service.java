package myPackage.service;

import myPackage.model.Company;
import myPackage.model.Customer;
import myPackage.model.Material;
import myPackage.model.Order;

import java.time.Month;
import java.util.*;

/**
 * Represents a user actions.
 */
public class Service {

    Order invoice;
    Customer customer;

    /**
     * Creates User class with no parameter.
     */
    public Service() {

    }

    /**
     * Creates a Material with the specified quantity, price and material name.
     * New Material ID created for each new Company object.
     *
     * @param customer Customer object.
     * @param invoice  Order.
     */
    public Service(Customer customer, Order invoice) {
        this.invoice = invoice;
        this.customer = customer;
    }

    /**
     * Creates a Material with the specified quantity, price and material name.
     * New Material ID created for each new Company object.
     *
     * @param customer Customer object.
     */
    public Service(Customer customer) {
        this.customer = customer;
    }

    /**
     * Creates a Material with the specified quantity, price and material name.
     * New Material ID created for each new Company object.
     *
     * @param invoice Order.
     */
    public Service(Order invoice) {
        this.invoice = invoice;
    }

    /**
     * Creates a new customer with given name and sector.
     *
     * @param name   customer name.
     * @param sector sector.
     */
    public void createNewCustomer(String name, String sector) {
        Customer c1 = new Customer(name, sector);
    }

    /**
     * Creates a new customer with given name and sector.
     *
     * @param quantity material quantity.
     * @param price    material price.
     * @param name     material name
     */
    public void createNewMaterial(int quantity, int price, String name) {
        Material driver = new Material(quantity, price, name);
    }

    /**
     * Creates a new order.
     */
    public void createNewOrder() {
        Order order = new Order();
    }

    /**
     * Assigns invoice to a customer with id's.
     *
     * @param CID Company Id
     * @param IID Invoice Id.
     */
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

    /**
     * Assigns material to an order with id's.
     *
     * @param IID Invoice Id
     * @param MID Material Id.
     */
    public void assignMaterialToOrder(int IID, int MID) {
        Optional<Order> order = Order.invoiceList.stream()
                .filter(elem -> elem.getIID() == IID)
                .findFirst();

        Optional<Material> material = Material.materialDatabase.stream()
                .filter(elem -> elem.getMID() == MID)
                .findFirst();

        order.get().addMaterial(material.get());
    }

    /**
     * List all customers.
     */
    public void listAllCustomer() {
        System.out.println("List of all customers: ");
        Company.companySet.stream()
                .forEach(elem -> System.out.println(elem.getCID() + " " + elem));
    }

    /**
     * List all invoices.
     */
    public void listAllInvoice() {
        System.out.println("List of all invoices: ");
        Order.invoiceList.stream()
                .forEach(order -> System.out.println(order));
    }

    /**
     * List companies that contains given letter.
     *
     * @param s String
     */
    public void listCustomerByLetter(String s) {
        System.out.println("List of customers that contains letter: " + s);
        Customer.companySet.stream()
                .filter(customer -> customer.getName().contains(s.toLowerCase()) || customer.getName().contains(s.toUpperCase()))
                .forEach(elem -> System.out.println(elem.getCID() + " " + elem));
    }

    /**
     * List companies that registered in given month.
     *
     * @param month month value (0=> January - 11=> December)
     */
    public void listInvoiceByCustomerMonth(int month) {
        System.out.println("List of total invoice amount for customers that are registered in month: " + Month.of(month + 1).name());
        Customer.companySet.stream()
                .filter(elem -> elem.getDate().getMonth() == month)
                .forEach(elem -> System.out.println(elem + " " + elem.getInvoiceList().stream()
                        .mapToDouble(sum -> sum.getAmount()).sum()));
    }

    /**
     * List companies filter by invoice total amount.
     *
     * @param price   boundary total amount
     * @param greater control value (if true = >  if false = <)
     */
    public void listCustomerByInvoice(int price, boolean greater) {

        String operator = ((greater == true) ? "greater" : "less");

        System.out.println("List of customers that has invoices " + operator + " than " + price);
        Customer.companySet.stream().filter(elem -> Order.invoiceList.stream()
                        .anyMatch(inv -> (inv.getAmount() > price || !greater) && (inv.getAmount() < price || greater) && inv.getCID() == elem.getCID()))
                .forEach(elem -> System.out.println(elem.getName()));
    }

    /**
     * List company sectors filter by invoice average amount by given month and total amount.
     *
     * @param price   boundary total amount
     * @param greater control value (if true = >  if false = <)
     * @param month   value (0=> January - 11=> December)
     */
    public void listSectorByAverageInvoice(int month, int price, boolean greater) {

        String operator = ((greater == true) ? "greater" : "less");
        System.out.println("List of customer sectors that customer has average invoices " + operator + " than " + price + " in month: " + Month.of(month + 1).name());

        Customer.companySet.stream()
                .filter(elem -> !elem.getInvoiceList().isEmpty())
                .filter(elem -> (elem.getInvoiceList().stream().mapToDouble(Order::getAmount).average().getAsDouble() > price || !greater))
                .filter(elem -> (elem.getInvoiceList().stream().mapToDouble(Order::getAmount).average().getAsDouble() < price || greater))
                .distinct()
                .forEach(elem -> System.out.println(elem.getSector()));
    }

    /**
     * List invoices filter by given total amount.
     *
     * @param price   boundary total amount
     * @param greater control value (if true = >  if false = <)
     */
    public void listInvoiceByAmount(int price, boolean greater) {
        String operator = ((greater == true) ? "greater" : "less");
        System.out.println("List of invoices that are " + operator + " than " + price);
        Order.invoiceList.stream()
                .filter(invoice -> invoice.getAmount() > price || !greater)
                .filter(invoice -> invoice.getAmount() < price || greater)
                .forEach(elem -> System.out.println(elem));
    }

    /**
     * Get average of invoices filter by given total amount.
     *
     * @param price   boundary total amount
     * @param greater control value (if true = >  if false = <)
     */
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
