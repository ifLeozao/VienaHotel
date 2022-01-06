package com.example.vienahoteldev;

public class Login {

    private String Usuario;
    private String Senha;
    private int _Id;

    public Login(){}

    public boolean Validarusuario(){
        if (getUsuario().equals("")){
            return false;
        }
        else if (getSenha().equals("")) {
            return false;
        }
        else if (!getUsuario().equals("admin") || !getSenha().equals("admin")) {


            return false;
        }
        else {
            return true;
        }
    }
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public int getId() {return _Id;}

    public void setId(String _Id) { Senha =_Id; }
}
