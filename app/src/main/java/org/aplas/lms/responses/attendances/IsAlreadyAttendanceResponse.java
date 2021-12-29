package org.aplas.lms.responses.attendances;

import com.google.gson.annotations.SerializedName;

import org.aplas.lms.models.UserModel;

public class IsAlreadyAttendanceResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    public IsAlreadyAttendanceResponse() {
    }

    public IsAlreadyAttendanceResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
