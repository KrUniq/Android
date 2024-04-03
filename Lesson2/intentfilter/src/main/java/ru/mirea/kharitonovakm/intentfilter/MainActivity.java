package ru.mirea.kharitonovakm.intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Находим кнопки по их идентификаторам
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button webButton = findViewById(R.id.webButton);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button fioButton = findViewById(R.id.fioButton);

        // Устанавливаем обработчики нажатия кнопок
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onWebClick();
            }
        });

        fioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFIOsend();
            }
        });
    }
    public void onWebClick() {
        Uri address = Uri.parse("https://www.mirea.ru/");
        Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openLinkIntent);
    }
    public void onFIOsend() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Харитонова Кристина Михайловна");
        startActivity(Intent.createChooser(shareIntent, "ХКМ"));
    }

}