package es.carlossc212.concesionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button atras, alante, ver;
    TextView titulo, precio, lugar;
    Anuncio a;

    int n = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DBConnection con = new DBConnection();

        titulo = findViewById(R.id.tvTitulo);
        precio = findViewById(R.id.tvPrecio);
        lugar = findViewById(R.id.tvLugar);


        atras = findViewById(R.id.atras);

        atras.setOnClickListener(v->{
            if (n==0){

            }else{
                n--;
                putAnuncio();
            }
        });
        alante = findViewById(R.id.alante);
        alante.setOnClickListener(v->{
            if ((n+1)==Anuncio.anuncios.size()){

            }else{
                n++;
                putAnuncio();
            }
        });
        ver = findViewById(R.id.btVer);
        ver.setOnClickListener(v->{
            Intent i = new Intent(this, ActivityDetail.class);
            i.putExtra("anuncio", a);
            startActivity(i);
        });

        if (Anuncio.anuncios.size()>0){
            putAnuncio();
        }

    }


    private void putAnuncio(){
        a = Anuncio.anuncios.get(n);

        titulo.setText(a.titulo);
        precio.setText(a.precio+"€");
        lugar.setText(a.lugar);
    }


}



