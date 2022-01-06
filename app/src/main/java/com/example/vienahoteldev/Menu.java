package com.example.vienahoteldev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements View.OnClickListener
{
    CardView btResevva,Res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu);
//        Rest = (CardView) findViewById(R.id.restaurant);
//        Res = (CardView) findViewById(R.id.btreserva);
//
//        Rest.setOnClickListener((View.OnClickListener) this);
//        Res.setOnClickListener((View.OnClickListener)this);

        Log.v("MyTag", "passei onCreate");

        inicializa();
    }


    private void inicializa() {
        Log.v("MyTag", "passei zqui");
        btResevva = (CardView) findViewById(R.id.btreserva);
        Res = (CardView) findViewById(R.id.restaurant);
        Res.setOnClickListener(this);
        btResevva.setOnClickListener(this);
    }


   @Override
   public void onClick(View view) {
        Intent i;
        switch (view.getId()){

            case R.id.btreserva: i = new Intent(this, Reserva.class);
            startActivity(i);
            break;

            case R.id.restaurant: i = new Intent(this, Restaurante.class);
                startActivity(i);
                break;

//            case R.id.sair: i = new Intent  System.exit(0);





//        switch (view.getId()){
//           case R.id.btreserva: Log.v("MyTag", "passei onclickok");
//
//            case R.id.restaurant:
//
//               startActivity(new Intent(Menu.this, Reserva.class));
//               startActivity(new Intent(Menu.this, Restaurante.class));
//
//          // case R.id.restaurant: i = new Intent(this,Restaurante.class);startActivity(i);break;
//        }
    }
    }
}

