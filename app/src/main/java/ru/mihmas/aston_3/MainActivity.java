package ru.mihmas.aston_3;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import ru.mihmas.aston_3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bind;
    private App app;
    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        app = (App) getApplication();

        bind.downloadButton.setOnClickListener((click) ->
        {
            String url = bind.urlEditText.getText().toString();
            loadBitmap(url);
        });
    }

    private void loadBitmap(String url) {
        app.getExecutor().execute(() -> {
            try {
                Bitmap bitmap;
                URL imageUrl = new URL(url);
                HttpURLConnection urlConnection = (HttpURLConnection) imageUrl.openConnection();
                urlConnection.setReadTimeout(500);
                BufferedInputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                bitmap = BitmapFactory.decodeStream(inputStream);
                handler.post(() -> bind.image.setImageBitmap(bitmap));
            } catch (Exception e) {
                handler.post(() -> {
                    bind.image.setImageResource(R.drawable.no_image);
                    Toast.makeText(
                            MainActivity.this,
                            "Картинка не загрузилась",
                            Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}