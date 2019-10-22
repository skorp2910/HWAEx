package org.itstep;

public class EU extends Market implements Report {
    @Override
    public void report() {
        System.out.println("This is report from EU");
    }
}
