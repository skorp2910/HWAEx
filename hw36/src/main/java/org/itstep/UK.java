package org.itstep;

public class UK extends Market implements Report {
    @Override
    public void report() {
        System.out.println("This is report from UK");
    }
}
