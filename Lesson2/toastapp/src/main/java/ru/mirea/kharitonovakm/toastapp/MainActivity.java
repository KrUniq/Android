package ru.mirea.kharitonovakm.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button countButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        countButton = findViewById(R.id.button);
        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем текст из поля ввода
                String text = editText.getText().toString();
                // Подсчитываем количество символов
                int count = text.length();
                // Формируем сообщение для Toast
                String message = "СТУДЕНТ No 29 ГРУППА БСБО-04-22 Количество символов - " + count;
                // Отображаем Toast с сообщением
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}