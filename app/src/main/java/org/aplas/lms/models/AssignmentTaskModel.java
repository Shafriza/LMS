package org.aplas.lms.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class AssignmentTaskModel {
    @SerializedName("id")
    private int id;

    @SerializedName("task_id")
    private int task_id;

    @SerializedName("user_id")
    private int user_id;

    @SerializedName("attachment")
    private String attachment;

    @SerializedName("grade")
    private int grade;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("updated_at")
    private Date updated_at;

    public AssignmentTaskModel() {
    }

    public AssignmentTaskModel(int id, int task_id, int user_id, String attachment, int grade, Date created_at, Date updated_at) {
        this.id = id;
        this.task_id = task_id;
        this.user_id = user_id;
        this.attachment = attachment;
        this.grade = grade;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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