package myPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
/**
 * Represents a Customer.
 * This class inherited by Company class.
 */
public class Customer extends Company implements Comparable {

    /**
     * Creates an customer with the specified name and sector.
     * Creation date is assigned to this.date
     * New Company ID created for each new Customer object.
     *
     * @param name   The customer's name.
     * @param sector The customer's sector.
     */
    public Customer(String name, String sector) {
        this.setName(name);
        this.setSector(sector);
        this.setCompanyType("C");
        this.date = new Date();
        this.setCID((int) companySet.stream()
                .filter(c -> c.getCompanyType() == "C")
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

    /**
     * Compares Customer object with another object
     * Required for TreeSet
     *
     * @return integer
     */
    @Override
    public int compareTo(Object o) {

        if (this.getCID() > ((Customer) o).getCID()) {
            return 1;
        } else if (this.getCID() < ((Customer) o).getCID()) {
            return -1;
        } else {
            return 0;
        }
    }
}