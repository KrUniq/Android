package ru.mirea.kharitonovakm.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Получение времени из Intent
        String currentTime = getIntent().getStringExtra("currentTime");
        Integer qNumber=29*29;

        // Формирование строки
        String textToShow = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ ЧИСЛО 29, " + qNumber +
                "\n  а текущее время " + currentTime;

        // Отображение строки в TextView
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = findViewById(R.id.textView);
        textView.setText(textToShow);
    }
}