package com.weatherapplication.Activities;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.weatherapplication.Adapters.HourlyAdapters;
import com.weatherapplication.Domains.Hourly;
import com.weatherapplication.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycleview();
        setVariable();
    }

    private void setVariable() {
        TextView next7dayBtn = findViewById(R.id.nextBtn);
        next7dayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FutureActivity.class));
            }
        });
    }

    private void initRecycleview() {
        ArrayList<Hourly> items = new ArrayList<>();

        items.add(new Hourly("9 pm", 28, "cloudy"));
        items.add(new Hourly("11 pm", 28, "sunny"));
        items.add(new Hourly("12 pm", 28, "wind"));
        items.add(new Hourly("1 am", 28, "rainy"));
        items.add(new Hourly("2 am", 28, "storm"));

        recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterHourly = new HourlyAdapters(items);
        recyclerView.setAdapter(adapterHourly);
    }
}