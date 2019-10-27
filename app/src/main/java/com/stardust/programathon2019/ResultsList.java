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


        for (int j = 0; j<6; j++) {
            for (int i = 0; i<6; i++) {
                table.get(j).get(i);
            }
        }
    }

    private void updateTable() {

    }

    public void goBack(View view) {
        finish();
    }
}
