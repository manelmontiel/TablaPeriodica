package com.example.tablaperiodica;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import com.example.tablaperiodica.R;
import com.example.tablaperiodica.cElemento;

import java.util.ArrayList;
import java.util.List;

public class listViewElementos extends AppCompatActivity {

    public static ArrayList<cElemento> elements = new ArrayList<cElemento>();
    public static int aciertosMaxNum;
    private ArrayList<cElemento> elementsFiltrat = new ArrayList<cElemento>();

    private ArrayAdapter<String> adaptador;
    private ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list_elementos);

        elements.clear();

        elements.add(new cElemento("Hidrógeno", "H", "1", "1.00784", "Gas", "No metales" ,"https://es.wikipedia.org/wiki/Hidr%C3%B3geno"));
        elements.add(new cElemento("Helio", "He", "2", "4.002602", "Gas", "Gases nobles","https://es.wikipedia.org/wiki/Helio"));
        elements.add(new cElemento("Litio", "Li", "3", "6.94174064", "Sólido", "Metales alcalinos","https://es.wikipedia.org/wiki/Litio"));
        elements.add(new cElemento("Berilio", "Be", "4", "9.0122", "Sólido", "Metales alcalinotérreos","https://es.wikipedia.org/wiki/Berilio"));
        elements.add(new cElemento("Boro", "B", "5", "10.811", "Sólido", "Metaloides","https://es.wikipedia.org/wiki/boro"));
        elements.add(new cElemento("Carbono", "C", "6", "12.0111", "Sólido", "No metales","https://es.wikipedia.org/wiki/carbono"));
        elements.add(new cElemento("Nitrogeno", "N", "7", "14.007", "Gas", "No metales","https://es.wikipedia.org/wiki/nitrogeno"));
        elements.add(new cElemento("Oxigeno", "O", "8", "15.9994", "Gas", "No metales","https://es.wikipedia.org/wiki/Ox%C3%ADgeno"));
        elements.add(new cElemento("Flúor", "F", "9", "18.9984032", "Sólido", "Halógenos","https://es.wikipedia.org/wiki/Fl%C3%BAor"));
        elements.add(new cElemento("Neón", "Ne", "10", "20.1797", "Gas", "Gases nobles","https://es.wikipedia.org/wiki/Ne%C3%B3n"));
        elements.add(new cElemento("Sodio", "Na", "11", "22.98976928", "Sólido", "Metales alcalinos","https://es.wikipedia.org/wiki/Sodio"));
        elements.add(new cElemento("Magnesio", "Mg", "12", "24.312", "Sólido", "Metales alcalinotérreos","https://es.wikipedia.org/wiki/Magnesio"));
        elements.add(new cElemento("Aluminio", "Al", "13", "26.9815386", "Sólido", "Metales del bloque p","https://es.wikipedia.org/wiki/Aluminio"));
        elements.add(new cElemento("Silicio", "Si", "14", "28.085", "Sólido", "Metaloides","https://es.wikipedia.org/wiki/Silicio"));
        elements.add(new cElemento("Fósforo", "P", "15", "30.9737620", "Sólido", "No metales","https://es.wikipedia.org/wiki/F%C3%B3sforo"));
        elements.add(new cElemento("Azufre", "S", "16", "32.065", "Sólido", "No metales","https://es.wikipedia.org/wiki/Azufre"));
        elements.add(new cElemento("Cloro", "Cl", "17", "35.453", "Sólido", "Halógenos","https://es.wikipedia.org/wiki/Cloro"));
        elements.add(new cElemento("Argón", "Ar", "18", "39.948", "Gas", "Gases nobles","https://es.wikipedia.org/wiki/Arg%C3%B3n"));
        elements.add(new cElemento("Potasio", "K", "19", "39.0983", "Sólido", "Metales alcalinos","https://es.wikipedia.org/wiki/Potasio"));
        elements.add(new cElemento("Calcio", "Ca", "20", "40.078", "Sólido", "Metales alcalinotérreos","https://es.wikipedia.org/wiki/Calcio"));
        elements.add(new cElemento("Escandio", "Sc", "21", "44.955910", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Escandio"));
        elements.add(new cElemento("Titanio", "Ti", "22", "47.867", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Titanio"));
        elements.add(new cElemento("Vanadio", "V", "23", "50.9415", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Vanadio"));
        elements.add(new cElemento("Cromo", "Cr", "24", "51.9961", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Cromo"));
        elements.add(new cElemento("Manganeso", "Mn", "25", "54.938049", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Manganeso"));
        elements.add(new cElemento("Hierro", "Fe", "26", "55.847", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Hierro"));
        elements.add(new cElemento("Cobalto", "Co", "27", "58.933200", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Cobalto"));
        elements.add(new cElemento("Níquel", "Ni", "28", "58.71", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/N%C3%ADquel"));
        elements.add(new cElemento("Cobre", "Cu", "29", "63.546", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Cobre"));
        elements.add(new cElemento("Zinc", "Zn", "30", "65.38", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Zinc"));
        elements.add(new cElemento("Galio", "Ga", "31", "69.723", "Sólido", "Metales del bloque p","https://es.wikipedia.org/wiki/Galio"));
        elements.add(new cElemento("Germanio", "Ge", "32", "72.64", "Sólido", "Metaloides","https://es.wikipedia.org/wiki/Germanio"));
        elements.add(new cElemento("Arsénico", "As", "33", "74.92160", "Sólido", "Metaloides","https://es.wikipedia.org/wiki/Ars%C3%A9nico"));
        elements.add(new cElemento("Selenio", "Se", "34", "78.96", "Sólido", "No metales","https://es.wikipedia.org/wiki/Selenio"));
        elements.add(new cElemento("Bromo", "Br", "35", "79.904", "Sólido", "Halógenos","https://es.wikipedia.org/wiki/Bromo"));
        elements.add(new cElemento("Kriptón", "Kr", "36", "83.80", "Gas", "Gases nobles","https://es.wikipedia.org/wiki/Kript%C3%B3n"));
        elements.add(new cElemento("Rubidio", "Rb", "37", "85.4678", "Sólido", "Metales alcalinos","https://es.wikipedia.org/wiki/Rubidio"));
        elements.add(new cElemento("Estroncio", "Sr", "38", "87.62", "Sólido", "Metales alcalinotérreos","https://es.wikipedia.org/wiki/Estroncio"));
        elements.add(new cElemento("Itrio", "Y", "39", "88.90585", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Itrio"));
        elements.add(new cElemento("Circonio", "Zr", "40", "91.224", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Circonio"));
        elements.add(new cElemento("Niobio", "Nb", "41", "92.90638", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Niobio"));
        elements.add(new cElemento("Molibdeno", "Mo", "42", "95.94", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Molibdeno"));
        elements.add(new cElemento("Tecnecio", "Tc", "43", "98.9063", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Tecnecio"));
        elements.add(new cElemento("Rutenio", "Ru", "44", "101.07", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Rutenio"));
        elements.add(new cElemento("Rodio", "Rh", "45", "102.90550", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Rodio"));
        elements.add(new cElemento("Paladio", "Pd", "46", "106.42", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Paladio"));
        elements.add(new cElemento("Plata", "Ag", "47", "107.8683", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Plata"));
        elements.add(new cElemento("Cadmio", "Cd", "48", "112.411", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Cadmio"));
        elements.add(new cElemento("Indio", "In", "49", "114.818", "Sólido", "Metales del bloque p","https://es.wikipedia.org/wiki/Indio_(elemento)"));
        elements.add(new cElemento("Estaño", "Sn", "50", "118.710", "Sólido", "Metales del bloque p","https://es.wikipedia.org/wiki/Esta%C3%B1o"));
        elements.add(new cElemento("Antimonio", "Sb", "51", "121.760", "Sólido", "Metaloides","https://es.wikipedia.org/wiki/Antimonio"));
        elements.add(new cElemento("Telurio", "Te", "52", "127.6", "Sólido", "Metaloides","https://es.wikipedia.org/wiki/Telurio"));
        elements.add(new cElemento("Iodo", "I", "53", "126.90447", "Sólido", "Halógenos","https://es.wikipedia.org/wiki/Yodo"));
        elements.add(new cElemento("Xenón", "Xe", "54", "131.293", "Gas", "Gases nobles","https://es.wikipedia.org/wiki/Xen%C3%B3n"));
        elements.add(new cElemento("Cesio", "Cs", "55", "132.90545", "Sólido", "Metales alcalinos","https://es.wikipedia.org/wiki/Cesio"));
        elements.add(new cElemento("Bario", "Ba", "56", "137.327", "Sólido", "Metales alcalinos","https://es.wikipedia.org/wiki/Bario"));
        elements.add(new cElemento("Lantano", "La", "57", "138.9055", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Lantano"));
        elements.add(new cElemento("Cerio", "Ce", "58", "140.116", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Cerio"));
        elements.add(new cElemento("Praseodimio", "Pr", "59", "140.90765", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Praseodimio"));
        elements.add(new cElemento("Neodimio", "Nd", "60", "144.24", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Neodimio"));
        elements.add(new cElemento("Prometio", "Pm", "61", "145", "Sintético", "Lantánidos","https://es.wikipedia.org/wiki/Prometio"));
        elements.add(new cElemento("Samario", "Sm", "62", "150.35", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Samario"));
        elements.add(new cElemento("Europio", "Eu", "63", "151.964", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Europio"));
        elements.add(new cElemento("Gadolinio", "Gd", "64", "157.25", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Gadolinio"));
        elements.add(new cElemento("Terbio", "Tb", "65", "158.92534", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Terbio"));
        elements.add(new cElemento("Disprosio", "Dy", "66", "162.500", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Disprosio"));
        elements.add(new cElemento("Holmio", "Ho", "67", "164.9304", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Holmio"));
        elements.add(new cElemento("Erbio", "Er", "68", "167.259", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Erbio"));
        elements.add(new cElemento("Tulio", "Tm", "69", "168.934", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Tulio"));
        elements.add(new cElemento("Iterbio", "Yb", "70", "173.04", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Iterbio"));
        elements.add(new cElemento("Lutecio", "Lu", "71", "174.967", "Sólido", "Lantánidos","https://es.wikipedia.org/wiki/Lutecio"));
        elements.add(new cElemento("Hafnio", "Hf", "72", "178.49", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Hafnio"));
        elements.add(new cElemento("Tántalo", "Ta", "73", "180.9479", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/T%C3%A1ntalo_(elemento)"));
        elements.add(new cElemento("Tungsteno", "W", "74", "183.84", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Wolframio"));
        elements.add(new cElemento("Renio", "Re", "75", "186.207", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Renio"));
        elements.add(new cElemento("Osmio", "Os", "76", "190.23", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Osmio"));
        elements.add(new cElemento("Iridio", "Ir", "77", "192.217", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Iridio"));
        elements.add(new cElemento("Platino", "Pt", "78", "195.084", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Platino"));
        elements.add(new cElemento("Oro", "Au", "79", "196.966569", "Sólido", "Metales de transición","https://es.wikipedia.org/wiki/Oro"));
        elements.add(new cElemento("Mercurio", "Hg", "80", "200.59", "Líquido", "Metales de transición","https://es.wikipedia.org/wiki/Mercurio_(elemento)"));
        elements.add(new cElemento("Talio", "Tl", "81", "204.3833", "Sólido", "Metales del bloque p","https://es.wikipedia.org/wiki/Talio"));
        elements.add(new cElemento("Plomo", "Pb", "82", "207.2", "Sólido", "Metales del bloque p","https://es.wikipedia.org/wiki/Plomo"));
        elements.add(new cElemento("Bismuto", "Bi", "83", "208.980386", "Sólido", "Metales del bloque p","https://es.wikipedia.org/wiki/Bismuto"));
        elements.add(new cElemento("Polonio", "Po", "84", "209.9824", "Sólido", "Metaloides","https://es.wikipedia.org/wiki/Polonio"));
        elements.add(new cElemento("Ástato", "At", "85", "210", "Sólido", "Halógenos","https://es.wikipedia.org/wiki/%C3%81stato"));
        elements.add(new cElemento("Radón", "Rn", "86", "222", "Gas", "Gases nobles","https://es.wikipedia.org/wiki/Rad%C3%B3n"));
        elements.add(new cElemento("Francio", "Fr", "87", "223", "Sólido", "Metales alcalinos","https://es.wikipedia.org/wiki/Francio"));
        elements.add(new cElemento("Radio", "Ra", "88", "226.0254", "Sólido", "Metales alcalinotérreos","https://es.wikipedia.org/wiki/Radio_(elemento)"));
        elements.add(new cElemento("Actinio", "Ac", "89", "227", "Sólido", "Actínidos","https://es.wikipedia.org/wiki/Actinio"));
        elements.add(new cElemento("Torio", "Th", "90", "232.0381", "Sólido", "Actínidos","https://es.wikipedia.org/wiki/Torio"));
        elements.add(new cElemento("Protactinio", "Pa", "91", "231.03588", "Sólido", "Actínidos","https://es.wikipedia.org/wiki/Protactinio"));
        elements.add(new cElemento("Uranio", "U", "92", "238.02891", "Sólido", "Actínidos","https://es.wikipedia.org/wiki/Uranio"));
        elements.add(new cElemento("Neptunio", "Np", "93", "237", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Neptunio"));
        elements.add(new cElemento("Plutonio", "Pu", "94", "244", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Plutonio"));
        elements.add(new cElemento("Americio", "Am", "95", "243", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Americio"));
        elements.add(new cElemento("Curio", "Cm", "96", "247", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Curio"));
        elements.add(new cElemento("Berkelio", "Bk", "97", "247", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Berkelio"));
        elements.add(new cElemento("Californio", "Cf", "98", "251", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Californio"));
        elements.add(new cElemento("Einstenio", "Es", "99", "252", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Einstenio"));
        elements.add(new cElemento("Fermio", "Fm", "100", "257", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Fermio"));
        elements.add(new cElemento("Mendelevio", "Md", "101", "258.1", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Mendelevio"));
        elements.add(new cElemento("Nobelio", "No", "102", "259", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Nobelio"));
        elements.add(new cElemento("Lawrencio", "Lr", "103", "262", "Sintético", "Actínidos","https://es.wikipedia.org/wiki/Lawrencio"));
        elements.add(new cElemento("Rutherfordio", "Rf", "104", "261", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Rutherfordio"));
        elements.add(new cElemento("Dubnio", "Db", "105", "262", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Dubnio"));
        elements.add(new cElemento("Seaborgio", "Sg", "106", "269", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Seaborgio"));
        elements.add(new cElemento("Bohrio", "Bh", "107", "264", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Bohrio"));
        elements.add(new cElemento("Hasio", "Hs", "108", "269", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Hasio"));
        elements.add(new cElemento("Meitnerio", "Mt", "109", "268", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Meitnerio"));
        elements.add(new cElemento("Darmstatio", "Ds", "110", "281", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Darmstatio"));
        elements.add(new cElemento("Roentgenio", "Rg", "111", "281", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Roentgenio"));
        elements.add(new cElemento("Copernicio", "Cn", "112", "285", "Sintético", "Metales de transición","https://es.wikipedia.org/wiki/Copernicio"));
        elements.add(new cElemento("Nihonio", "Nh", "113", "286", "Sintético", "Metales del bloque p","https://es.wikipedia.org/wiki/Nihonio"));
        elements.add(new cElemento("Flerovio", "Fl", "114", "287", "Sintético", "Metales del bloque p","https://es.wikipedia.org/wiki/Flerovio"));
        elements.add(new cElemento("Moscovio", "Mc", "115", "288", "Sintético", "Metales del bloque p","https://es.wikipedia.org/wiki/Moscovio"));
        elements.add(new cElemento("Livermorio", "Lv", "116", "291", "Sintético", "Metales del bloque p","https://es.wikipedia.org/wiki/Livermorio"));
        elements.add(new cElemento("Teneso", "Ts", "117", "294", "Sintético", "Halógenos","https://es.wikipedia.org/wiki/Teneso"));
        elements.add(new cElemento("Oganesón", "Og", "118", "294", "Sintético", "Gases nobles","https://es.wikipedia.org/wiki/Oganes%C3%B3n"));


        elementsFiltrat.clear();
        if(elementsFiltrat.size() < elements.size()) {
            for (int i = 0; i < elements.size(); i++) {
                elementsFiltrat.add(elements.get(i));
            }
        }

        // Construim l'adaptador utilitzant un layout per defecte de Android.
        //AdaptadorElemento adaptador = new AdaptadorElemento(this, elements);

        AdaptadorElemento adaptador = new AdaptadorElemento(this, elementsFiltrat); //elementsFiltrat

        // Assignem al listview l'adaptador creat
        lst = (ListView) findViewById(R.id.listElementos);
        lst.setAdapter(adaptador);

        // Capturem el clic d'un element de la listview
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                cElemento element = (cElemento) a.getItemAtPosition(position);

                Intent detalle = new Intent(listViewElementos.this, infoElemento.class);
                detalle.putExtra("url", element.getUrl());
                detalle.putExtra("nombre", element.getNombre());
                detalle.putExtra("simbolo", element.getSimbolo());
                detalle.putExtra("posicion", element.getPosicion());
                detalle.putExtra("numero", element.getNumero());
                detalle.putExtra("tipo", element.getTipo());
                detalle.putExtra("serie", element.getSerie());

                startActivity(detalle);
                }


        });


    }


    public void filtro(String tipo){

        ArrayList<cElemento> listaElemento = new ArrayList<>();
        listaElemento.clear();

        List<cElemento> list = elements;

            for (int i = 0; i < list.size(); i++) {
                cElemento element = list.get(i);
                if(tipo == "TODOS") {
                    listaElemento.addAll(elements);       //no va, arreglar en clas
                    break;
                }
                else if (element.getTipo().equals(tipo)) {
                    listaElemento.add(element);
                }
            }

        AdaptadorElemento adaptador2 = new AdaptadorElemento(this, listaElemento);
        lst.setAdapter(adaptador2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_action_bar_layout, menu);
        return true;
    }

    // Capturar pulsacions en el menú de la barra superior.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.inicio:
                Intent intentInicio = new Intent(this, MainActivity.class);
                startActivity(intentInicio);
                return true;
            case R.id.jugar:
                Intent intentJuego = new Intent(this, juego.class);
                startActivity(intentJuego);
                return true;
            case R.id.todos:
                filtro("TODOS");
                break;
            case R.id.solidos:
                filtro("Sólido");
                break;
            case R.id.gases:
                filtro("Gas");
                break;
            case R.id.liquidos:
                filtro("Líquido");
                break;
            case R.id.sinteticos:
                filtro("Sintético");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    }

    class AdaptadorElemento extends ArrayAdapter<cElemento> {

        public AdaptadorElemento(Context context, ArrayList<cElemento> elementsFiltrat) {
            super(context, R.layout.layout_elemento, elementsFiltrat);
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_elemento, null);

            cElemento Elemento = (cElemento) getItem(position);

            TextView tvNombre = (TextView) item.findViewById(R.id.textView7);     /*nombre por definir*/
            tvNombre.setText(Elemento.getNombre());

            TextView tvSimbolo = (TextView) item.findViewById(R.id.textView8);    /*nombre por definir*/
            tvSimbolo.setText(Elemento.getSimbolo());

            TextView tvPosicion = (TextView) item.findViewById(R.id.textView9);    /*nombre por definir*/
            tvPosicion.setText(Elemento.getPosicion());

            if (Elemento.getSerie().equals("No metales")) {
                item.setBackgroundColor(Color.parseColor("#69F0AE"));
            }
            else if (Elemento.getSerie().equals("Gases nobles")) {
                item.setBackgroundColor(Color.parseColor("#c0ffff"));
            }
            else if (Elemento.getSerie().equals("Metales alcalinos")) {
                item.setBackgroundColor(Color.parseColor("#EF5350"));
            }
            else if (Elemento.getSerie().equals("Metales alcalinotérreos")) {
                item.setBackgroundColor(Color.parseColor("#FFE0B2"));
            }
            else if (Elemento.getSerie().equals("Metaloides")) {
                item.setBackgroundColor(Color.parseColor("#D1BB92"));
            }
            else if (Elemento.getSerie().equals("Halógenos")) {
                item.setBackgroundColor(Color.parseColor("#FCEC7B"));
            }
            else if (Elemento.getSerie().equals("Metales del bloque p")) {
                item.setBackgroundColor(Color.parseColor("#B0BEC5"));
            }
            else if (Elemento.getSerie().equals("Lantánidos")) {
                item.setBackgroundColor(Color.parseColor("#FFAAFB"));
            }
            else if (Elemento.getSerie().equals("Actínidos")) {
                item.setBackgroundColor(Color.parseColor("#F06292"));
            }
            else if (Elemento.getSerie().equals("Metales de transición")) {
                item.setBackgroundColor(Color.parseColor("#ffc0c0"));
            }

            if(Elemento.getTipo().equals("Sólido")){
                tvPosicion.setTextColor(Color.BLACK);
            }
            else if(Elemento.getTipo().equals("Gas")){
                tvPosicion.setTextColor(Color.parseColor("#009688"));
            }
            else if(Elemento.getTipo().equals("Líquido")){
                tvPosicion.setTextColor(Color.BLUE);
            }
            else if(Elemento.getTipo().equals("Sintético")){
                tvPosicion.setTextColor(Color.RED);
            }

            return (item);
        }
    }






