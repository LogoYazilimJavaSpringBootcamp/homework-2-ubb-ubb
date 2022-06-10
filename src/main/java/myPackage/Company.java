package myPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Getter @Setter
abstract class Company {

    private int CID;
    private int SID;
    private String name;
    private String sector;
    private String companyType;
    public Date date;
    public static TreeSet<Company> companySet = new TreeSet<>();
    private List<Order> invoiceList = new LinkedList<>();


}
