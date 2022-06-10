package myPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Customer extends Company implements Comparable {


    private double totalAmount;


    public Customer(String name, String sector) {
        this.setName(name);
        this.setSector(sector);
        this.setCompanyType("C");
        this.date = new Date();
        this.setCID((int) companySet.stream()
                .filter(c -> c.getCompanyType() == "C")
                .count());
        Company.companySet.add(this);
    }

    @Override
    public String toString() {
        return this.getName();
    }


    @Override
    public int compareTo(Object o) {

        if (this.getCID() > ((Customer) o).getCID()) {
            return 1;
        } else if (this.getCID() < ((Customer) o).getCID()) {
            return -1;
        }
        else {
        return 0;
        }
    }
}