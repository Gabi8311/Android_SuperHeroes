package com.example.entrega2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import personajes.SuperHeroe;
import personajes.Villano;

import static com.example.entrega2.MainActivity4.equipo;
import static com.example.entrega2.MainActivity5.azar;
import static com.example.entrega2.MainActivity5.villanos;

public class MainActivity6 extends AppCompatActivity implements Runnable {

    private Villano enemigo;
    private ArrayList<SuperHeroe> super_heroes;
    private ArrayList<SuperHeroe> my_equipo;
    private ImageView iV_1_6;
    private ImageView iV_2_6;
    private ImageView iV_3_6;
    private ImageView iV_4_6;
    private ImageView iV_rival6;
    private TextView tV_comentarios6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        iV_1_6 = findViewById(R.id.iV_1_6);
        iV_2_6 = findViewById(R.id.iV_2_6);
        iV_3_6 = findViewById(R.id.iV_3_6);
        iV_4_6 = findViewById(R.id.iV_4_6);
        iV_rival6 = findViewById(R.id.iV_rival6);
        tV_comentarios6 = findViewById(R.id.tV_comentarios6);
        tV_comentarios6.setMovementMethod(new ScrollingMovementMethod());

        super_heroes = new ArrayList<>();
        my_equipo = new ArrayList<>();

        SuperHeroe sH1 = new SuperHeroe("Superman", 150, 300);
        SuperHeroe sH2 = new SuperHeroe("Batman", 50, 100);
        SuperHeroe sH3 = new SuperHeroe("Thor", 120, 300);
        SuperHeroe sH4 = new SuperHeroe("Hulk", 180, 250);
        SuperHeroe sH5 = new SuperHeroe("Iron-Man", 50, 150);
        SuperHeroe sH6 = new SuperHeroe("Aquaman", 50, 150);
        SuperHeroe sH7 = new SuperHeroe("Capitán América", 50, 150);

        super_heroes.add(sH1);
        super_heroes.add(sH2);
        super_heroes.add(sH3);
        super_heroes.add(sH4);
        super_heroes.add(sH5);
        super_heroes.add(sH6);
        super_heroes.add(sH7);

        rellenar_iV_villano(iV_rival6, villanos.get(azar).getNombre());

        for (SuperHeroe i : super_heroes) {
            if (equipo.contains(i.getNombre())) {
                my_equipo.add(i);
            }
        }

        rellenar_iVs(iV_1_6, my_equipo.get(0).getNombre());
        rellenar_iVs(iV_2_6, my_equipo.get(1).getNombre());
        rellenar_iVs(iV_3_6, my_equipo.get(2).getNombre());
        rellenar_iVs(iV_4_6, my_equipo.get(3).getNombre());

        enemigo = villanos.get(azar);
        batalla();

    }

    public void rellenar_iVs(ImageView iV, String heroe) {

        switch (heroe) {
            case "Superman":
                iV.setImageResource(R.drawable.superman);
                break;
            case "Batman":
                iV.setImageResource(R.drawable.batman);
                break;
            case "Thor":
                iV.setImageResource(R.drawable.thor);
                break;
            case "Hulk":
                iV.setImageResource(R.drawable.hulk);
                break;
            case "Iron-Man":
                iV.setImageResource(R.drawable.ironman);
                break;
            case "Aquaman":
                iV.setImageResource(R.drawable.aquaman);
                break;
            case "Capitán América":
                iV.setImageResource(R.drawable.capitan);
                break;
        }
    }

    public void rellenar_iV_villano(ImageView iV, String villano) {

        switch (villano) {
            case "Thanos":
                iV.setImageResource(R.drawable.thanos);
                break;
            case "Lex Luthor":
                iV.setImageResource(R.drawable.lex);
                break;
            case "Doomsday":
                iV.setImageResource(R.drawable.doomsday);
                break;
        }
    }

    public void lanzar_alertD() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

// Configura el titulo.
        alertDialogBuilder.setTitle("GAME OVER");

// Configura el mensaje.
        alertDialogBuilder
                .setMessage("Quieres volver a jugar?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent myIntent = new Intent(MainActivity6.this, MainActivity4.class);//
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent myIntent = new Intent(MainActivity6.this, MainActivity.class);
                        startActivity(myIntent);
                        dialog.cancel();
                    }
                }).create().show();
    }

    public void run() {
        Random r = new Random();

        Integer personaje;

        Integer azar;

        Integer daño;

        tV_comentarios6.append("\nEmpieza la batalla!!");
        tV_comentarios6.append("\n********************");

        tiempo(2);

        do {

            personaje = r.nextInt(my_equipo.size());

            tV_comentarios6.append("\n" + my_equipo.get(personaje) + " VS " + enemigo.getNombre());

            daño = my_equipo.get(personaje).atacar(tV_comentarios6);

            enemigo.setVida(enemigo.getVida() - daño);

            tiempo(2);

            tV_comentarios6.append("\nSu ataque provoca un daño de " + daño);

            tiempo(1);

            if (enemigo.getVida() < 0) {

                enemigo.setVida(0);
            }

            tV_comentarios6.append("\nVida de " + enemigo.getNombre() + ":" + enemigo.getVida());

            tiempo(2);

            tV_comentarios6.append("\n");

            if (enemigo.getVida() <= 0) {

                break;

            } else {
                azar = r.nextInt(my_equipo.size());

                tV_comentarios6.append("\n" + enemigo + " VS " + my_equipo.get(azar).getNombre());

                daño = enemigo.atacar(tV_comentarios6);

                my_equipo.get(azar).setVida(my_equipo.get(azar).getVida() - daño);

                tiempo(2);

                if (my_equipo.get(azar).getVida() < 0) {
                    my_equipo.get(azar).setVida(0);
                }
                tV_comentarios6.append("\nVida de " + my_equipo.get(azar).getNombre() + ":" + my_equipo.get(azar).getVida());

                tV_comentarios6.append("\n");
                tiempo(1);
                if (my_equipo.get(azar).getVida() <= 0) {

                    tV_comentarios6.append("\n" + my_equipo.get(azar).getNombre() + " ha muerto!!");
                    tV_comentarios6.append("\n");
                    my_equipo.remove(my_equipo.get(azar));
                }
            }
        } while (enemigo.getVida() > 0 && my_equipo.size() > 0);

        if (my_equipo.size() == 0) {
            tV_comentarios6.append("\n" + enemigo.getNombre() + " ha ganado la batalla!!");
            tiempo(4);
            thread.start();
        } else {
            tV_comentarios6.append("\nLos Vengadores & Liga de la Justicia, han ganado la batalla!!");
            tiempo(4);
            thread.start();
        }
    }

    public void batalla() {

        Thread hilo2 = new Thread(this);
        hilo2.start();

    }

    public static void tiempo(int segundos) {

        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception Error) {

        }
    }
//Que lance el alert Dialog justo cuando termine la batalla
    Thread thread = new Thread() {
        public void run() {
            runOnUiThread(new Runnable() {
                public void run() {
                    lanzar_alertD();
                }
            });
        }
    };
}