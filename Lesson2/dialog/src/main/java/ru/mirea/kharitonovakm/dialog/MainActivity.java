package ru.mirea.kharitonovakm.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button timeButton = findViewById(R.id.time_button);
        timeButton.setOnClickListener(view -> {
            MyTimeDialogFragment timeDialog = new MyTimeDialogFragment();

            timeDialog.show(getSupportFragmentManager(), "time_dialog");
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button dateButton = findViewById(R.id.date_button);
        dateButton.setOnClickListener(view -> {
            MyDateDialogFragment dateDialog = new MyDateDialogFragment();
            dateDialog.show(getSupportFragmentManager(), "date_dialog");
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button progressDialogButton = findViewById(R.id.progress_dialog_button);
        progressDialogButton.setOnClickListener(view -> {
            MyProgressDialogFragment progressDialog = new MyProgressDialogFragment();
            progressDialog.show(getSupportFragmentManager(), "progress_dialog");
        });
    }
    public void onClickShowDialog(View view) {
        MyDialogFragment dialogFragment=new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"mirea");
    }
    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }
}