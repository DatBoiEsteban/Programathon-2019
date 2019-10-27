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
    TextView name, dni, class_text, test, status, birthday;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_data_shell);

        getIntent().getSerializableExtra("kid_selected");
        Kid kid = (Kid) SessionManager.getInstance().getSession().retrieve("kid_map" );

        name = findViewById(R.id.shell_name);
        name.setText(kid.getFirstName() + " " + kid.getLastName());
        dni = findViewById(R.id.shell_dni);
        String dni_text = String.valueOf(kid.getDni());
        class_text = findViewById(R.id.shell_class);
        class_text.setText("Año clase: " + (int) kid.getClassRoom().getClassYear());
        dni.setText("Cédula: " + dni_text);
        test = findViewById(R.id.shell_test);
        test.setText("Prueba: " +kid.getForm().getName());
        status = findViewById(R.id.shell_status);
        status.setText("Estado: " + kid.getStatus());
        birthday = findViewById(R.id.shell_birthday);
        birthday.setText("Fecha de Nacimiento: " + (kid.getDob().split("T"))[0]);
        dialog = new Dialog(this);
    }

    public void goBack(View view) {
        finish();
    }
}
