package org.aplas.lms.configs;

public class Constants {
    public static final String BASE_URL = "https://learning-system-api.herokuapp.com/api/";

    // Auths

    public static final String LOGIN_URL = "auth/login";
    public static final String LOGOUT_URL = "auth/logout";
    public static final String REGISTER_URL = "auth/register";

    // Attendance

    public static final String CREATE_ATTENDANCE_URL = "attendances";
    public static final String SHOW_ATTENDANCE_URL = "attendances/{id}";
    public static final String GET_ATTENDANCE_BY_ID_COURSE_URL = "attendances/course/{id}";
    public static final String IS_ALREADY_ATTENDANCE_URL = "attendances/check";

    // Courses

    public static final String CREATE_COURSE_URL = "courses";
    public static final String SHOW_COURSE_URL = "courses/{id}";
    public static final String UPDATE_COURSE_URL = "courses/{id}";
    public static final String DELETE_COURSE_URL = "courses/{id}";
    public static final String GET_ALL_COURSE_URL = "courses";
    public static final String GET_COURSE_BY_ID_USER_URL = "courses/get/user";

    // Courses Material

    public static final String CREATE_COURSE_MATERIAL_URL = "course-materials";
    public static final String SHOW_COURSE_MATERIAL_URL = "course-materials/{id}";
    public static final String UPDATE_COURSE_MATERIAL_URL = "course-materials/{id}";
    public static final String DELETE_COURSE_MATERIAL_URL = "course-materials/{id}";
    public static final String GET_ALL_COURSE_MATERIAL_URL = "course-materials";
    public static final String GET_COURSE_MATERIAL_BY_ID_COURSE_URL = "course-materials/course/{id}";

    // Task

    public static final String CREATE_TASK_URL = "tasks";
    public static final String SHOW_TASK_URL = "tasks/{id}";
    public static final String UPDATE_TASK_URL = "tasks/{id}";
    public static final String DELETE_TASK_URL = "tasks/{id}";
    public static final String GET_ALL_TASK_URL = "tasks";
    public static final String GET_TASK_BY_ID_COURSE_URL = "tasks/course/{id}";

    // Assignment Task

    public static final String CREATE_ASSIGNMENT_TASK_URL = "assignment-tasks";
    public static final String SHOW_ASSIGNMENT_TASK_URL = "assignment-tasks/{id}";
    public static final String UPDATE_ASSIGNMENT_TASK_URL = "assignment-tasks/{id}";
    public static final String DELETE_ASSIGNMENT_TASK_URL = "assignment-tasks/{id}";
    public static final String GET_ALL_ASSIGNMENT_TASK_URL = "assignment-tasks";
    public static final String GET_ASSIGNMENT_TASK_BY_ID_TASK_URL = "assignment-tasks/task/{id}";

}
