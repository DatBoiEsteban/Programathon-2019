package com.stardust.programathon2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.stardust.programathon2019.Controller.SessionManager;

public class HistoryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    public void goBack(View view) {
        finish();
    }
}
