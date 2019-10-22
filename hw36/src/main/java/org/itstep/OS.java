package org.itstep;

public class OS extends Development implements Report {
    @Override
    public void report() {
        System.out.println("This is report from OS");
    }
}
