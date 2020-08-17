package com.example.loadingutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LoadingUtils utils = LoadingUtils.init(this);
        utils.startLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                utils.finishLoading();
            }
        },5000);

    }
}