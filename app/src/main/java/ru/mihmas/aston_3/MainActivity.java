package ru.mihmas.aston_3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import ru.mihmas.aston_3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
    }
}