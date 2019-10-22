package org.itstep;

import java.util.ArrayList;
import java.util.List;

public class MS implements Report {
    private List<Report> reports = new ArrayList<>();

    @Override
    public void report() {
        System.out.println("Report corporation MS:\n");
        for (Report report : reports) {
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
