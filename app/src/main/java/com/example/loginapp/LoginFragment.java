package com.example.loginapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.loginapp.services.LoginService;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private final LoginService loginService = new LoginService();

    public LoginFragment() {
//        Button buttonLogin = getActivity().findViewById(R.id.btn_login);
//        buttonLogin.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                loginService.execute();
//            }
//        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

}
