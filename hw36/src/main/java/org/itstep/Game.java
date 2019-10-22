package org.itstep;

public class Game extends Development implements Report {
    @Override
    public void report() {
        System.out.println("This is report from Game");
    }
}
