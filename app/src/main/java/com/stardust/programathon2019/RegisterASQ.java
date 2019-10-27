package com.stardust.programathon2019;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.stardust.programathon2019.Model.Result;

import java.util.ArrayList;

public class RegisterASQ extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_asq);

    }

    public ArrayList<Result> getResults(){
        ArrayList<Result> array = new ArrayList<Result>()
        String selectedtext;
        int radioButtonID;
        int lastDigit;
        for(Integer radioGroupSelected : array){
            for(i = 0; i < 6;i++){
                RadioGroup radioGroup = (RadioGroup) findViewById(radioGroupSelected);
                radioButtonID = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(radioButtonID);
                selectedtext = (String) radioButton.getText();
                lastDigit = selectedtext.charAt(selectedtext.length-1);

                array.add(new Result(i,(lastDigit%2)*5); //Saca el numero y dado que el 0 es el que mas vale, se le saca el modulo de 2 para invertir el orden y multiplicarlo *5 para obtener la calificacion
            }




    }


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
}



