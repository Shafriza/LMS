package org.aplas.lms.requests.courses;

import com.google.gson.annotations.SerializedName;

public class AddCourseRequest {
    @SerializedName("name")
    private String name;

    public AddCourseRequest() {
    }

    public AddCourseRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
