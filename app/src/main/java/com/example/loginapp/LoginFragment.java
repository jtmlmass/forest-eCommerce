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

import com.example.loginapp.services.UserService;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment{

        private final UserService userService = new UserService();
        private EditText txtEmail;
        private EditText txtPassword;
        private Button btnLogin;
        public LoginFragment() {

        }


        @Override
        public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_login, container, false);

            txtEmail = (EditText) rootView.findViewById(R.id.et_usuario);
            txtPassword = (EditText) rootView.findViewById(R.id.et_password);
            btnLogin = (Button) rootView.findViewById(R.id.btn_enviar);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("LoginFragment", "entro");
                    intentarLogin();
                }
            });
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_login, container, false);
        }

        public void intentarLogin(){
            final String email = this.txtEmail.getText().toString();
            final String password = this.txtPassword.getText().toString();
            if(userService.verificiarUsuario(email, password)){
                Intent intent = new Intent(getActivity(), Home.class);
                startActivity(intent);
            }
        }
}
