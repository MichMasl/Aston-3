package ru.mihmas.aston_3;

import android.app.Application;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class App extends Application {
    private final Executor executor = Executors.newSingleThreadExecutor();
    public Executor getExecutor() {
        return executor;
    }
}
