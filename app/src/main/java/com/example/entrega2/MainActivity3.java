package com.example.entrega2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity3 extends AppCompatActivity {

    private TextView tV_3;
    private Spinner sp_3;
    private ImageView iV_3;
    private ArrayList<String> nombres_personajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tV_3 = findViewById(R.id.tV_3);
        sp_3 = findViewById(R.id.sp_3);
        iV_3 = findViewById(R.id.iV_3);

        nombres_personajes = new ArrayList<>(Arrays.asList("Elige Personaje","Superman", "Batman", "Thor", "Hulk", "Thanos", "Lex Luthor", "Iron-Man", "Aquaman", "Capitan América", "Doomsday"));

        ArrayAdapter<String> ad_3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nombres_personajes);
        sp_3.setAdapter(ad_3);

        sp_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                switch (sp_3.getSelectedItemPosition()) {
                    case 0:
                        iV_3.setImageResource(R.drawable.marveldc);
                        break;
                    case 1:
                        iV_3.setImageResource(R.drawable.superman);
                        break;
                    case 2:
                        iV_3.setImageResource(R.drawable.batman);
                        break;
                    case 3:
                        iV_3.setImageResource(R.drawable.thor);
                        break;
                    case 4:
                        iV_3.setImageResource(R.drawable.hulk);
                        break;
                    case 5:
                        iV_3.setImageResource(R.drawable.thanos);
                        break;
                    case 6:
                        iV_3.setImageResource(R.drawable.lex);
                        break;
                    case 7:
                        iV_3.setImageResource(R.drawable.ironman);
                        break;
                    case 8:
                        iV_3.setImageResource(R.drawable.aquaman);
                        break;
                    case 9:
                        iV_3.setImageResource(R.drawable.capitan);
                        break;
                    case 10:
                        iV_3.setImageResource(R.drawable.doomsday);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override//Menu de Items
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opciones2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mJugar2:
                Toast toast4 = Toast.makeText(getApplicationContext(), "Redirigiendo a Jugar", Toast.LENGTH_SHORT);
                toast4.show();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent fourthActivity = new Intent(this, MainActivity4.class);
                startActivity(fourthActivity);
                return true;
            case R.id.mSalir2:
                Toast toast5 = Toast.makeText(getApplicationContext(), "Saliendo de la App", Toast.LENGTH_SHORT);
                toast5.show();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent firstActivity = new Intent(this, MainActivity.class);
                startActivity(firstActivity);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
