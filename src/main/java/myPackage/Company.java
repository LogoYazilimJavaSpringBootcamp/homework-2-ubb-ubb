package myPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
/**
 * Represents a company.
 * This is an abstract class.
 */
abstract class Company {
    // Customer ID
    private int CID;

    // Supplier ID
    private int SID;

    private String name;
    private String sector;

    // Company type whether company is supplier or customer.
    private String companyType;
    public Date date;

    // Treeset that all created Company objects are stored in this treeset.
    public static TreeSet<Company> companySet = new TreeSet<>();

    // Invoices that company has stored as list.
    private List<Order> invoiceList = new LinkedList<>();
}
