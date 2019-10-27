package com.stardust.programathon2019;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.stardust.programathon2019.Controller.Session;
import com.stardust.programathon2019.Controller.SessionManager;
import com.stardust.programathon2019.Model.Kid;

import java.util.Calendar;
import java.util.Date;

public class KidDataShell extends AppCompatActivity {
    TextView name, dni, class_text, test, status, birthday;
    Button btnregister, btnload;
    private Dialog dialog;
<<<<<<< HEAD
    public Button registerButtn;
    private Date date= new Date();
=======
    private KidDataShell kidDataShell;
>>>>>>> 9950558565d02af2a2221c73fc634b4f43243efd

    @Override
    public void onResume() {
        super.onResume();
        SessionManager.getInstance().getSession().store("registerDate", new Date());
        //StudentController.getMyStudents(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        kidDataShell = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_data_shell);

        getIntent().getSerializableExtra("kid_selected");
        Kid kid = (Kid) SessionManager.getInstance().getSession().retrieve("kid_map" );

        name = findViewById(R.id.shell_name);
        name.setText(kid.getFirstName() + " " + kid.getLastName());
        dni = findViewById(R.id.shell_dni);
        String dni_text = String.valueOf(kid.getDni());
        class_text = findViewById(R.id.shell_class);
        class_text.setText("Año clase: " + (int) kid.getClassRoom().getClassYear());
        dni.setText("Cédula: " + dni_text);
        test = findViewById(R.id.shell_test);
        test.setText("Prueba: " +kid.getForm().getName());
        status = findViewById(R.id.shell_status);
        status.setText("Estado: " + kid.getStatus());
        birthday = findViewById(R.id.shell_birthday);
        birthday.setText("Fecha de Nacimiento: " + (kid.getDob().split("T"))[0]);
        dialog = new Dialog(this);
<<<<<<< HEAD
        final KidDataShell act = this;
        registerButtn = findViewById(R.id.register_button_kid_shell);
        registerButtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showPopUP();
            }
        });

    }

    private void showPopUP() {
        dialog.setContentView(R.layout.pop_up_register_asq);
        final Button dater = dialog.findViewById(R.id.register_date_selector);
        dater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                final Context ctx = v.getContext();


                DatePickerDialog picker = new DatePickerDialog(ctx,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

                                cldr.set(year, monthOfYear, dayOfMonth);
                                date = cldr.getTime();
                                //act.hideKeyboardFrom(view);
                                dater.setText(date.toString());
                                SessionManager.getInstance().getSession().store("registerDate", date);
                            }
                        }, year, month, day);

                picker.show();
            }
        });
        dater.setText(date.toString());

        Button continuar = dialog.findViewById(R.id.register_continue_button);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(getApplicationContext(), RegisterASQ.class);
                startActivity(log);
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
=======

        btnload = findViewById(R.id.load_tests_button_kids_shell);
        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(kidDataShell, questionaire_table.class);
                SessionManager.getInstance().getSession().store("ctx", getApplicationContext());
                startActivity(log);
            }
        });
>>>>>>> 9950558565d02af2a2221c73fc634b4f43243efd
    }

    public void goBack(View view) {
        finish();
    }

}
