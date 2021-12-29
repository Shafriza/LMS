package org.aplas.lms.requests.attendances;

import com.google.gson.annotations.SerializedName;

public class IsAlreadyAttendanceRequest {
    @SerializedName("course_id")
    private Integer course_id;

    @SerializedName("status")
    private String status;

    @SerializedName("user_id")
    private Integer user_id;

    public IsAlreadyAttendanceRequest() {
    }

    public IsAlreadyAttendanceRequest(Integer course_id, String status, Integer user_id) {
        this.course_id = course_id;
        this.status = status;
        this.user_id = user_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
