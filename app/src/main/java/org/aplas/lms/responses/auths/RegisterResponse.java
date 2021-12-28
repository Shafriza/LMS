package org.aplas.lms.responses.auths;

import com.google.gson.annotations.SerializedName;

import org.aplas.lms.datas.AuthData;
import org.aplas.lms.models.UserModel;

public class RegisterResponse {
    @SerializedName("status")
    private Boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private AuthData data;

    public RegisterResponse() {
    }

    public RegisterResponse(Boolean status, String message, AuthData data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthData getData() {
        return data;
    }

    public void setData(AuthData data) {
        this.data = data;
    }
}
