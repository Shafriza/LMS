package org.aplas.lms.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.aplas.lms.R;
import org.aplas.lms.activities.lectures.LectureHomeActivity;
import org.aplas.lms.activities.students.StudentHomeActivity;
import org.aplas.lms.configs.SessionManager;
import org.aplas.lms.interfaces.ApiService;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    private SessionManager sessionManager;
    private ApiService apiService;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        loading = findViewById(R.id.pb_loading);
        sessionManager = new SessionManager(this);

        cekUser();
    }

    private void cekUser() {
        if(sessionManager.fetchAuthToken() != null && sessionManager.fetchUserRole() != null){
            loading.setVisibility(View.VISIBLE);
            Toast.makeText(SplashActivity.this, "Welcome back !", Toast.LENGTH_SHORT).show();
            if(sessionManager.fetchUserRole().equalsIgnoreCase("1")){
                    loading.setVisibility(View.GONE);
                    Intent HomeLectureActivity = new Intent(getApplicationContext(), LectureHomeActivity.class);
                    HomeLectureActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(HomeLectureActivity);
                    finish();
            }else if(sessionManager.fetchUserRole().equalsIgnoreCase("2")){
                    loading.setVisibility(View.GONE);
                    Intent HomeActivity = new Intent(getApplicationContext(), StudentHomeActivity.class);
                    HomeActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(HomeActivity);
                    finish();
            }
        }else{
            gotoNext();
        }

    }

    private void gotoNext(){
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent next = new Intent(SplashActivity.this, MainActivity.class);
                next.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(next);
                finish();
            }
        },3000);
    }
}