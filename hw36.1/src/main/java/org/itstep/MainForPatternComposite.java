package org.itstep;

public class MainForPatternComposite {
    public static void main(String[] args) {

        Report os = new OS();
        Report office = new Office();
        Report game = new Game();

        Development development = new Development();
        development.add(os);
        development.add(office);
        development.add(game);

        Report usa = new USA();
        Report uk = new UK();
        Report eu = new EU();

        Market market = new Market();
        market.add(usa);
        market.add(uk);
        market.add(eu);

        Report hh = new HH();

        MS ms = new MS();
        ms.add(hh);
        ms.add(market);
        ms.add(development);
        ms.report();
        market.report();
        ms.remove(hh);
        ms.remove(development);
        market.remove(uk);
        System.out.println("------------------");
        ms.report();
    }
}
