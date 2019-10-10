package com.example.loginapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginapp.models.TipoUsuario;
import com.example.loginapp.models.Usuario;
import com.example.loginapp.services.UserService;
import com.example.loginapp.usersession.UserSession;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment{

        private final UserService userService = new UserService();
        private UserSession session;
        private EditText txtEmail;
        private EditText txtPassword;
        private Button btnLogin;
        public LoginFragment() {

        }


        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_login, container, false);

            session = new UserSession(rootView.getContext());
            txtEmail = (EditText) rootView.findViewById(R.id.et_usuario);
            txtPassword = (EditText) rootView.findViewById(R.id.et_password);
            btnLogin = (Button) rootView.findViewById(R.id.btn_enviar);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("LoginFragment 47 entro");
                    intentarLogin();
                }
            });
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_login, container, false);
        }

        public void intentarLogin(){
            final String correo = this.txtEmail.getText().toString();
            final String password = this.txtPassword.getText().toString();
            if(userService.verificiarUsuario(correo, password)){
                Usuario usuario = userService.getUsuario(correo);
                final String name = usuario.getNombre();
                final String rol = usuario.getTipoUsuario().toString();
                final String user = usuario.getUsuario();
                final String email = usuario.getEmail();
                final String photo = "";

                //create shared preference and store data
                session.createLoginSession(name, rol, user, email, photo);

                startActivity(new Intent(this.getActivity(), Home.class));
                this.getActivity().finish();
            }
        }
}
