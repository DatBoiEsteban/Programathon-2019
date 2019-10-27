package com.stardust.programathon2019;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.stardust.programathon2019.Model.Kid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class KidsList extends AppCompatActivity {
    private TableLayout table;

    private ArrayList<String> kids;
    private ArrayList<String> tests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        table = findViewById(R.id.kidstable);
        updateTable();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
