package com.example.entrega2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity4 extends AppCompatActivity {

    private Spinner sp_4;
    private ImageView iV_1;
    private ImageView iV_2;
    private ImageView iV_3;
    private ImageView iV_4;
    private Button btn_empezar4;
    private ArrayList<String> elige_super_heroe;
    protected static ArrayList<String>equipo = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        sp_4 = findViewById(R.id.sp_4);
        iV_1 = findViewById(R.id.iV_1_4);
        iV_2 = findViewById(R.id.iV_2_4);
        iV_3 = findViewById(R.id.iV_3_4);
        iV_4 = findViewById(R.id.iV_4_4);
        btn_empezar4 = findViewById(R.id.btn_empezar4);

        elige_super_heroe = new ArrayList<>(Arrays.asList("Elige Personaje", "Superman", "Batman", "Thor", "Hulk", "Iron-Man", "Aquaman", "Capitan América"));

        ArrayAdapter<String> ad_4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, elige_super_heroe);
        sp_4.setAdapter(ad_4);

        sp_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                switch (sp_4.getSelectedItemPosition()) {

                    case 1:
                        comprobar_casilla_ocupada().setImageResource(R.drawable.superman);
                        equipo.add("Superman");
                        break;

                    case 2:
                        comprobar_casilla_ocupada().setImageResource(R.drawable.batman);
                        equipo.add("Batman");
                        break;

                    case 3:
                        comprobar_casilla_ocupada().setImageResource(R.drawable.thor);
                        equipo.add("Thor");
                        break;

                    case 4:
                        comprobar_casilla_ocupada().setImageResource(R.drawable.hulk);
                        equipo.add("Hulk");
                        break;

                    case 5:
                        comprobar_casilla_ocupada().setImageResource(R.drawable.ironman);
                        equipo.add("Iron-Man");
                        break;

                    case 6:
                        comprobar_casilla_ocupada().setImageResource(R.drawable.aquaman);
                        equipo.add("Aquaman");
                        break;

                    case 7:
                        comprobar_casilla_ocupada().setImageResource(R.drawable.capitan);
                        equipo.add("Capitán América");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn_empezar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast4 = Toast.makeText(getApplicationContext(), "Empieza la Partida", Toast.LENGTH_SHORT);
                toast4.show();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goToActivity5(v);
            }
        });
    }
//Aquí miro si es la imagen de anónimo
    public ImageView comprobar_casilla_ocupada() {

        if (iV_1.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.anonimo).getConstantState())) {
          return iV_1;
        } else if (iV_2.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.anonimo).getConstantState())) {
            return iV_2;
        } else if (iV_3.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.anonimo).getConstantState())) {
            return iV_3;
        } else if (iV_4.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.anonimo).getConstantState())) {
            return iV_4;
        }
        return null;
    }
    //Método que permite cambiar de actividad
    public void goToActivity5(View view) {
        Intent fifthActivity = new Intent(this, MainActivity5.class);
        startActivity(fifthActivity);
    }
}
