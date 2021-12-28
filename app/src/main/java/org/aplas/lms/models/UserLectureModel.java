package org.aplas.lms.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserLectureModel {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("email_verified_at")
    private Date email_verified_at;

    @SerializedName("role")
    private int role;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("updated_at")
    private Date updated_at;

    @SerializedName("lecture")
    private LectureModel lecture;

    public UserLectureModel() {
    }

    public UserLectureModel(int id, String name, String email, Date email_verified_at, int role, Date created_at, Date updated_at, LectureModel lecture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.email_verified_at = email_verified_at;
        this.role = role;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.lecture = lecture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(Date email_verified_at) {
        this.email_verified_at = email_verified_at;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    public LectureModel getLecture() {
        return lecture;
    }

    public void setLecture(LectureModel lecture) {
        this.lecture = lecture;
    }
}
