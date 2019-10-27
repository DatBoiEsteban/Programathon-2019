package com.stardust.programathon2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.stardust.programathon2019.Controller.SessionManager;
import com.stardust.programathon2019.Model.Kid;

public class HistoryActivity extends AppCompatActivity {
    TextView name, test, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Kid kid = (Kid) SessionManager.getInstance().getSession().retrieve("kid_map");

        name = findViewById(R.id.history_name);
        name.setText(kid.getFirstName() + " " + kid.getLastName());
        test = findViewById(R.id.history_test);
        test.setText("Prueba: " + kid.getForm().getName());
    }

    public void goBack(View view) {
        finish();
    }
}
