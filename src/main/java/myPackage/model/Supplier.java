package myPackage.model;

import lombok.Getter;
import lombok.Setter;
import myPackage.factory.CompanyFactory;

import java.util.Date;

@Getter
@Setter
/**
 * Represents a Supplier.
 * This class inherited by Company class.
 */
public class Supplier extends Company implements Comparable {

    private int balance;
    private int receivable;

    /**
     * Creates a Supplier with the specified name and sector.
     * Creation date is assigned to this.date
     * New Company ID created for each new Company object.
     *
     * @param name   The customer's name.
     * @param sector The customer's sector.
     */
    public Supplier(String name, String sector) {
        this.setName(name);
        this.setSector(sector);
        this.balance = 0;
        this.receivable = 0;
        this.setCompanyType("SUPPLIER");
        this.date = new Date();
        this.setCID((int) companySet.stream()
                .filter(c -> c.getCompanyType() == "SUPPLIER")
                .count());
        Company.companySet.add(this);
        Company.companyMap.put(this, this.getCompanyType());
    }

    /**
     * Converts class object to string
     *
     * @return A string name represents this class
     */
    @Override
    public String toString() {
        return this.getName();
    }


    @Override
    public int compareTo(Object o) {

        if (this.getCID() > ((Company) o).getCID()) {
            return 1;
        } else if (this.getCID() < ((Company) o).getCID()) {
            return -1;
        } else {
            return 0;
        }
    }
}
