package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText inpName = findViewById(R.id.inpNom);

        TextInputEditText inpCognom = findViewById(R.id.inpCognom);


        TextInputEditText inpTelefon = findViewById(R.id.inpTelefon);

        TextInputEditText inpEmail = findViewById(R.id.inpEmail);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CharSequence text = "";
                int duration = Toast.LENGTH_SHORT;

                String nom= inpName.getText().toString();
                String cognom = inpCognom.getText().toString();
                String telefon = inpTelefon.getText().toString();
                String email = inpEmail.getText().toString();

                Log.d("NOM", nom);
                Log.d("COGNOM", cognom);
                Log.d("TEL", telefon);
                Log.d("EMAIL", email);


                try {
                    if (nom.length() == 0){
                        text = "EL CAMP NOM ESTA VUIT";
                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();
                    }
                    if (cognom.length() == 0){
                        text = "EL CAMP COGNOM ESTA VUIT";
                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();
                    }
                    if (telefon.length() == 0){
                        text = "EL CAMP TELÈFON ESTA VUIT";
                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();
                    }
                    if (email.length() == 0){
                        text = "EL CAMP EMAIL ESTA VUIT";
                        Toast toast = Toast.makeText(MainActivity.this, text, duration);
                        toast.show();
                    }
                    else if (nom.length() != 0 && cognom.length() != 0 && telefon.length() != 0 && email.length() != 0){
                        // Crea un objecte FileOutputStream
                        FileOutputStream fos = openFileOutput("contactes.txt", Context.MODE_APPEND);

                        // Escriu els valors dels TextInput en l'arxiu
                        fos.write(( nom + ";" + cognom + ";" + telefon + ";" + email).getBytes());

                        // Tanca l'arxiu
                        fos.close();

                        Toast toast = Toast.makeText(MainActivity.this, "SAVED", duration);
                        toast.show();
                    }


                }catch (Exception e ){
                    throw new RuntimeException(e);
                }
            }
        });
    }
}