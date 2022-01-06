package com.example.vienahoteldev;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Reserva extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner Quartos;
    EditText DataEntrada;
    EditText DataSaida;
    Button BotaoReservar;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_reserva);
        context = this;
        Inicializar();

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quartos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void Inicializar() {
        Quartos = findViewById(R.id.spinner);
        DataEntrada = findViewById((R.id.edtdataEntrada));
        DataSaida = findViewById((R.id.edtDataSaida));
        BotaoReservar = findViewById((R.id.btnReservar));

        BotaoReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.Mensagem(context, "Em desenvolvimento" ,"Reserva");
                SalvarReserva();
            }
        });

        DataSaida.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                CarregaQuartos();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    private void SalvarReserva(){
        Util.Mensagem(context, "TesteQuartos", "Teste");

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = ""; //Url api

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("DataEntrada", DataEntrada.getText());
            jsonBody.put("DataSaida", DataSaida.getText());

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                //System.out.println(response);
//                try{
//                    // Quartos.setAdapter(new ArrayAdapter<String>());
//                }catch (JSONException e){
//                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                //error.printStackTrace();
//                String responseBody="";
//                try {
//                    responseBody = new String(error.networkResponse.data, "utf-8");
//                    JSONObject jsonObject = new JSONObject(responseBody);
//                    Toast.makeText(getApplicationContext(),jsonObject.getString("error"),Toast.LENGTH_LONG).show();
//                }catch (Exception erro){
//                    Toast.makeText(getApplicationContext(),"Exception: "+responseBody, Toast.LENGTH_LONG).show();
//                    Log.v("minhaTAG", responseBody);
//                }
//            }
//        });
//        requestQueue.add(jsonObjectRequest);
    }

    private void CarregaQuartos(){
        Util.Mensagem(context, "TesteQuartos", "Teste");

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = ""; //Url api

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("DataEntrada", DataEntrada.getText());
            jsonBody.put("DataSaida", DataSaida.getText());

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                //System.out.println(response);
//                try{
//                    // Quartos.setAdapter(new ArrayAdapter<String>());
//                }catch (JSONException e){
//                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                //error.printStackTrace();
//                String responseBody="";
//                try {
//                    responseBody = new String(error.networkResponse.data, "utf-8");
//                    JSONObject jsonObject = new JSONObject(responseBody);
//                    Toast.makeText(getApplicationContext(),jsonObject.getString("error"),Toast.LENGTH_LONG).show();
//                }catch (Exception erro){
//                    Toast.makeText(getApplicationContext(),"Exception: "+responseBody,Toast.LENGTH_LONG).show();
//                    Log.v("minhaTAG", responseBody);
//                }
//            }
//        });
//        requestQueue.add(jsonObjectRequest);

    }


}