package myPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Supplier extends Company{

    private int balance;
    private int receivable;


    public Supplier(String name, String sector){

        this.setName(name);
        this.setSector(sector);
        this.balance = 0;
        this.receivable = 0;
        this.setCompanyType("S");
        this.date = new Date();
        this.setSID((int) companySet.stream()
                .filter(c -> c.getCompanyType() == "S")
                .count());



        Company.companySet.add(this);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
