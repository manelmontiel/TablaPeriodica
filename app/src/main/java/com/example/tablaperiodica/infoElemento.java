package com.example.tablaperiodica;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class infoElemento extends AppCompatActivity {
    private TextView textViewNombre;
    private TextView textViewSimbolo;
    private TextView textViewPosicion;
    private TextView textViewPeso;
    private TextView textViewTipo;
    private TextView textViewSerie;
    private Button btnWiki;
    private Button btnCompartir;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_elemento);

        Bundle bundle = getIntent().getExtras();
        final String fraseImportada = bundle.getString("url");

        Bundle bundle1 = getIntent().getExtras();
        final String fraseImportada1 = bundle1.getString("nombre");

        Bundle bundle2 = getIntent().getExtras();
        final String fraseImportada2 = bundle2.getString("simbolo");

        Bundle bundle3 = getIntent().getExtras();
        final String fraseImportada3 = bundle3.getString("posicion");

        Bundle bundle4 = getIntent().getExtras();
        final String fraseImportada4 = bundle4.getString("numero");

        Bundle bundle5 = getIntent().getExtras();
        final String fraseImportada5 = bundle5.getString("tipo");

        Bundle bundle6 = getIntent().getExtras();
        final String fraseImportada6 = bundle6.getString("serie");

        textViewNombre = (TextView)findViewById(R.id.textViewNombre);
        textViewNombre.setText(fraseImportada1);

        textViewSimbolo = (TextView)findViewById(R.id.textViewSimbolo);
        textViewSimbolo.setText(fraseImportada2);

        textViewPosicion = (TextView)findViewById(R.id.textViewPosicion);
        textViewPosicion.setText(fraseImportada3);

        textViewPeso = (TextView)findViewById(R.id.textViewPeso);
        textViewPeso.setText(fraseImportada4);

        textViewTipo = (TextView)findViewById(R.id.textViewTipo);
        textViewTipo.setText(fraseImportada5);

        textViewSerie = (TextView)findViewById(R.id.textViewSerie);
        textViewSerie.setText(fraseImportada6);

        btnWiki = findViewById(R.id.buttonWiki);

        btnWiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(fraseImportada));
                startActivity(intent);
            }
        });

        btnCompartir = findViewById(R.id.buttonCompartir);
        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = ""
                        + "Este elemento se llama " + fraseImportada1 + "\n"
                        + "Su símbolo es " + fraseImportada2 + "\n"
                        + "Su posición en la tabla periódica es " + fraseImportada3 + "\n"
                        + "Su peso atómico es " + fraseImportada4 + " u" + "\n"
                        + "Su estado en temperatura ambiente es " + fraseImportada5 + "\n"
                        + "Su serie química es " + fraseImportada6 + "\n" + "\n"
                        + "Para mas informacion consulte la Wikipedia " + "\n" + "\n"
                        + fraseImportada;
                Intent correoIntent = new Intent(Intent.ACTION_SEND);
                correoIntent.setType("text/plain"); //Per indicar el tipus informació que enviarem   	o   	compartirem
                correoIntent.putExtra(Intent.EXTRA_TEXT, mensaje);

                startActivity(correoIntent);
            }
        });

        LinearLayout lnl;
        lnl = findViewById(R.id.linearLayoutInfo);

        if (fraseImportada6.equals("No metales")) {
            lnl.setBackgroundColor(Color.parseColor("#69F0AE"));
        }
        else if (fraseImportada6.equals("Gases nobles")) {
            lnl.setBackgroundColor(Color.parseColor("#c0ffff"));
        }
        else if (fraseImportada6.equals("Metales alcalinos")) {
            lnl.setBackgroundColor(Color.parseColor("#EF5350"));
        }
        else if (fraseImportada6.equals("Metales alcalinotérreos")) {
            lnl.setBackgroundColor(Color.parseColor("#FFE0B2"));
        }
        else if (fraseImportada6.equals("Metaloides")) {
            lnl.setBackgroundColor(Color.parseColor("#D1BB92"));
        }
        else if (fraseImportada6.equals("Halógenos")) {
            lnl.setBackgroundColor(Color.parseColor("#FCEC7B"));
        }
        else if (fraseImportada6.equals("Metales del bloque p")) {
            lnl.setBackgroundColor(Color.parseColor("#B0BEC5"));
        }
        else if (fraseImportada6.equals("Lantánidos")) {
            lnl.setBackgroundColor(Color.parseColor("#FFAAFB"));
        }
        else if (fraseImportada6.equals("Actínidos")) {
            lnl.setBackgroundColor(Color.parseColor("#F06292"));
        }
        else if (fraseImportada6.equals("Metales de transición")) {
            lnl.setBackgroundColor(Color.parseColor("#ffc0c0"));
        }
    }

}
