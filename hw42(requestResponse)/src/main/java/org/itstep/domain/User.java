package org.itstep.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private Gender gender;
    private String phone;
    private String email;
    private boolean subscribe;

    public static String toText(User user) {
        return String.format("%s;%s;%s;%s;%s;%s\n", user.login, user.password, user.gender, user.phone, user.email,
                user.subscribe);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    public static User parese(String text) {
        User user = null;
        String[] fields = text.trim().split(";");
        if (fields.length == 6) {
            user = new User();
            user.setLogin(fields[0]);
            user.setPassword(fields[1]);
            user.setGender(Gender.valueOf(fields[2]));
            user.setPhone(fields[3]);
            user.setEmail(fields[4]);
            user.setSubscribe(Boolean.parseBoolean(fields[5]));
        }
        return user;
    }
}