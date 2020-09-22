package com.example.tablaperiodica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.tablaperiodica.listViewElementos.elements;

public class juego extends AppCompatActivity {

    private TextView textViewEnunciado;
    private TextView textViewNombre;
    private EditText editTextSimbolo;
    private int aciertosNum;
    public TextView aciertos;
    private TextView aciertosMax;
    private Random byRandom = new Random();
    private Button buttonComprobar;
    private cElemento elemento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        final Intent intentList = new Intent(this, listViewElementos.class);

        textViewEnunciado = (TextView)findViewById(R.id.textViewEnunciado);
        textViewNombre = (TextView)findViewById(R.id.textViewNombre);
        editTextSimbolo = (EditText) findViewById(R.id.editTextSimbolo);
        buttonComprobar = (Button) findViewById(R.id.btnComprobar);
        aciertos = (TextView) findViewById(R.id.textViewPunt);
        aciertosMax = (TextView) findViewById(R.id.textViewPuntMax);

        randomPregunta();
        aciertosMax.setText(String.valueOf(listViewElementos.aciertosMaxNum));

        buttonComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String simbolo = elemento.getSimbolo().toLowerCase();
                String escrito = editTextSimbolo.getText().toString().toLowerCase();
                if (escrito.equals(simbolo)) {
                    aciertosNum++;
                    aciertos.setText(String.valueOf(aciertosNum));
                    randomPregunta();
                    editTextSimbolo.setText("");
                    Toast.makeText(getApplicationContext(), "Correcto!!", Toast.LENGTH_SHORT).show();
                    if(aciertosNum > listViewElementos.aciertosMaxNum){
                        listViewElementos.aciertosMaxNum = aciertosNum;
                        aciertosMax.setText(String.valueOf(listViewElementos.aciertosMaxNum));
                    }

                }else{
                    Toast.makeText(juego.this, "Tu respuesta es incorrecta. Mirate la información y vuelve más tarde.", Toast.LENGTH_LONG).show();
                    startActivity(intentList);
                }
            }
        });


        }


    public void randomPregunta(){
        int random = byRandom.nextInt(elements.size());

        elemento = elements.get(random);

        //for(int i = 0; i < elements.size(); i++){
                textViewNombre.setText(elemento.getNombre());
           // }

    }

    public int getAciertosNum() {
        return aciertosNum;
    }

    public void setAciertosNum(int aciertosNum) {
        this.aciertosNum = aciertosNum;
    }


}
