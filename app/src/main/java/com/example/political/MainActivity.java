package com.example.political;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final int zipCode = 0;
    public static final String EXTRA_MESSAGE = "com.example.androidproject4330.MESSAGE";
    public EditText zipCodeBox;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zipCodeBox = findViewById(R.id.zip_code);
        Button getData = findViewById(R.id.getDataButton);
        Button button = findViewById(R.id.search_zip);

        button.setOnClickListener(view -> openMainActivity2());

        getData.setOnClickListener(view -> {
            Methods methods = RetroFitClient.getRetrofitInstance().create(Methods.class);
            Call<DataModel> call = methods.getAllData();

            call.enqueue(new Callback<DataModel>() {
                @Override
                public void onResponse(@NonNull Call<DataModel> call, @NonNull Response<DataModel> response) {
                    Log.e(TAG, "onResponse: code : " +response.code());

                    assert response.body() != null;
                    ArrayList<DataModel.data> data = response.body().getData();

                    for(DataModel.data data1 : data) {
                        Log.e(TAG, "onResponse: emails:"+data1.getEmail() );
                    }
                }

                @Override
                public void onFailure(@NonNull Call<DataModel> call, @NonNull Throwable t) {
                    Log.e(TAG, "onFailure: "+t.getMessage() );
                }
            });
        });


    }

    private void openMainActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        String message = zipCodeBox.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}