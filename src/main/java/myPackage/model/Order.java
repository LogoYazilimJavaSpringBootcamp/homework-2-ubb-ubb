package myPackage.model;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
/**
 * Order class represents a order, with invoice.
 */
public class Order {

    // Invoice ID
    private int IID;
    // Customer ID
    private int CID;
    // Supplier ID
    private int SID;

    // Material List
    private List<Material> materialList = new ArrayList<>();
    // Order Amount
    private double amount;
    // Order Amount with Tax
    private double amountWithTax;
    private Date date;
    // Final VAT variable
    private final double VAT = 0.18;
    // invoiceList for all invoices.
    public static List<Order> invoiceList = new ArrayList<>();

    /**
     * Creates an Order
     * New Invoice ID created for each new Company object.
     */
    public Order() {
        this.IID = invoiceList.size();
        this.date = new Date();
        invoiceList.add(this);
    }

    /**
     * Adds material to an Order
     *
     * @param m Material
     */

    public void addMaterial(Material m) {
        this.materialList.add(m);
        this.amount = materialList.stream()
                .mapToDouble(Material::getTotalPrice)
                .sum();
        this.amountWithTax = this.amount * VAT + this.amount;
    }

    /**
     * Converts class object to string
     *
     * @return A string, with detailed invoice information
     */
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(this.getDate()) + " Invoice ID: " + this.IID + " Customer ID: " + this.CID + " " + "Total Price:" + this.amount + " Total Price with VAT: " + this.amountWithTax;
    }
}
