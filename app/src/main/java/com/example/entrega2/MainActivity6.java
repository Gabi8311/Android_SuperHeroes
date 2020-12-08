package com.example.entrega2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import personajes.Batalla;
import personajes.SuperHeroe;

import static com.example.entrega2.MainActivity4.equipo;
import static com.example.entrega2.MainActivity5.azar;
import static com.example.entrega2.MainActivity5.villanos;

public class MainActivity6 extends AppCompatActivity {

    private ArrayList<SuperHeroe>super_heroes;
    private ArrayList<SuperHeroe>equipo_super_heroes;
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
        equipo_super_heroes = new ArrayList<>();

        SuperHeroe sH1 = new SuperHeroe("Superman",150,300);
        SuperHeroe sH2 = new SuperHeroe("Batman",50,100);
        SuperHeroe sH3 = new SuperHeroe("Thor",120,300);
        SuperHeroe sH4 = new SuperHeroe("Hulk",180,250);
        SuperHeroe sH5 = new SuperHeroe("Iron-Man",50,150);
        SuperHeroe sH6 = new SuperHeroe("Aquaman",50,150);
        SuperHeroe sH7 = new SuperHeroe("Capitán América",50,150);

        super_heroes.add(sH1);
        super_heroes.add(sH2);
        super_heroes.add(sH3);
        super_heroes.add(sH4);
        super_heroes.add(sH5);
        super_heroes.add(sH6);
        super_heroes.add(sH7);

        rellenar_iVs(iV_1_6,equipo.get(0));
        rellenar_iVs(iV_2_6,equipo.get(1));
        rellenar_iVs(iV_3_6,equipo.get(2));
        rellenar_iVs(iV_4_6,equipo.get(3));

        rellenar_iV_villano(iV_rival6,villanos.get(azar).getNombre());

       for (SuperHeroe i:super_heroes){
           if(equipo.contains(i.getNombre())){
               equipo_super_heroes.add(i);
           }
        }

        Batalla guerra = new Batalla(villanos.get(azar),tV_comentarios6,equipo_super_heroes);

        guerra.pelea();

        ////////////////////////////////////////////////////
      /*  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

// Configura el titulo.
        alertDialogBuilder.setTitle("GAME OVER");

// Configura el mensaje.
        alertDialogBuilder
                .setMessage("Quieres volver a jugar?")
                .setCancelable(false)
                .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Intent myIntent = new Intent(MainActivity6.this, MainActivity4.class);
                        startActivity(myIntent);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent myIntent = new Intent(MainActivity6.this, MainActivity.class);
                        startActivity(myIntent);
                        dialog.cancel();
                    }
                }).create().show();*/
        ///////////////////////////////////////////////////

    }
    public void rellenar_iVs(ImageView iV,String heroe){

           switch (heroe){
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

    public void rellenar_iV_villano(ImageView iV,String villano){
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
    //Método que permite cambiar de actividad
    public void goToActivity(View view) {
        Intent firstActivity = new Intent(this, MainActivity.class);
        startActivity(firstActivity);
    }
    //Método que permite cambiar de actividad
    public void goToActivity4(View view) {
        Intent fourthActivity = new Intent(this, MainActivity4.class);
        startActivity(fourthActivity);
    }
}