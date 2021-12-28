package org.aplas.lms.datas;

import com.google.gson.annotations.SerializedName;

import org.aplas.lms.models.UserModel;

public class AuthData {
    @SerializedName("user")
    private UserModel user;

    @SerializedName("token")
    private String token;

    public AuthData() {
    }

    public AuthData(UserModel user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
