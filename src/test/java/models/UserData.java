package models;

import lombok.Getter;

@Getter
public class UserData {
    private final String username;
    private final String password;

    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
