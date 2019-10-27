package com.stardust.programathon2019;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.stardust.programathon2019.Controller.AttendanceController;
import com.stardust.programathon2019.Controller.FormController;
import com.stardust.programathon2019.Controller.ResultController;
import com.stardust.programathon2019.Controller.SessionManager;
import com.stardust.programathon2019.Model.AreaResult;
import com.stardust.programathon2019.Model.AreaResultASQ;
import com.stardust.programathon2019.Model.Attendance;
import com.stardust.programathon2019.Model.AttendanceRequest;
import com.stardust.programathon2019.Model.AttendanceResult;
import com.stardust.programathon2019.Model.Awaitable;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Form;
import com.stardust.programathon2019.Model.FullForm;
import com.stardust.programathon2019.Model.Kid;
import com.stardust.programathon2019.Model.Result;
import com.stardust.programathon2019.Model.ResultASQ;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class RegisterASQ extends AppCompatActivity {
    private Button backbtn;
    FullForm form;

    public FullForm getForm() {
        return form;
    }

    public void setForm(FullForm form) {
        this.form = form;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_asq);
        backbtn = findViewById(R.id.register_asq_backbutton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public boolean validarCamposLlenos() {

        ArrayList<ResultASQ> results = new ArrayList<ResultASQ>();
        ArrayList<AreaResult> areas = new ArrayList<AreaResult>();


        String selectedtext;
        int radioButtonID;
        int lastDigit;
        int total = 0;
        for (Integer radioGroupSelected : getIds()) {

            RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupSelected);
            radioButtonID = radioGroup.getCheckedRadioButtonId();
            if (radioButtonID < 0) { // Revisa si alguno no esta seleccionado y explota, devuelve nulo para finalizar el metodo
                return false;
            }
        }
        return true;

    }



    public AttendanceResult getResults(int attendanceId){
        ArrayList<ResultASQ> results = new ArrayList<ResultASQ>();
        ArrayList<AreaResultASQ> areas = new ArrayList<AreaResultASQ>();


        String selectedtext;
        int radioButtonID;
        int lastDigit;
        int total = 0;
        for(Integer radioGroupSelected : getIds()){

                RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupSelected);
                radioButtonID = radioGroup.getCheckedRadioButtonId();
                if(radioButtonID <0){ // Revisa si alguno no esta seleccionado y explota, devuelve nulo para finalizar el metodo
                    return null;
                }
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
                selectedtext = (String) radioButton.getText();
                //System.out.println(selectedtext);

                //System.out.println(radioButton.getId());
                lastDigit = radioButton.getId()%6%3;
                //lastDigit = selectedtext.charAt(selectedtext.length()-1);
                int realValue = (lastDigit%2)*5;

                //add result to list
                results.add(new ResultASQ(realValue, total%6+1));

                if(total%6 == 5){
                    areas.add(new AreaResultASQ(total/6 + 1, results));
                    //System.out.println("------------------------------------");
                    //System.out.println(areas.size());
                    //System.out.println(results.size());
                    //System.out.println("------------------------------------");
                    //refresh list
                    results = new ArrayList<ResultASQ>();
                }



                total++;
    }

    return new AttendanceResult(attendanceId,areas);

    }

    private class tableTest{



    }

    static ArrayList<Integer> getIds(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(R.id.radioGroupcomunicacion0);
        array.add(R.id.radioGroupcomunicacion1);
        array.add(R.id.radioGroupcomunicacion2);
        array.add(R.id.radioGroupcomunicacion3);
        array.add(R.id.radioGroupcomunicacion4);
        array.add(R.id.radioGroupcomunicacion5);

        array.add(R.id.radioMotoraGruesa0);
        array.add(R.id.radioMotoraGruesa1);
        array.add(R.id.radioMotoraGruesa2);
        array.add(R.id.radioMotoraGruesa3);
        array.add(R.id.radioMotoraGruesa4);
        array.add(R.id.radioMotoraGruesa5);

        array.add(R.id.radioMotoraFina0);
        array.add(R.id.radioMotoraFina1);
        array.add(R.id.radioMotoraFina2);
        array.add(R.id.radioMotoraFina3);
        array.add(R.id.radioMotoraFina4);
        array.add(R.id.radioMotoraFina5);

        array.add(R.id.radioResolucionProblemas0);
        array.add(R.id.radioResolucionProblemas1);
        array.add(R.id.radioResolucionProblemas2);
        array.add(R.id.radioResolucionProblemas3);
        array.add(R.id.radioResolucionProblemas4);
        array.add(R.id.radioResolucionProblemas5);

        array.add(R.id.radioSocioIndividual0);
        array.add(R.id.radioSocioIndividual1);
        array.add(R.id.radioSocioIndividual2);
        array.add(R.id.radioSocioIndividual3);
        array.add(R.id.radioSocioIndividual4);
        array.add(R.id.radioSocioIndividual5);

        return array;
    }

    public void guardar(View v){
        if(validarCamposLlenos() == false){
            Toast.makeText(getBaseContext(), "Por favor, llena todos los campos requeridos.", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            System.out.println("Guardando");
            Kid kid = (Kid)SessionManager.getInstance().getSession().retrieve("kid_map");
            Date date = (Date)SessionManager.getInstance().getSession().retrieve("registerDate");
            FormListener formListener = new FormListener(this);
            FormController.getByName(kid.getAsq3Test(date),formListener);
        }

    }

    public void onForm(FullForm f){
        Toast.makeText(getBaseContext(), "Guardado con exito.", Toast.LENGTH_SHORT).show();
        System.out.println(f.getName());
        form = f;
        Date date = (Date)SessionManager.getInstance().getSession().retrieve("registerDate");

        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

//Local time zone
        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String utcDate = date.toString();

        utcDate = dateFormatGmt.format(date);
        System.out.println("This>" + utcDate);





        int formId = f.getId();
        Kid kid = (Kid)SessionManager.getInstance().getSession().retrieve("kid_map");
        int studentId = kid.getId();

        int aplicatorId = SessionManager.getInstance().getSession().getLogin().getUserInfo().getUid();
        String status = "None";

        AttendanceRequest attendanceRequest = new AttendanceRequest(
                utcDate,
                formId,
                studentId,
                aplicatorId,
                status
        );
        AttendanceListener attendanceListener = new AttendanceListener(this);

        AttendanceController.addAttendance(attendanceRequest, attendanceListener);
        System.out.println(utcDate);
    }

    public void onAttendance(Integer id){
        System.out.println(id);
        System.out.println("Attendance generated");

        if(id == null){
            //get latest
            onAttendanceNull();
        }else{
            storeResult(getResults(id));
        }

    }

    public void onAttendanceNull(){
        Kid kid = (Kid)SessionManager.getInstance().getSession().retrieve("kid_map");

        AllAttendanceListener list = new AllAttendanceListener(this);
        AttendanceController.getAttendanceByStudentId(kid.getId(),list);

    }

    public void onAllAttendance(Attendance[] attendances){
        Attendance actual = null;
        for (Attendance att : attendances){
            if(att.getFormId() == form.getId()) actual = att;
        }

        if(actual != null){
            storeResult(getResults(actual.getId()));
        }else{
            System.out.println("Failed to get attendance");
        }
    }

    private void storeResult(AttendanceResult newRes){
        ResultAttendanceListener lis = new ResultAttendanceListener(this);
        ResultController.addResult(newRes,lis);
    }



    private class FormListener implements AwaitableResponse {
        RegisterASQ asqRegister;
        FormListener(RegisterASQ pasqRegister){
            this.asqRegister = pasqRegister;
        }

        @Override
        public void onComplete(Object obj) {
            if (obj == null) {
                return;
            }
            FullForm form = (FullForm)obj;
            asqRegister.onForm(form);

        }
    }

    private class AttendanceListener implements AwaitableResponse {
        RegisterASQ asqRegister;
        AttendanceListener(RegisterASQ pasqRegister){
            this.asqRegister = pasqRegister;
        }


        @Override
        public void onComplete(Object object) {

            asqRegister.onAttendance((Integer)object);
        }
    }

    private class AllAttendanceListener implements AwaitableResponse {
        RegisterASQ asqRegister;
        AllAttendanceListener(RegisterASQ pasqRegister){
            this.asqRegister = pasqRegister;
        }


        @Override
        public void onComplete(Object object) {

            asqRegister.onAllAttendance((Attendance[])object);
        }
    }

    private class ResultAttendanceListener implements AwaitableResponse {
        RegisterASQ asqRegister;
        ResultAttendanceListener(RegisterASQ pasqRegister){
            this.asqRegister = pasqRegister;
        }


        @Override
        public void onComplete(Object object) {

            System.out.println(object);
            System.out.println(object);
            System.out.println(object);
            System.out.println(object);
            System.out.println(object);
            System.out.println(object);
        }
    }
}



