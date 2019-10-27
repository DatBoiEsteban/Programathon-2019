package com.stardust.programathon2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.stardust.programathon2019.Controller.AttendanceController;
import com.stardust.programathon2019.Controller.Session;
import com.stardust.programathon2019.Controller.SessionManager;
import com.stardust.programathon2019.Model.AttendanceResult;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Kid;

public class HistoryActivity extends AppCompatActivity implements AwaitableResponse {
    TextView name, test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Kid kid = (Kid) SessionManager.getInstance().getSession().retrieve("kid_map");

        name = findViewById(R.id.history_name);
        name.setText(kid.getFirstName() + " " + kid.getLastName());
        test = findViewById(R.id.history_test);
        test.setText("Prueba: " + kid.getForm().getName());

        AttendanceController.getAttendanceByStudentId(kid.getId(), this);
    }

    public void goBack(View view) {
        finish();
    }

    @Override
    public void onComplete(Object obj) {
        AttendanceResult result = (AttendanceResult)obj;
        result.getResultList();


    }
}
