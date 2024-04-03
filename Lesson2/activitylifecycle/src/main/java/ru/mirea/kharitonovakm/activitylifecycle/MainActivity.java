package ru.mirea.kharitonovakm.activitylifecycle;

import static android.content.ContentValues.TAG;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /*с него начинается выполнение*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /* выполняет подготовку к выводу activity на экран */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }
    /* для восстановления сохраненного состояния из объекта Bundle */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }
    /* для перезапуска активности */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }
    /* переводит activity в состояние resumed */
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }
    /* для освобождения/приостановления процессов */
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }
    /* производится сохранение состояния приложения, после onPause, но до onStop */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG, "onSaveInstanceState");
    }
    /* остановка активности */
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }
    /* для уничтожения activity системой */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}