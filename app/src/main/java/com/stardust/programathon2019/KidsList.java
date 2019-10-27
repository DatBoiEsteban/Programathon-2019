package com.stardust.programathon2019;

import android.content.Intent;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.stardust.programathon2019.Controller.StudentController;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Controller.SessionManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Debug;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KidsList extends AppCompatActivity implements AwaitableResponse {
    private KidsList instance = this;
    private TableLayout table;
    private ImageButton back_button;
    private Button consult_button;

    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_kids_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StudentController.getMyStudents(this);
        table = findViewById(R.id.kidstable);
        back_button = findViewById(R.id.back_button);
        dialog = new Dialog(this);
    }

    @Override
    public void onBackPressed() {
        showPopUp(this.getCurrentFocus());
    }

    public void showPopUp(View v) {
        dialog.setContentView(R.layout.log_out_pop_up);
        Button btnClose = dialog.findViewById(R.id.log_out_accept_button);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionManager.getInstance().endSession();
                instance.finish();
            }
        });
        Button btnKeepOpen = dialog.findViewById(R.id.log_out_deny_button);
        btnKeepOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void updateTable(Kid[] kids) {
        for (final Kid kid : kids) {
            final TableRow row = new TableRow(this);
            final TextView kid_name = new TextView(this);
            kid_name.setText(kid.getFirstName() + " " + kid.getLastName());
            kid_name.setTextSize(18);
            kid_name.setGravity(Gravity.CENTER_HORIZONTAL);
            kid_name.setCompoundDrawablePadding(4);
            TextView test_name = new TextView(this);
            test_name.setText(kid.getForm().getName());
            test_name.setTextSize(18);
            test_name.setGravity(Gravity.CENTER_HORIZONTAL);
            test_name.setCompoundDrawablePadding(4);
            kid_name.setClickable(true);

            kid_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (view == kid_name) {
                        SessionManager.getInstance().getRawMap().put("kid_map", kid);
                        Intent intent;
                        intent = new Intent(view.getContext(), KidDataShell.class);
                        startActivity(intent);
                    }
                }
            });

            row.addView(kid_name);
            row.addView(test_name);
            row.setBackground(getDrawable(R.drawable.table_format));

            table.addView(row);
        }
    }

    @Override
    public void onComplete(Object obj) {
        if (obj == null) {
            return;
        }
        Kid[] kids = (Kid[])obj;

        updateTable(kids);
    }
}
