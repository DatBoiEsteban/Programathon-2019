package com.stardust.programathon2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsList extends AppCompatActivity {
    ArrayList<ArrayList<TextView>> table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_list);

        ArrayList<TextView> row = new ArrayList<TextView>();
        row.add((TextView) findViewById(R.id.res_00));
        row.add((TextView) findViewById(R.id.res_01));
        row.add((TextView) findViewById(R.id.res_02));
        row.add((TextView) findViewById(R.id.res_03));
        row.add((TextView) findViewById(R.id.res_04));
        row.add((TextView) findViewById(R.id.res_05));
        table.add(row);
        row.add((TextView) findViewById(R.id.res_10));
        row.add((TextView) findViewById(R.id.res_11));
        row.add((TextView) findViewById(R.id.res_12));
        row.add((TextView) findViewById(R.id.res_13));
        row.add((TextView) findViewById(R.id.res_14));
        row.add((TextView) findViewById(R.id.res_15));
        table.add(row);
        row.add((TextView) findViewById(R.id.res_20));
        row.add((TextView) findViewById(R.id.res_21));
        row.add((TextView) findViewById(R.id.res_22));
        row.add((TextView) findViewById(R.id.res_23));
        row.add((TextView) findViewById(R.id.res_24));
        row.add((TextView) findViewById(R.id.res_25));
        table.add(row);
        row.add((TextView) findViewById(R.id.res_30));
        row.add((TextView) findViewById(R.id.res_31));
        row.add((TextView) findViewById(R.id.res_32));
        row.add((TextView) findViewById(R.id.res_33));
        row.add((TextView) findViewById(R.id.res_34));
        row.add((TextView) findViewById(R.id.res_35));
        table.add(row);
        row.add((TextView) findViewById(R.id.res_40));
        row.add((TextView) findViewById(R.id.res_41));
        row.add((TextView) findViewById(R.id.res_42));
        row.add((TextView) findViewById(R.id.res_43));
        row.add((TextView) findViewById(R.id.res_44));
        row.add((TextView) findViewById(R.id.res_45));
        table.add(row);
        row.add((TextView) findViewById(R.id.res_50));
        row.add((TextView) findViewById(R.id.res_51));
        row.add((TextView) findViewById(R.id.res_52));
        row.add((TextView) findViewById(R.id.res_53));
        row.add((TextView) findViewById(R.id.res_54));
        row.add((TextView) findViewById(R.id.res_55));
        table.add(row);

        for (int j = 0; j<6; j++) {
            for (int i = 0; i<6; i++) {

            }
        }
    }

    private void updateTable() {

    }

    public void goBack(View view) {
        finish();
    }
}
