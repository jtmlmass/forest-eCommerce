package com.example.loginapp.models;

public enum TipoUsuario {
    CLIENTE, SUPLIDOR;

    public String getString(TipoUsuario tipoUsuario){
        switch (tipoUsuario){
            case CLIENTE:
                return "Cliente";
            case SUPLIDOR:
                return "Administrador";
             default:
                 return "";
        }
    }
}
