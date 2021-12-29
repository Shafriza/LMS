package org.aplas.lms.activities.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.aplas.lms.R;
import org.aplas.lms.activities.MainActivity;
import org.aplas.lms.configs.ApiUtils;
import org.aplas.lms.configs.SessionManager;
import org.aplas.lms.interfaces.ApiService;
import org.aplas.lms.requests.auths.LogoutRequest;
import org.aplas.lms.responses.auths.LogoutResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentHomeActivity extends AppCompatActivity {
    private SessionManager sessionManager;
    private ApiService apiService;
    private CardView cv_absen, cv_pengumpulan_tugas, cv_materi, cv_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        cv_absen = (CardView) findViewById(R.id.cv_absen);
        cv_pengumpulan_tugas = (CardView) findViewById(R.id.cv_pengumpulan_tugas);
        cv_materi = (CardView) findViewById(R.id.cv_materi);
        cv_logout = (CardView) findViewById(R.id.cv_logout);

        apiService = ApiUtils.getApiService(this);
        sessionManager = new SessionManager(this);

        cv_absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomeActivity.this, StudentAttendanceActivity.class);
                startActivity(intent);
            }
        });

        cv_pengumpulan_tugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomeActivity.this, StudentAssignmentTaskActivity.class);
                startActivity(intent);
            }
        });

        cv_materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentHomeActivity.this, StudentCourseMaterialActivity.class);
                startActivity(intent);
            }
        });

        cv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

    }
    public void logout(){
        String email = sessionManager.fetchAuthEmail();
        Call<LogoutResponse> call = apiService.logout(new LogoutRequest(email));
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
                    Toast.makeText(StudentHomeActivity.this, "User logout fail!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                Toast.makeText(StudentHomeActivity.this, "User logout fail!", Toast.LENGTH_SHORT).show();

                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}