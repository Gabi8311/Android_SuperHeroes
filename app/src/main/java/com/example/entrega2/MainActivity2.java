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

    public static class MainActivity extends AppCompatActivity {
        private ConstraintLayout cL_1;
        private TextView tV_user;
        private TextView tV_password;
        private EditText eT_user;
        private EditText eT_password;
        private TextView tV_error;
        private Button btn_enter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            cL_1 = findViewById(R.id.cL_1);
            tV_user = findViewById(R.id.tV_user);
            tV_password = findViewById(R.id.tV_password);
            eT_user = findViewById(R.id.eT_user);
            eT_password = findViewById(R.id.eTp_password);
            tV_error = findViewById(R.id.tV_error);
            btn_enter = findViewById(R.id.btn_enter);

            btn_enter.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View v) {

                    if (!eT_user.getText().toString().equalsIgnoreCase("s")) {///Poner aki Superman
                        eT_user.setText(R.string.usuario_incorrecto);
                        eT_user.setTextColor(Color.parseColor(getString(R.color.color_red)));
                    } else {
                        if (!eT_password.getText().toString().equals("s")) {//Poner aki Krypton
                            tV_error.setText(R.string.password_incorrecto);
                            try {//Por qué no me hace esto???
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Toast toast2 = Toast.makeText(getApplicationContext(), "Contraseña Incorrecta", Toast.LENGTH_SHORT);
                            toast2.show();

                        } else {
                            Toast toast = Toast.makeText(getApplicationContext(), "Bienvenido a nuestra página", Toast.LENGTH_SHORT);
                            toast.show();
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            goToActivity2(v);
                        }
                    }
                }
            });

            //Vacia el campo del User editText
            vaciar_campo(eT_user);

            //Vacia el campo del password editText
            vaciar_campo(eT_password);
            tV_error.setText("");

            //Limpia el foco cuando haces click en el constraint Layout
            cL_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    eT_user.clearFocus();
                    eT_password.clearFocus();
                }
            });
        }

        //Método que permite cambiar de actividad
        public void goToActivity2(View view) {
            Intent secondActivity = new Intent(this, MainActivity2.class);
            startActivity(secondActivity);
        }

        public void vaciar_campo(EditText campo) {
            campo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        campo.getText().clear();
                        campo.setTextColor(Color.parseColor(getString(R.color.color_black)));
                    }
                }
            });
        }
    }
}