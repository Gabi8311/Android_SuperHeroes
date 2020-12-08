package com.example.entrega2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import personajes.Magia;
import personajes.Villano;

public class MainActivity5 extends AppCompatActivity {

    private ImageView iV_rival5;
    private Button btn_batalla;
    private TextView tV_nombre_enemigo5;
    protected static ArrayList<Villano> villanos;
    protected static int azar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        iV_rival5 = findViewById(R.id.iV_rival5);
        btn_batalla = findViewById(R.id.btn_batalla);
        tV_nombre_enemigo5 = findViewById(R.id.tV_nombre_enemigo5);

        villanos = new ArrayList<Villano>();

        Villano v1 = new Villano("Thanos", 200, 300, new ArrayList<Magia>());
        Magia magia_thanos1 = new Magia("Utilizar gemas del Infinito", 100);
        v1.getMagias().add(magia_thanos1);

        Villano v2 = new Villano("Lex Luthor", 50, 500, new ArrayList<Magia>());
        Magia magia_lex1 = new Magia("Cualquier tecnología para dañar", 50);
        v2.getMagias().add(magia_lex1);

        Villano v3 = new Villano("Doomsday", 200, 200, new ArrayList<Magia>());
        Magia magia_doomsday = new Magia("Rayos por los ojos", 40);
        v3.getMagias().add(magia_doomsday);

        villanos.add(v1);
        villanos.add(v2);
        villanos.add(v3);

        switch (azar_villano(villanos).getNombre()) {
            case "Thanos":
                iV_rival5.setImageResource(R.drawable.thanos);
                tV_nombre_enemigo5.setText(villanos.get(0).getNombre());
                break;
            case "Lex Luthor":
                iV_rival5.setImageResource(R.drawable.lex);
                tV_nombre_enemigo5.setText(villanos.get(1).getNombre());
                break;
            case "Doomsday":
                iV_rival5.setImageResource(R.drawable.doomsday);
                tV_nombre_enemigo5.setText(villanos.get(2).getNombre());
                break;
        }

        btn_batalla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast5 = Toast.makeText(getApplicationContext(), "Empieza la Batalla!!", Toast.LENGTH_SHORT);
                toast5.show();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               goToActivity6(v);
            }
        });
    }

    public Villano azar_villano(ArrayList<Villano> villanos) {

        Random r = new Random();
        azar = r.nextInt(3);
        return villanos.get(azar);
    }

    public void goToActivity6(View view) {

        Intent sixthActivity = new Intent(this, MainActivity6.class);
        startActivity(sixthActivity);
    }
}