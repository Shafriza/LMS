package org.aplas.lms.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.aplas.lms.R;
import org.aplas.lms.adapters.CourseAdapter;
import org.aplas.lms.configs.ApiUtils;
import org.aplas.lms.dialogs.AddCourseDialog;
import org.aplas.lms.interfaces.ApiService;
import org.aplas.lms.models.CourseModel;
import org.aplas.lms.models.UserLectureModel;
import org.aplas.lms.responses.courses.CourseResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity {

    FloatingActionButton fab_add;
    private ApiService apiService;
    private ProgressBar pb_loading;
    private RecyclerView rv_course;
    private CourseAdapter courseAdapter;

    private ArrayList<CourseModel> courseArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

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

        courseAdapter = new CourseAdapter(this,courseArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CourseActivity.this);
        rv_course.setLayoutManager(layoutManager);
        rv_course.setAdapter(courseAdapter);
    }

    private void getCourse() {
        pb_loading.setVisibility(View.VISIBLE);
        rv_course.setVisibility(View.GONE);

        Call<CourseResponse> call = apiService.get_course_by_id_user();
        call.enqueue(new Callback<CourseResponse>() {
            @Override
            public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
                try {
                    if(response.code() == 200){
                        JSONArray jsonArray = new JSONArray(response.body());

                        for (int i=0; i<jsonArray.length(); ++i) {
                            CourseModel cm = new CourseModel();
                            JSONObject itemObj = jsonArray.getJSONObject(i);

                            cm.setId(itemObj.getInt("id"));
                            cm.setName(itemObj.getString("name"));
                            cm.setCreated_at(itemObj.get);

                            JSONObject user = itemObj.getJSONObject("user");


                            Log.d("tes", String.valueOf(user));
//                            Integer id = itemObj.getJSONArray("user").get("id");
//                            String name = itemObj.getString("name");
//                            Date created_at = itemObj.getString("created_at");
//                            Date updated_at = itemObj.getString("updated_at");
//
//
//                            CourseModel courseModel = new CourseModel(id, user, name, created_at, updated_at);
//                            courseArrayList.add(courseModel);
                        }

                        pb_loading.setVisibility(View.GONE);
                        rv_course.setVisibility(View.VISIBLE);
                    }else if(response.code() == 422){
                        pb_loading.setVisibility(View.GONE);
                        rv_course.setVisibility(View.VISIBLE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {
                Log.e("errroooo", t.toString());
            }
        });
    }
}