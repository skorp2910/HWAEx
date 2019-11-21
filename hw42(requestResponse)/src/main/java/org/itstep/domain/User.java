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