package myPackage.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter
@Setter
/**
 * Represents a company.
 * This is an abstract class.
 */
public abstract class Company {
    // Company ID
    private int CID;


    private String name;
    private String sector;

    // Company type whether company is supplier or customer.
    private String companyType;
    public Date date;

    // Treeset that all created Company objects are stored in this treeset.
    public static TreeSet<Company> companySet = new TreeSet<>();
    public static Map<Company,String> companyMap = new HashMap();

    // Invoices that company has stored as list.
    private List<Order> invoiceList = new LinkedList<>();


}
