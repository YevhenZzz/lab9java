package ua.lviv.iot.lab9;

import javax.persistence.*;

@Entity
@Table(name = "clothes")
public class Clothes {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "brand")
    private String brand;
    @Column(name = "color")
    private String color;
    @Column(name = "price")
    private int price;
    @Column(name = "typesForWearing")
    private ua.lviv.iot.lab9.TypesForWearing typesForWearing;

    public Clothes() {
    }

    public Clothes(final String brand, final String color, final int price,
            final ua.lviv.iot.lab9.TypesForWearing typesForWearing) {
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.typesForWearing = typesForWearing;
    }

    public  String getBrand() {
        return brand;
    }

    public  String getColor() {
        return color;
    }

    public  int getPrice() {
        return price;
    }

    public  void setBrand( String brand) {
        this.brand = brand;
    }

    public  void setColor( String color) {
        this.color = color;
    }

    public  void setPrice( int price) {
        this.price = price;
    }

    public  TypesForWearing getTypesForWearing() {
        return typesForWearing;
    }

    public  void setTypesForWearing( TypesForWearing typesForWearing) {
        this.typesForWearing = typesForWearing;
    }

    @Override
    public String toString() {
        return " Clothes " + "\n" + " brand= " + brand + "\n" + " color= " + color + "\n" + " price= " + price + "\n"
                + " TypesForWearing= " + typesForWearing + "\n";
    }

}
