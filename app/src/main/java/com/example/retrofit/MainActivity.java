package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.retrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences("sharedpreferances", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ApiServier apiServier = ApiServier.Retrofitclass.getRetrofitInstance();
        binding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiServier.logout().enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        editor.clear().commit();

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
        apiServier.getVideos().enqueue(new Callback<Videos>() {
            @Override
            public void onResponse(Call<Videos> call, Response<Videos> response) {
                Videos videos = response.body();
                ArrayList<Videos.VediosData> userDataArrayList = videos.getUserDataArrayList();
                Adapter adapter = new Adapter(userDataArrayList, getApplicationContext());
                binding.rv.setAdapter(adapter);
                binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
            }


            @Override
            public void onFailure(Call<Videos> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}