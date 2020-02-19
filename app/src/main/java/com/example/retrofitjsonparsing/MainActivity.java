package com.example.retrofitjsonparsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<CarModels> carModels = new ArrayList<>();
    private CarsAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getCarDetails();

    }

        private void getCarDetails() {

        RetrofitInterface retrofitInterface = RetrofitRequest.getRetrofitInstance().create(RetrofitInterface.class);
        Call<List<CarModels>> call = retrofitInterface.getAllCarModels();
        
        call.enqueue(new Callback<List<CarModels>>() {
            @Override
            public void onResponse(Call<List<CarModels>> call, Response<List<CarModels>> response) {

                carModels = new ArrayList<>(response.body());
                adapter = new CarsAdapter(MainActivity.this, carModels);
                recyclerView.setAdapter(adapter);

                Toast.makeText(MainActivity.this, "Success code : " + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<CarModels>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
       

    }
}

