package com.stardust.programathon2019;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaDeResultados extends AppCompatActivity {
    private ArrayList<ArrayList<TextView>> matrix = new ArrayList<>();

    private Button btnComuni,btnfina, btngrue, btnsol, btnindi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_list2);
        matrix.add(new ArrayList<TextView>());
        matrix.get(0).add((TextView) findViewById(R.id.lista_resultados_0_0));
        matrix.get(0).add((TextView) findViewById(R.id.lista_resultados_0_1));
        matrix.get(0).add((TextView) findViewById(R.id.lista_resultados_0_2));
        matrix.get(0).add((TextView) findViewById(R.id.lista_resultados_0_3));
        matrix.get(0).add((TextView) findViewById(R.id.lista_resultados_0_4));
        matrix.add(new ArrayList<TextView>());
        matrix.get(1).add((TextView) findViewById(R.id.lista_resultados_1_0));
        matrix.get(1).add((TextView) findViewById(R.id.lista_resultados_1_1));
        matrix.get(1).add((TextView) findViewById(R.id.lista_resultados_1_2));
        matrix.get(1).add((TextView) findViewById(R.id.lista_resultados_1_3));
        matrix.get(1).add((TextView) findViewById(R.id.lista_resultados_1_4));
        matrix.add(new ArrayList<TextView>());
        matrix.get(2).add((TextView) findViewById(R.id.lista_resultados_2_0));
        matrix.get(2).add((TextView) findViewById(R.id.lista_resultados_2_1));
        matrix.get(2).add((TextView) findViewById(R.id.lista_resultados_2_2));
        matrix.get(2).add((TextView) findViewById(R.id.lista_resultados_2_3));
        matrix.get(2).add((TextView) findViewById(R.id.lista_resultados_2_4));
        matrix.add(new ArrayList<TextView>());
        matrix.get(3).add((TextView) findViewById(R.id.lista_resultados_3_0));
        matrix.get(3).add((TextView) findViewById(R.id.lista_resultados_3_1));
        matrix.get(3).add((TextView) findViewById(R.id.lista_resultados_3_2));
        matrix.get(3).add((TextView) findViewById(R.id.lista_resultados_3_3));
        matrix.get(3).add((TextView) findViewById(R.id.lista_resultados_3_4));
        matrix.add(new ArrayList<TextView>());
        matrix.get(4).add((TextView) findViewById(R.id.lista_resultados_4_0));
        matrix.get(4).add((TextView) findViewById(R.id.lista_resultados_4_1));
        matrix.get(4).add((TextView) findViewById(R.id.lista_resultados_4_2));
        matrix.get(4).add((TextView) findViewById(R.id.lista_resultados_4_3));
        matrix.get(4).add((TextView) findViewById(R.id.lista_resultados_4_4));
        matrix.add(new ArrayList<TextView>());
        matrix.get(5).add((TextView) findViewById(R.id.lista_resultados_5_0));
        matrix.get(5).add((TextView) findViewById(R.id.lista_resultados_5_1));
        matrix.get(5).add((TextView) findViewById(R.id.lista_resultados_5_2));
        matrix.get(5).add((TextView) findViewById(R.id.lista_resultados_5_3));
        matrix.get(5).add((TextView) findViewById(R.id.lista_resultados_5_4));
    }
}
