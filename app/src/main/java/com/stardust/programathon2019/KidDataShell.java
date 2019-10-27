package com.stardust.programathon2019;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.stardust.programathon2019.Controller.SessionManager;
import com.stardust.programathon2019.Model.Kid;

public class KidDataShell extends AppCompatActivity {
    TextView name;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_data_shell);

        getIntent().getSerializableExtra("kid_selected");
        Kid kid = (Kid) SessionManager.getInstance().getSession().retrieve("kid_map" );

        name = findViewById(R.id.shell_name);
        name.setText(kid.getFirstName() + " " + kid.getLastName());
        dialog = new Dialog(this);
    }

    public void goBack(View view) {
        finish();
    }
}
