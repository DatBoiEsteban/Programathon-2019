package com.stardust.programathon2019;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.stardust.programathon2019.Controller.AttendanceController;
import com.stardust.programathon2019.Controller.ResultController;
import com.stardust.programathon2019.Controller.SessionManager;
import com.stardust.programathon2019.Model.Attendance;
import com.stardust.programathon2019.Model.AttendanceResult;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Model.Result;

public class questionaire_table extends AppCompatActivity implements AwaitableResponse {
    private TableLayout table;
    private Button backButton;
    private TextView nameText;
    private TextView ageText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionaire_list_by_kid_activity);
        table = findViewById(R.id.questionaire_test_table);
        backButton = findViewById(R.id.back_button_questionaire_list);
        Kid kido = (Kid)SessionManager.getInstance().getSession().retrieve("kid_map");
        nameText = findViewById(R.id.questionaire_kid_name);
        nameText.setText(kido.getFirstName() + " " + kido.getLastName());

        ageText = findViewById(R.id.questionaire_kid_age);
        ageText.setText("");

        AttendanceController.getAttendanceByStudentId(kido.getDni(), this);
    }


    @Override
    public void onComplete(Object obj) {
        if(obj == null) return;
        Attendance[] results = (Attendance[])obj;
        for (Attendance result: results) {
            final TableRow row = new TableRow(this);
            final TextView testName = new TextView(this);
            testName.setText(result.getForm().getName());
            testName.setTextSize(18);
            testName.setGravity(Gravity.CENTER_HORIZONTAL);
            testName.setCompoundDrawablePadding(4);

            row.addView(testName);
            row.setBackground(getDrawable(R.drawable.table_format));
            table.addView(row);
        }
    }
}
