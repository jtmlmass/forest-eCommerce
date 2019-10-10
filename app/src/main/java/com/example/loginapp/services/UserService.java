package com.example.loginapp.services;

import android.util.Log;
import android.widget.Toast;

import com.example.loginapp.models.TipoUsuario;
import com.example.loginapp.models.Usuario;

import java.util.ArrayList;
import java.util.Date;

public class UserService {
    private ArrayList<Usuario> usuarios;

    public UserService() {
        ArrayList usuariosPrueba = new ArrayList();
        Usuario usuarioCliente = new Usuario("Jose", "cliente", "cliente@gmail.com", "cliente", TipoUsuario.CLIENTE, "8291110000", new Date(1996,02,27));
        Usuario usuarioSuplidor = new Usuario("Jose", "suplidor", "suplidor@gmail.com", "suplidor", TipoUsuario.SUPLIDOR, "8291110000", new Date(1996,02,27));
        usuariosPrueba.add(usuarioCliente);
        usuariosPrueba.add(usuarioSuplidor);
        this.usuarios = usuariosPrueba;
    }

    public void agregarUsuario(String nombre, String usuario, String email, String contrasena, TipoUsuario tipoUsuario, String numeroTelefono, Date fechaNacimiento){
        Usuario user = new Usuario(nombre, usuario, email, contrasena, tipoUsuario, numeroTelefono, fechaNacimiento);
        Log.i("Agregar User Service", user.toString());
        this.usuarios.add(user);
    }

    public boolean verificiarUsuario(String usuario, String contrasena){
        for(Usuario user : this.usuarios){
            if(user.getUsuario().equals(usuario)){
                return user.getContrasena().equals(contrasena);
            }else{
//                Toast.makeText(this, errorUsuario, Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return false;
    }

    public Usuario getUsuario(String usuario){
        for(Usuario user : this.usuarios){
            if(user.getUsuario().equals(usuario)){
                return user;
            }
        }
        return null;
    }
}
