package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnAlpha, btnActivity2;
    private ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlpha = findViewById(R.id.btnAlpha);
        btnActivity2 = findViewById(R.id.btnActivity2);
        imgLogo = findViewById(R.id.imgLogo);

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.together);
                imgLogo.startAnimation(animation);
            }
        });

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
                overridePendingTransition(R.anim.anim_activity_enter, R.anim.anim_activity_exit);
            }
        });
    }
}