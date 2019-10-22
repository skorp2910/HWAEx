package org.itstep;

public class Game extends Development implements Report {
    @Override
    public void report() {
        System.out.println("This is report from Game");
    }

    @Override
    public String toString() {
        return "This is report from Game";
    }
}
