package org.aplas.lms.activities.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import org.aplas.lms.R;
import org.aplas.lms.activities.MainActivity;
import org.aplas.lms.configs.ApiUtils;
import org.aplas.lms.configs.SessionManager;
import org.aplas.lms.interfaces.ApiService;
import org.aplas.lms.requests.attendances.IsAlreadyAttendanceRequest;
import org.aplas.lms.requests.auths.LogoutRequest;
import org.aplas.lms.responses.attendances.IsAlreadyAttendanceResponse;
import org.aplas.lms.responses.auths.LogoutResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentAttendanceCheckActivity extends AppCompatActivity {
    RadioButton rb_hadir, rb_alpha, rb_izin, rb_sakit;
    ProgressBar pb_login;
    Button btn_absen;
    private SessionManager sessionManager;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance_check);

        rb_hadir = findViewById(R.id.rb_hadir);
        rb_alpha = findViewById(R.id.rb_alpha);
        rb_izin = findViewById(R.id.rb_izin);
        rb_sakit = findViewById(R.id.rb_sakit);
        pb_login = findViewById(R.id.pb_login);
        btn_absen = findViewById(R.id.btn_absen);

        apiService = ApiUtils.getApiService(this);
        sessionManager = new SessionManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Call<IsAlreadyAttendanceResponse> call = apiService.is_already_attendance(new IsAlreadyAttendanceRequest());
        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                LogoutResponse logoutResponse = response.body();
                if(response.code() == 201 && logoutResponse.getStatus()){
                    sessionManager.saveAuthEmail(null);
                    sessionManager.saveUserRole(null);
                    sessionManager.saveAuthToken(null);

                    Intent Login = new Intent(getApplicationContext(), MainActivity.class);
                    Login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(Login);
                    finish();
                }else{
                    Toast.makeText(StudentAttendanceCheckActivity.this, "User logout fail!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Toast.makeText(StudentAttendanceCheckActivity.this, "User logout fail!", Toast.LENGTH_SHORT).show();

                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}