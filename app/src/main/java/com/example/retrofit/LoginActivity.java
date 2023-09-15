package com.example.retrofit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofit.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    SharedPreferences.Editor editor;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sp = getSharedPreferences("sharedpreferances", MODE_PRIVATE);
        editor = sp.edit();

        String x = sp.getString("token", "Not found");
        Log.d("LoginMethod", "Value of token is: " + x);

        if (!sp.getString("token", "").isEmpty()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        }

        binding.LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String email = binding.EtEmail.getText().toString();
        String password = binding.EtPassword.getText().toString();
        LoginRequest loginRequest = new LoginRequest("ANDROID", "7.1.0", email, password, "student", "10", "acsadcfsa", "fdvdsvsd");
        loginRequest.setOs("ANDROID");
        loginRequest.setVersion("7.1.0");
        loginRequest.setUsername(email);
        loginRequest.setPassword(password);
        loginRequest.setUser_type("student");
        loginRequest.setOs_version("10");
        loginRequest.setDevice_token("acsadcfsa");
        loginRequest.setDevice_id("fdvdsvsd");

        ApiServier.Retrofitclass.getRetrofitInstance().LoginResponse(
                loginRequest.getOs(), loginRequest.getVersion(), loginRequest.getOs_version(), loginRequest.getDevice_token(), loginRequest.getDevice_id(), loginRequest.getUsername(), loginRequest.getPassword(), loginRequest.getUser_type()
        ).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse loginResponse2 = response.body();
                    String token = loginResponse2.token;
                    editor.putString("token", token);
                    editor.apply();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    try {
                        String erorr = response.errorBody().string();
                        JSONObject jsonObject = new JSONObject(erorr);
                        JSONObject jsonObjecterorr = jsonObject.getJSONObject("error");
                        String code = jsonObjecterorr.getString("code");
                        String message = jsonObjecterorr.getString("message");
                        Toast.makeText(LoginActivity.this, "code " + code + " message " + message, Toast.LENGTH_SHORT).show();
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}