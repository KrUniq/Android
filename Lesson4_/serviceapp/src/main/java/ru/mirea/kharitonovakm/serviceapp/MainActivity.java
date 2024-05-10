package ru.mirea.kharitonovakm.serviceapp;

import static android.Manifest.permission.FOREGROUND_SERVICE;
import static android.Manifest.permission.POST_NOTIFICATIONS;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import ru.mirea.kharitonovakm.serviceapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static private final int PermissionCode = 200;
    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final boolean foreground_service_enabled = ContextCompat.checkSelfPermission(this, FOREGROUND_SERVICE) == PackageManager.PERMISSION_GRANTED;
        final boolean post_notifincation_enabled = ContextCompat.checkSelfPermission(this, POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED;
        if (foreground_service_enabled && post_notifincation_enabled) {
            Log.d(MainActivity.class.getSimpleName().toString(), "Разрешения получены");
        } else {
            Log.d(MainActivity.class.getSimpleName().toString(), "Нет разрешений!");
            ActivityCompat.requestPermissions(this, new String[]{POST_NOTIFICATIONS, FOREGROUND_SERVICE}, PermissionCode);
        }
    }
    public void OnPlayButtonClicked(View v) {
        Intent serviceIntent = new Intent(MainActivity.this, MyService.class);
        serviceIntent.putExtra(MyService.RESOURCE_TITLE, "Imagine Dragons - Believer");
        serviceIntent.putExtra(MyService.RESOURCE_ID, R.raw.music);
        ContextCompat.startForegroundService(MainActivity.this, serviceIntent);
    }
    public void OnStopButtonClicked(View v) {
        stopService(new Intent(MainActivity.this, MyService.class));
    }
}