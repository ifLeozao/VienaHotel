package com.example.vienahoteldev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLData;

import database.DB;

public class
MainActivity extends AppCompatActivity {
    private DB mydb;
    private EditText edtUsuario;
    private EditText edtSenha;;
    private ProgressBar progressBar;;

    public void LoginAPI(View view) {
        ConsumirAPI(); }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        mydb = new DB(this);
        inicializarObjetos();

        Log.v("MyTag", "Passei Main - onCreate");

    }

    private void inicializarObjetos() {
        edtUsuario = (EditText) findViewById(R.id.email);
        edtSenha = (EditText) findViewById(R.id.senha);
    }

    public void Login(View v) {
        Login objClasseLogin = new Login();
        objClasseLogin.setUsuario(edtUsuario.getText().toString());
        objClasseLogin.setSenha(edtSenha.getText().toString());
         Log.v("TAG", "Acessou rotina de validação");
        if (objClasseLogin.Validarusuario() == false) {
            Util.Mensagem(this,"Dados Invalidos!","Atenção");

            mydb.insertLogin(objClasseLogin.getUsuario(),objClasseLogin.getSenha());
        } else {
//            Intent janelaMenu=new Intent(MainActivity.this, MenuActivity.class);
            Intent janelaMenu=new Intent(MainActivity.this, Menu.class);

            janelaMenu.putExtra("nome", objClasseLogin.getUsuario());
            startActivity(janelaMenu);
        }
    }
    public void Registro(View view) {
        startActivity(new Intent(MainActivity.this,Cadastro.class));

        Intent intent = new Intent(MainActivity.this,Cadastro.class);
        startActivity(intent);
    }

    private void ConsumirAPI() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "https://aldriano.com.br/unip2021-ads/api/validalogin.php";

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("UserName", edtUsuario.getText());
            jsonBody.put("UserPwd", edtSenha.getText());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //System.out.println(response);
                try{
                    String isStatus = response.getString("status");
                    if (isStatus.equalsIgnoreCase("ok")) {
                        int _id = response.getInt("id");
                        chamarMenu(_id);
                    }
                }catch (JSONException e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //error.printStackTrace();
                String responseBody="";
                try {
                    responseBody = new String(error.networkResponse.data, "utf-8");
                    JSONObject jsonObject = new JSONObject(responseBody);
                    Toast.makeText(getApplicationContext(),jsonObject.getString("error"),Toast.LENGTH_LONG).show();
                }catch (Exception erro){
                    Toast.makeText(getApplicationContext(),"Exception: "+responseBody,Toast.LENGTH_LONG).show();
                    Log.v("minhaTAG", responseBody);
                }
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public  void chamarMenu(int _id){
        Intent janelaMenu = new Intent(MainActivity.this, Menu.class);
        janelaMenu.putExtra("id",_id);
        startActivity(janelaMenu);
    }
}