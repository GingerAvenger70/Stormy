package com.example.kenne.stormy.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.example.kenne.stormy.R;
import com.example.kenne.stormy.weather.Hour;
import com.example.kenne.stormy.adapters.HourlyAdapter;
import com.example.kenne.stormy.databinding.ActivityHourlyForecastBinding;

import java.util.ArrayList;
import java.util.List;

public class HourlyForecastActivity extends AppCompatActivity {

    private HourlyAdapter adapter;
    private ActivityHourlyForecastBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        List<Hour> hoursList = (List<Hour>) intent.getSerializableExtra("HourlyList");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_hourly_forecast);

        adapter = new HourlyAdapter(hoursList,this);

        binding.hourlyListItems.setAdapter(adapter);
        binding.hourlyListItems.setHasFixedSize(true);
        binding.hourlyListItems.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.hourlyListItems.setLayoutManager(new LinearLayoutManager(this));
    }

}
