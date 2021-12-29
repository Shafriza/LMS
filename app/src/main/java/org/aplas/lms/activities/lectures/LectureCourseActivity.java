package org.aplas.lms.activities.lectures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.aplas.lms.R;
import org.aplas.lms.adapters.lectures.CourseAdapter;
import org.aplas.lms.configs.ApiUtils;
import org.aplas.lms.dialogs.AddCourseDialog;
import org.aplas.lms.interfaces.ApiService;
import org.aplas.lms.responses.courses.CourseResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LectureCourseActivity extends AppCompatActivity {

    FloatingActionButton fab_add;
    private ApiService apiService;
    private ProgressBar pb_loading;
    private RecyclerView rv_course;
    private CourseAdapter courseAdapter;

    private ArrayList<CourseResponse> courseArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_course);

        fab_add = findViewById(R.id.fb_add);
        pb_loading = findViewById(R.id.pb_loading);
        rv_course = findViewById(R.id.rv_course);
        apiService = ApiUtils.getApiService(this);

        getCourse();

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCourseDialog dialogForm = new AddCourseDialog();
                dialogForm.show(getSupportFragmentManager(),"form");
            }
        });
    }

    private void getCourse() {
        pb_loading.setVisibility(View.VISIBLE);
        rv_course.setVisibility(View.GONE);

        Call<ArrayList<CourseResponse>> call = apiService.get_course_by_id_user();
        call.enqueue(new Callback<ArrayList<CourseResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<CourseResponse>> call, Response<ArrayList<CourseResponse>> response) {
                if(response.code() == 200){
                    courseArrayList = response.body();
                    courseAdapter = new CourseAdapter(getApplicationContext(), courseArrayList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LectureCourseActivity.this);
                    rv_course.setLayoutManager(layoutManager);
                    rv_course.setAdapter(courseAdapter);
                    pb_loading.setVisibility(View.GONE);
                    rv_course.setVisibility(View.VISIBLE);
                }else if(response.code() == 422){
                    pb_loading.setVisibility(View.GONE);
                    rv_course.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CourseResponse>> call, Throwable t) {
                Log.e("errroooo", t.toString());
            }
        });
    }
}
