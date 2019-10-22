package org.itstep;

public class USA extends Market implements Report {
    @Override
    public void report() {
        System.out.println("This is report from USA");
    }

    @Override
    public String toString() {
        return "This is report from USA";
    }
}
