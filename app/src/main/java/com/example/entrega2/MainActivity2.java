package com.example.entrega2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private ConstraintLayout cL_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cL_2 = findViewById(R.id.cL_2);
        cL_2.setBackgroundResource(R.drawable.marveldc);

    }

    @Override//Menu de Items
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opciones,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.mMostrar:
                Toast toast = Toast.makeText(getApplicationContext(), "Redirigiendo a mostrar Super Héroes", Toast.LENGTH_SHORT);
                toast.show();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent thirdActivity = new Intent(this, MainActivity3.class);
                startActivity(thirdActivity);
                return true;

            case R.id.mJugar:
                Toast toast1 = Toast.makeText(getApplicationContext(), "Redirigiendo a Jugar", Toast.LENGTH_SHORT);
                toast1.show();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent fourthActivity = new Intent(this, MainActivity4.class);
                startActivity(fourthActivity);
                return true;
            case R.id.mSalir:
                Toast toast2 = Toast.makeText(getApplicationContext(), "Saliendo de la App", Toast.LENGTH_SHORT);
                toast2.show();
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