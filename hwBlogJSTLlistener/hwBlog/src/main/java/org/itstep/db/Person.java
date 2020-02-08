package org.itstep.db;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private String password;
    private String access_rights;

    public Person(String name, String password, String access_rights) {
        this.name = name;
        this.password = password;
        this.access_rights = access_rights;
    }
}
