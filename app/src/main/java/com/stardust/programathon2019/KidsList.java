package com.stardust.programathon2019;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.stardust.programathon2019.Controller.StudentController;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Controller.SessionManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class KidsList extends AppCompatActivity implements AwaitableResponse {
    private KidsList instance = this;
    private TableLayout table;
    private ImageButton backButton;
    private Kid currentKid;
    private int[] date = {0,0,0};

    public Kid getCurrentKid() {
        return currentKid;
    }

    public void setCurrentKid(Kid currentKid) {
        this.currentKid = currentKid;
    }

    private Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_kids_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StudentController.getMyStudents(this);
        table = findViewById(R.id.kidstable);
        backButton = findViewById(R.id.back_button);
        dialog = new Dialog(this);
    }

    @Override
    public void onBackPressed() {
        showPopUp(this.getCurrentFocus());
    }

    public void showPopUp(View v) {  //Log Out
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

    public void searchKid(View v) {
        dialog.setContentView(R.layout.query_by_kid);
        final TextInputLayout studentName = dialog.findViewById(R.id.query_by_name_consult_text);
        Button btnConsult = dialog.findViewById(R.id.query_by_name_consult_button);
        final EditText eText = dialog.findViewById(R.id.query_by_name_date_text);
        eText.setInputType(InputType.TYPE_NULL);
        final Context ctx = v.getContext();
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(ctx,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                date[0] = dayOfMonth;
                                date[1] = monthOfYear + 1;
                                date[2] = year;
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        final SearchListener searchListener = new SearchListener(this);
        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                StudentController.getStudentByDNI(Integer.parseInt(studentName.getEditText().getText().toString()),searchListener );

            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void showKid(View v) {
        dialog.setContentView(R.layout.query_by_kid_info);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView dni = dialog.findViewById(R.id.query_by_name_dni_info);
        TextView dateText = dialog.findViewById(R.id.query_by_name_date_info);
        dateText.setText(date[0] + "/" + date[1] + "/" + date[2]);
        TextView asq = dialog.findViewById(R.id.query_by_name_asq3_info);
        dni.setText(currentKid.getFirstName() + " " + currentKid.getLastName());
        //asq.setText(currentKid.getForm().getName());

        dialog.show();

    }

    private void updateTable(Kid[] kids) {
        for (Kid kid : kids) {
            final TableRow row = new TableRow(this);
            TextView kid_name = new TextView(this);
            kid_name.setText(kid.getFirstName() + " " + kid.getLastName());
            kid_name.setTextSize(18);
            kid_name.setGravity(Gravity.CENTER_HORIZONTAL);
            kid_name.setCompoundDrawablePadding(4);
            TextView test_name = new TextView(this);
            test_name.setText(kid.getForm().getName());
            test_name.setTextSize(18);
            test_name.setGravity(Gravity.CENTER_HORIZONTAL);
            test_name.setCompoundDrawablePadding(4);
            row.addView(kid_name);
            row.addView(test_name);
            row.setBackground(getDrawable(R.drawable.table_format));
            row.setClickable(true);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            table.addView(row);
        }
    }

    public void showKidResult(Kid kid){
        showKid(getCurrentFocus());

    }


    @Override
    public void onComplete(Object obj) {
        if (obj == null) {
            return;
        }
        Kid[] kids = (Kid[])obj;

        updateTable(kids);
    }
    private class SearchListener implements AwaitableResponse {
        KidsList kidsList;

        SearchListener(KidsList kidsList){
            this.kidsList = kidsList;
        }

        @Override
        public void onComplete(Object obj) {
            if (obj == null) {
                return;
            }
            kidsList.setCurrentKid((Kid)obj);
            kidsList.showKidResult(((Kid)obj) );
        }


    }
}
