package com.Miguel.correo;

import android.app.Presentation;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageCapture;


public class MainActivity extends AppCompatActivity {


    Button google, alarma, llamada, aactivity2, caamara;
    ImageView visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.ir_google);
        alarma = findViewById(R.id.go_alarma);
        llamada = findViewById(R.id.go_llamada);
        aactivity2 = findViewById(R.id.activity2);
        caamara = findViewById(R.id.foto);

        caamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camara();
            }
        });

        aactivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent enviar_datos = new Intent(MainActivity.this, Activity2.class);

                startActivity(enviar_datos);

            }
        });

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

        caamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camara();

            }
        });


    }

    private void camara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent, 1);

            //para que funcione se agregaron estos permisos en el manifest
            //<uses-feature android:name="android.hardware.camera"
            //android:required="true">
            //</uses-feature>
        }
    }

    protected void onActivityResult(int requestCode, int resulCode, Intent data){
        super.onActivityResult(requestCode, requestCode, data);
        if(requestCode == 1 && resulCode == RESULT_OK){
            Bundle extras = data.getExtras();

            Bitmap imgBitmap = (Bitmap) extras.get("data");
            visor.setImageBitmap(imgBitmap);
        }
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