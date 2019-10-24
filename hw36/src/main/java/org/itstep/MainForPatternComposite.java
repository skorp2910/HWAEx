package org.itstep;

import org.itstep.example.Branch;
import org.itstep.example.Department;
import org.itstep.example.Unit;

public class MainForPatternComposite {
    public static void main(String[] args) {

        // Не вижу реализвации паттерна композиция
        // Слишком много одинаковых классов

        // Report os = new OS();
        // Report office = new Office();
        // Report game = new Game();

        // Development development = new Development();
        // development.add(os);
        // development.add(office);
        // development.add(game);

        // Report usa = new USA();
        // Report uk = new UK();
        // Report eu = new EU();

        // Market market = new Market();
        // market.add(usa);
        // market.add(uk);
        // market.add(eu);

        // Report hh = new HH();

        // MS ms = new MS();
        // ms.add(hh);
        // ms.add(market);
        // ms.add(development);
        // ms.report();
        // System.out.println("---------------------");
        // market.report();

        // System.out.println("******************");
        // Iterator iterator =ms.getIterator();
        // Iterator iterator1 = development.getIterator();
        // Iterator iterator2 = market.getIterator();

        // while (iterator.hasNext()){
        // System.out.println(iterator.next());
        // }
        // while (iterator1.hasNext()){
        // System.out.println(iterator1.next());
        // }
        // while (iterator2.hasNext()){
        // System.out.println(iterator2.next());
        // }

        // Пример реализации паттерна см. в пакете example

        Unit corporation = new Branch("MS");
        corporation.add(new Branch("Dev"));
        corporation.getUnit("Dev").add(new Department("OS"));
        corporation.getUnit("Dev").add(new Department("Game"));
        corporation.getUnit("Dev").add(new Department("Office"));

        System.out.println(corporation.report());
    }
}
