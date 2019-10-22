package org.itstep;

public class Office extends Development implements Report {
    @Override
    public void report() {
        System.out.println("This is report from Office");
    }

    @Override
    public String toString() {
        return "This is report from Office";
    }
}
