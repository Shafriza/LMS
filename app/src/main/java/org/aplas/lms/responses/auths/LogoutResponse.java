package org.aplas.lms.responses.auths;

import com.google.gson.annotations.SerializedName;

public class LogoutResponse {
    @SerializedName("status")
    private Boolean status;

    @SerializedName("message")
    private String message;

    public LogoutResponse() {
    }

    public LogoutResponse(Boolean status, String message) {
        this.status = status;
        this.message = message;
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
}
