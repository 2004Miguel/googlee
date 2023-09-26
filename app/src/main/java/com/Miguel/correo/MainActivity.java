package com.Miguel.correo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button google, alarma, llamada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.ir_google);
        alarma = findViewById(R.id.go_alarma);
        llamada = findViewById(R.id.go_llamada);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent irAGoogle=new Intent(Intent.ACTION_VIEW);
                irAGoogle.setData(Uri.parse("https://www.google.com"));
                startActivity(irAGoogle);

            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                crearAlarma();

//                para que funcione esto, hubo que agregar estas líneas en el manifest:
//                este va antes de la etiqueta de aplication
//                <uses-permission android:name="com.android.alarm.permission.SET_ALARM" />

//
//                 esta va en la etiqueta de intent-filter
//                <action android:name="android.intent.action.SET_ALARM" />
//                 <category android:name="android.intent.category.DEFAULT" />


            }
        });

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                llamada();
            }
        });


    }

    private void crearAlarma() {

        Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
        alarma.putExtra(AlarmClock.EXTRA_MESSAGE, "gimnasio ");
        alarma.putExtra(AlarmClock.EXTRA_HOUR, 10);
        alarma.putExtra(AlarmClock.EXTRA_MINUTES, 30);
        if(alarma.resolveActivity(getPackageManager())!=null) {

            startActivity(alarma);
        }
    }

    public void llamada() {
        Intent llamada = new Intent(Intent.ACTION_DIAL);
        llamada.setData(Uri.parse("tel:" + "3148719748"));
        if (llamada.resolveActivity(getPackageManager()) != null) {
            startActivity(llamada);
        }
    }
}