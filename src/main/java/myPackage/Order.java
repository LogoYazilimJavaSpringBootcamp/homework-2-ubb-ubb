package myPackage;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Order {

    private int IID;
    private int CID;
    private int SID;
    private List<Material> materialList = new ArrayList<>();
    private double amount;
    private double amountWithTax;
    private Date date;
    private final double VAT = 0.18;
    public static List<Order> invoiceList = new ArrayList<>();

    public Order() {
        this.IID = invoiceList.size();
        this.date = new Date();
        invoiceList.add(this);
    }
    public void addMaterial(Material m) {
        this.materialList.add(m);
        this.amount = materialList.stream()
                .mapToDouble(Material::getTotalPrice)
                .sum();
        this.amountWithTax = this.amount * VAT + this.amount;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(this.getDate()) +" Invoice ID: "+ this.IID + " Customer ID: " + this.CID+ " "+ "Total Price:" + this.amount+" Total Price with VAT: " + this.amountWithTax;
    }
}
