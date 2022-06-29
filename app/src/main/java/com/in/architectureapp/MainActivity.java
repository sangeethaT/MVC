package com.in.architectureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.in.architectureapp.mvc.MVCActivity;
import com.in.architectureapp.mvvm.MVVmActivity;

public class MainActivity extends AppCompatActivity {
    Button button, mvvmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        mvvmBtn = findViewById(R.id.mvvmBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MVCActivity.class);
                startActivity(intent);

            }
        });

        mvvmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MVVmActivity.class);
                startActivity(intent);
            }
        });
    }
}