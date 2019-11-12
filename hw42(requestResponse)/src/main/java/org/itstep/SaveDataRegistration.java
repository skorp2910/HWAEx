package org.itstep;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveDataRegistration implements Serializable {
    private static int i = 0;
    private ArrayList<String> logins = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<String> genders = new ArrayList<>();
    private ArrayList<String> phones = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();
    private ArrayList<String> subscribes = new ArrayList<>();
    static StringBuilder builder = new StringBuilder();

    void addData(String login, String password, String gender, String phone, String email, String subscribe) {
        i++;
        logins.add(login);
        passwords.add(password);
        genders.add(gender);
        phones.add(phone);
        emails.add(email);
        subscribes.add(subscribe);
        builder.append("<tr>" +
                "<td>" +
                i +
                "</td>" +
                "<td>" +
                logins.get(i - 1) +
                "</td>" +
                "<td>" +
                passwords.get(i - 1) +
                "</td>" +
                "<td>" +
                genders.get(i - 1) +
                "</td>" +
                "<td>" +
                phones.get(i - 1) +
                "</td>" +
                "<td>" +
                emails.get(i - 1) +
                "</td>" +
                "<td>" +
                subscribes.get(i - 1) +
                "</td>" +
                "</tr>");
    }
}
