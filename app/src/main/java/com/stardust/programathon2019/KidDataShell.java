package com.stardust.programathon2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.stardust.programathon2019.Controller.SessionManager;
import com.stardust.programathon2019.Model.Kid;

public class KidDataShell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_data_shell);

        getIntent().getSerializableExtra("kid_selected");
        Kid kid = (Kid) SessionManager.getInstance().getRawMap().get("kid_map");

        System.out.println(kid.getFirstName());
    }
}
