package myPackage;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
/**
 * Material class represents materials, with quantity, unit price and total price.
 */
public class Material {

    public int quantity;
    private double price;
    private double totalPrice;
    private String materialName;
    private int MID;
    private static int counter = 0;
    public static List<Material> materialDatabase = new ArrayList<>();

    /**
     * Creates a Material with the specified quantity, price and material name.
     * New Material ID created for each new Company object.
     *
     * @param quantity     Material quantity.
     * @param price        Material unit price.
     * @param materialName Material name
     */
    public Material(int quantity, int price, String materialName) {
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = quantity * price;
        this.materialName = materialName;
        this.MID = counter;
        counter++;
        materialDatabase.add(this);


    }
}
