package com.stardust.programathon2019;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class questionaire_table extends AppCompatActivity {
    private TableLayout table;
    private Button backButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionaire_list_by_kid_activity);
        table = findViewById(R.id.questionaire_test_table);
        backButton = findViewById(R.id.back_button_questionaire_list);
    }


}
