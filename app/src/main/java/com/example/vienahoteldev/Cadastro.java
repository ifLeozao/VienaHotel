package com.example.vienahoteldev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.DB;

public class Cadastro extends AppCompatActivity {
    EditText edNome;
    EditText edCpf;
    EditText edTel;
    EditText edNasc;
    EditText edEmail;
    EditText edSenha;
    Button btnCadastar;
    DB mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); //desativa a Action Bar
        setContentView(R.layout.activity_cadastro);

        inicializarObjetos();
        btnCadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SalvarLogin();
            }
        });
    }


    private void inicializarObjetos() {
        edNome = (EditText) findViewById(R.id.edit_nome); //getCurrentFocus();
        edCpf = (EditText) findViewById(R.id.edit_cpf);
//        edTel = (EditText) findViewById(R.id.edit_tel);
//        edNasc = (EditText) findViewById(R.id.edit_nasc);
//        edEmail = (EditText) findViewById(R.id.edit_email);
//        edSenha = (EditText) findViewById(R.id.edit_senha);
        btnCadastar  = (Button) findViewById(R.id.bt_cadastrar);
        mydb = new DB(this);
    }

    public void SalvarLogin(){
        if(edNome.getText().toString().isEmpty() || edCpf.getText().toString().isEmpty() || edTel.getText().toString().isEmpty() || edNasc.getText().toString().isEmpty() ||  edEmail.getText().toString().isEmpty() || edSenha.getText().toString().isEmpty()){
            Util.Mensagem(this,"Informar o Email e senha!","Atenção");
            return;
        }
        try {
            mydb.insertLogin(edEmail.getText().toString(),edSenha.getText().toString());
            finish();
        }catch (Exception ERRO){
            Util.Mensagem(this,"Erro: "+ERRO.getMessage(), "Atenção");
        }
    }
}