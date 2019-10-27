package com.stardust.programathon2019;

import android.content.Context;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.stardust.programathon2019.Controller.AttendanceController;
import com.stardust.programathon2019.Controller.ResultController;
import com.stardust.programathon2019.Controller.StudentController;
import com.stardust.programathon2019.Model.Attendance;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Controller.SessionManager;
import com.stardust.programathon2019.Model.Result;
import com.stardust.programathon2019.Model.ResultASQ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Debug;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Map;

public class KidsList extends AppCompatActivity implements AwaitableResponse {
    private KidsList instance = this;
    private TableLayout table;
    private ImageButton back_button;
    private Button consult_button;
    private Context ctx;
    private ImageButton backButton;
    private Kid currentKid;
    private Attendance attendance;
    private static final Pattern ID_PATTERN = Pattern.compile("^[0-9]{1,10}$");

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    private Date date = new Date();

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
        back_button = findViewById(R.id.back_button);
        dialog = new Dialog(this);

        ctx = getBaseContext();
        List<ResultASQ> results = new ArrayList<>();

        int attendanceId = 4;

        results.add(new ResultASQ(0,attendanceId,5,5,0));
        results.add(new ResultASQ(0,attendanceId,5,5,2));
        results.add(new ResultASQ(0,attendanceId,5,5,3));
        results.add(new ResultASQ(0,attendanceId,5,5,4));
        results.add(new ResultASQ(0,attendanceId,5,5,5));
        results.add(new ResultASQ(0,attendanceId,5,5,6));

        results.add(new ResultASQ(0,attendanceId,5,4,0));
        results.add(new ResultASQ(0,attendanceId,5,4,2));
        results.add(new ResultASQ(0,attendanceId,5,4,3));
        results.add(new ResultASQ(0,attendanceId,5,4,4));
        results.add(new ResultASQ(0,attendanceId,5,4,5));
        results.add(new ResultASQ(0,attendanceId,5,4,6));

        results.add(new ResultASQ(0,attendanceId,5,3,0));
        results.add(new ResultASQ(0,attendanceId,5,3,2));
        results.add(new ResultASQ(0,attendanceId,5,3,3));
        results.add(new ResultASQ(0,attendanceId,5,3,4));
        results.add(new ResultASQ(0,attendanceId,5,3,5));
        results.add(new ResultASQ(0,attendanceId,5,3,6));

        results.add(new ResultASQ(0,attendanceId,5,2,0));
        results.add(new ResultASQ(0,attendanceId,5,2,2));
        results.add(new ResultASQ(0,attendanceId,5,2,3));
        results.add(new ResultASQ(0,attendanceId,5,2,4));
        results.add(new ResultASQ(0,attendanceId,5,2,5));
        results.add(new ResultASQ(0,attendanceId,5,2,6));

        results.add(new ResultASQ(0,attendanceId,5,1,0));
        results.add(new ResultASQ(0,attendanceId,5,1,2));
        results.add(new ResultASQ(0,attendanceId,5,1,3));
        results.add(new ResultASQ(0,attendanceId,5,1,4));
        results.add(new ResultASQ(0,attendanceId,5,1,5));
        results.add(new ResultASQ(0,attendanceId,5,1,6));

        ResultController.updateResult(results);


    }

    @Override
    public void onBackPressed() {
        showPopUp(this.getCurrentFocus());
    }

    private boolean validateID(TextInputLayout entry) {
        String dni = entry.getEditText().getText().toString().trim();

        if (dni.isEmpty()) {
            entry.setError("El campo no puede estar vacío");
            return false;
        } else if (!ID_PATTERN.matcher(dni).matches()) {
            entry.setError("Debe ser una cédula valida");
            return false;
        } else {
            entry.setError(null);
            return true;
        }
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
        final Button eText = dialog.findViewById(R.id.query_by_name_date_text);

        final Context ctx = v.getContext();

        final KidsList act = this;
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog


                DatePickerDialog picker = new DatePickerDialog(ctx,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                                eText.setText(date.toString());
                                cldr.set(year, monthOfYear, dayOfMonth);
                                date = cldr.getTime();
                                act.hideKeyboardFrom(view);
                            }
                        }, year, month, day);

                picker.show();
            }
        });
        eText.setText(date.toString());
        final SearchListener searchListener = new SearchListener(this);
        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateID(studentName)) {
                    dialog.dismiss();
                    StudentController.getStudentByDNI(Integer.parseInt(studentName.getEditText().getText().toString()),searchListener );
                }


            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void showKid(View v) {
        dialog.setContentView(R.layout.query_by_kid_info);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView dni = dialog.findViewById(R.id.query_by_name_dni_info);
        TextView dateText = dialog.findViewById(R.id.query_by_name_date_info);
        dateText.setText(date.toString());
        TextView asq = dialog.findViewById(R.id.query_by_name_asq3_info);
        asq.setText(currentKid.getAsq3Test(date));
        dni.setText(currentKid.getFirstName() + " " + currentKid.getLastName());
        Button btnAccept = dialog.findViewById(R.id.query_by_name_accept_button);
        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
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
                            SessionManager.getInstance().getSession().store("kid_map", kid);
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

    public void showKidResult(Kid kid){
        showKidResultDialog();
        /*AttendanceListener attendanceListener = new AttendanceListener(this);
        AttendanceController.getAttendanceByStudentId(kid.getDni(), attendanceListener);*/
    }

    public void showKidResultDialog(){
        showKid(getCurrentFocus());
    }


    @Override
    public void onComplete(Object obj) {
        Kid[] kids = (Kid[]) obj;
        if (kids == null ||  kids.length==0) {
            System.out.println("No kids");
            Toast.makeText(ctx, "No se encontraron niños asociados a este usuario", Toast.LENGTH_SHORT).show();
            return;
        }

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

    private class AttendanceListener implements  AwaitableResponse {
        KidsList kidsList;
        AttendanceListener(KidsList kidsList){
            this.kidsList = kidsList;
        }

        @Override
        public void onComplete(Object obj) {
            if (obj == null) {
                return;
            }
            Attendance[] attendances = (Attendance[])obj;
            if(attendances.length > 0) {
                kidsList.setAttendance(attendances[0]);
                kidsList.showKidResultDialog();
            }
        }


    }
}
