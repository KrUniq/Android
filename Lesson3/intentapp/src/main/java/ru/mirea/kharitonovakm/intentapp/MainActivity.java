package ru.mirea.kharitonovakm.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long dateInMillis = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        String currentTime = sdf.format(new Date(dateInMillis));
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("currentTime", currentTime);
        startActivity(intent);
    }
}