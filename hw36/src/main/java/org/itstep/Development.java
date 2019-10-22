package org.itstep;

import java.util.ArrayList;
import java.util.List;

public class Development implements Report {
    private List<Report> reports = new ArrayList<>();

    @Override
    public void report() {
        System.out.println("Report from subdivision Development department:");
        for (Report report : reports) {
            System.out.print("    ");
            report.report();
        }
    }

    void add(Report r) {
        this.reports.add(r);
    }

    void remove(Report r) {
        this.reports.remove(r);
    }
}
