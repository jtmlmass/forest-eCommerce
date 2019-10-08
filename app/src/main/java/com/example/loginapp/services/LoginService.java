package com.example.loginapp.services;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginService extends AsyncTask<Void, Void, JSONObject>{
    private static final String LOGIN_URL = "http://ec2-3-86-40-181.compute-1.amazonaws.com:9876/users";
    @Override
    protected JSONObject doInBackground(Void... voids){
        try {
            URL url = new URL(LOGIN_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            final StringBuilder stringBuilder = new StringBuilder();
            try {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                Log.i("stringBuilder", stringBuilder.toString());
            } catch (IOException e) {
                throw new IOException(e);
            } finally {
                connection.disconnect();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
