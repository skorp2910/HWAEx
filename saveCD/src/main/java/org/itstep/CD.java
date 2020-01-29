package org.itstep;

import java.util.Objects;

public class CD {
    private String name;
    private int price;

    public CD(String name, double price) {
        this.name = name;
        this.price = (int) price;
    }

    public CD(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return Double.compare(cd.price, price) == 0 &&
                name.equals(cd.name);
    }

    @Override
    public String toString() {
        return "CD{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
