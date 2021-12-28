package org.aplas.lms.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.aplas.lms.R;
import org.aplas.lms.configs.ApiUtils;
import org.aplas.lms.configs.SessionManager;
import org.aplas.lms.interfaces.ApiService;
import org.aplas.lms.requests.auths.LoginRequest;
import org.aplas.lms.responses.auths.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private SessionManager sessionManager;
    private ApiService apiService;

    private TextView tv_ForgotPassword;
    private Button btn_Login;
    private EditText et_Email, et_Password;
    private ProgressBar pb_Loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_ForgotPassword = findViewById(R.id.tv_forgot_password);
        btn_Login = findViewById(R.id.btn_login);
        pb_Loading = findViewById(R.id.pb_login);
        et_Email = findViewById(R.id.et_email);
        et_Password = findViewById(R.id.et_password);

        apiService = ApiUtils.getApiService(this);

        sessionManager = new SessionManager(this);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_email = et_Email.getText().toString().trim();
                String str_password = et_Password.getText().toString().trim();

                if(!str_email.isEmpty() && !str_password.isEmpty()){
                    Login(str_email, str_password);
                }else{
                    if(str_email.isEmpty()){
                        et_Email.setError("Tolong isikan email");
                    }
                    if(str_password.isEmpty()){
                        et_Password.setError("Tolong isikan password");
                    }
                }
            }
        });
    }

    private void Login(String email, String password){
        pb_Loading.setVisibility(View.VISIBLE);
        btn_Login.setVisibility(View.GONE);
        tv_ForgotPassword.setVisibility(View.GONE);

        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // registration is a POST request type method in which we are sending our field's data

        Call<LoginResponse> call = apiService.login(new LoginRequest(email, password, android.os.Build.MODEL.toString()));
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();

                if(response.code() == 201 && loginResponse.getStatus()){
                    sessionManager.saveAuthToken(loginResponse.getData().getToken());
                    sessionManager.saveUserRole(String.valueOf(loginResponse.getData().getUser().getRole()));
                    Toast.makeText(MainActivity.this, "User login successfully!", Toast.LENGTH_SHORT).show();

                    if(loginResponse.getData().getUser().getRole() == 1){
                            Intent DashboardSellerActivity = new Intent(getApplicationContext(), HomeLectureActivity.class);
                            DashboardSellerActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(DashboardSellerActivity);
                            finish();
                    }else if(loginResponse.getData().getUser().getRole() == 2){
                            Intent DashboardBuyerActivity = new Intent(getApplicationContext(), HomeActivity.class);
                            DashboardBuyerActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(DashboardBuyerActivity);
                            finish();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "User login fail!", Toast.LENGTH_SHORT).show();
                }

                pb_Loading.setVisibility(View.GONE);
                btn_Login.setVisibility(View.VISIBLE);
                tv_ForgotPassword.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "User login fail!", Toast.LENGTH_SHORT).show();

                Log.e("ERROR: ", t.getMessage());
                pb_Loading.setVisibility(View.GONE);
                btn_Login.setVisibility(View.VISIBLE);
                tv_ForgotPassword.setVisibility(View.VISIBLE);
            }
        });

    }
}