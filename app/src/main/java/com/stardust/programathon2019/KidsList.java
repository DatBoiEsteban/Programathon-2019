package com.stardust.programathon2019;

import android.content.Intent;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Controller.SessionManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class KidsList extends AppCompatActivity {
    private KidsList instance = this;
    private TableLayout table;
    private ImageButton backButton;

    private ArrayList<String> kids;
    private ArrayList<String> tests;

    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_kids_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        kids = new ArrayList<>();
        tests = new ArrayList<>();
        table = findViewById(R.id.kidstable);
        updateTable();
        backButton = findViewById(R.id.back_button);
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

    private void updateTable() {
        kids.add("Charlie");
        kids.add("Castri");
        kids.add("Elote");
        kids.add("Bryan");
        tests.add("ASQ-3 1");
        tests.add("ASQ-3 2");
        tests.add("ASQ-3 3");
        tests.add("ASQ-3 4");

        for (int i = 0; i < kids.size(); i++) {
            TableRow row = new TableRow(this);
            TextView kid_name = new TextView(this);
            kid_name.setText(kids.get(i));
            TextView test_name = new TextView(this);
            test_name.setText(tests.get(i));

            row.addView(test_name);
            table.addView(row);
        }
    }

}
