package org.aplas.lms.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class AttendanceModel {
    @SerializedName("id")
    private int id;

    @SerializedName("user_id")
    private int user_id;

    @SerializedName("course_id")
    private int course_id;

    @SerializedName("status")
    private int status;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("updated_at")
    private Date updated_at;

    public AttendanceModel() {
    }

    public AttendanceModel(int id, int user_id, int course_id, int status, Date created_at, Date updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.course_id = course_id;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
