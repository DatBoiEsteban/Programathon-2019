package com.stardust.programathon2019;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.stardust.programathon2019.Controller.SessionManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

public class KidsList extends AppCompatActivity {
    private KidsList instance = this;
    private TableLayout table;
    private ImageButton backButton;

    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        table = findViewById(R.id.kidstable);
        backButton = findViewById(R.id.back_button);
        dialog = new Dialog(this);

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

}
