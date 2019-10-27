package com.stardust.programathon2019;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.stardust.programathon2019.Controller.ResultController;
import com.stardust.programathon2019.Controller.Session;
import com.stardust.programathon2019.Controller.SessionManager;
import com.stardust.programathon2019.Model.Area;
import com.stardust.programathon2019.Model.AreaResult;
import com.stardust.programathon2019.Model.Attendance;
import com.stardust.programathon2019.Model.AttendanceResult;
import com.stardust.programathon2019.Model.AwaitableResponse;
import com.stardust.programathon2019.Model.Result;
import com.stardust.programathon2019.Model.ResultASQ;

import java.util.ArrayList;

public class ListaDeResultados extends AppCompatActivity implements AwaitableResponse {
    private ArrayList<ArrayList<TextView>> matrix = new ArrayList<>();

    private Button btnComuni,btnfina, btngrue, btnsol, btnindi;
    private Button btnrestComu, btnRestFina, btnRestgrue, btnRestSol, btnRestInti;
    private Button backButton;
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

        backButton = findViewById(R.id.back_button_results_list);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Attendance a = (Attendance) SessionManager.getInstance().getSession().retrieve("AttendanceID");

        ResultController.GetResultByAttendanceId(a.getId(), this);
    }

    @Override
    public void onComplete(Object obj) {
        if ( obj == null) return;
        ArrayList<Integer> accs = new ArrayList<>();
        AttendanceResult a = (AttendanceResult)obj;
        for (AreaResult areas : a.getResultList()) {
            int acc = 0;
            for (Result res: areas.getResults()) {
                matrix.get(res.getIndex() - 1 ).get(areas.getAreaId() -1).setText(res.getValue() + "");
                acc += res.getValue();
            }
            accs.add(acc);

        }


        btnComuni = findViewById(R.id.lista_resultados_puntaje_0);
        btnComuni.setBackgroundColor(getColorByArea(Area.communication,accs.get(0)));
        btnrestComu = findViewById(R.id.lista_resultados_limite_0);
        btnrestComu.setText("30.72");

        btnfina = findViewById(R.id.lista_resultados_puntaje_1);
        btnfina.setBackgroundColor(getColorByArea(Area.fineMotor,accs.get(1)));
        btnRestFina = findViewById(R.id.lista_resultados_limite_1);
        btnRestFina.setText("32.78");

        btngrue = findViewById(R.id.lista_resultados_puntaje_2);
        btngrue.setBackgroundColor(getColorByArea(Area.grossMotor,accs.get(2)));
        btnRestgrue = findViewById(R.id.lista_resultados_limite_2);
        btnRestgrue.setText("15.81");

        btnsol = findViewById(R.id.lista_resultados_puntaje_3);
        btnsol.setBackgroundColor(getColorByArea(Area.problemSolving,accs.get(3)));
        btnRestSol = findViewById(R.id.lista_resultados_limite_3);
        btnRestSol.setText("31.30");

        btnindi = findViewById(R.id.lista_resultados_puntaje_4);
        btnindi.setBackgroundColor(getColorByArea(Area.personalSocial,accs.get(4)));
        btnRestInti = findViewById(R.id.lista_resultados_limite_4);
        btnRestInti.setText("26.60");
    }

    public int getColorByArea(Area area, int score) {
        if (area == Area.communication) {
            if (score < 30) {
                return Color.RED;
            } else if (score < 40) {
                return Color.YELLOW;
            } else {
                return Color.GREEN;
            }
        } else if (area == Area.grossMotor) {
            if (score < 32) {
                return Color.RED;
            } else if (score < 42) {
                return Color.YELLOW;
            } else {
                return Color.GREEN;
            }
        } else if (area == Area.fineMotor) {
            if (score < 15) {
                return Color.RED;
            } else if (score < 30) {
                return Color.YELLOW;
            } else {
                return Color.GREEN;
            }
        } else if (area == Area.problemSolving) {
            if (score < 30) {
                return Color.RED;
            } else if (score < 40) {
                return Color.YELLOW;
            } else {
                return Color.GREEN;
            }
        } else if (area == Area.personalSocial) {
            if (score < 25) {
                return Color.RED;
            } else if (score < 39) {
                return Color.YELLOW;
            } else {
                return Color.GREEN;
            }
        }
        return 0;
    }
}
