package com.stardust.programathon2019;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class KidsListActivity extends AppCompatActivity {
    private ImageButton back_button;
    private ImageButton nav_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_list);

        //back_button = findViewById(R.id.back_button);
        //nav_button = findViewById(R.id.nav_button);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code for data validation
            }
        });
        nav_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code for data validation
            }
        });
    }
}
