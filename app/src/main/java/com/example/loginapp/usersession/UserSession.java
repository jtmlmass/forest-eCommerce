package com.example.loginapp.usersession;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;


import com.example.loginapp.MainActivity;

import java.util.HashMap;

public class UserSession {
    // Shared Preferences
    SharedPreferences sharedPreferences;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context context;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    // Sharedpref file name
    private static final String PREF_NAME = "UserSessionPref";

    // First time logic Check
    public static final String FIRST_TIME = "firsttime";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // User rol (make variable public to access from outside)
    public static final String KEY_ROL = "rol";

    // User name (make variable public to access from outside)
    public static final String KEY_USER = "user";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    // user avatar (make variable public to access from outside)
    public static final String KEY_PHOTO = "photo";

    // number of items in our cart
    public static final String KEY_CART = "cartvalue";

    // check first time app launch
    public static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public UserSession(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    /**
     * Create login session
     */
    public void createLoginSession(String name, String rol, String user, String email, String photo) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // Storing rol in pref
        editor.putString(KEY_ROL, rol);

        // Storing user in pref
        editor.putString(KEY_USER, user);

        // Storing email in pref
        editor.putString(KEY_EMAIL, email);

        // Storing image url in pref
        editor.putString(KEY_PHOTO, photo);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    public void checkLogin() {
        // Check login status
        if (!this.isLoggedIn()) {
            // user is not logged in redirect him to Login Activity
            Intent intent = new Intent(context, MainActivity.class);
            // Closing all the Activities
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            context.startActivity(intent);
        }

    }


    /**
     * Get stored session data
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<>();
        // user name
        user.put(KEY_NAME, sharedPreferences.getString(KEY_NAME, null));
        // user rol
        user.put(KEY_ROL, sharedPreferences.getString(KEY_ROL, null));
        // user user
        user.put(KEY_USER, sharedPreferences.getString(KEY_USER, null));
        // user email id
        user.put(KEY_EMAIL, sharedPreferences.getString(KEY_EMAIL, null));
        // user avatar
        user.put(KEY_PHOTO, sharedPreferences.getString(KEY_PHOTO, null));
        // return user
        return user;
    }

    /**
     * Clear session details
     */
    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.putBoolean(IS_LOGIN, false);
        editor.commit();

        // After logout redirect user to Login Activity
        Intent intent = new Intent(context, MainActivity.class);
        // Closing all the Activities
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(intent);
    }

    /**
     * Quick check for login
     **/
    // Get Login State
    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public int getCartValue() {
        return sharedPreferences.getInt(KEY_CART, 0);
    }

    public Boolean getFirstTime() {
        return sharedPreferences.getBoolean(FIRST_TIME, true);
    }

    public void setFirstTime(Boolean n) {
        editor.putBoolean(FIRST_TIME, n);
        editor.commit();
    }


    public void increaseCartValue() {
        int val = getCartValue() + 1;
        editor.putInt(KEY_CART, val);
        editor.commit();
        Log.e("Cart Value PE", "Var value : " + val + "Cart Value :" + getCartValue() + " ");
    }

    public void decreaseCartValue() {
        int val = getCartValue() - 1;
        editor.putInt(KEY_CART, val);
        editor.commit();
        Log.e("Cart Value PE", "Var value : " + val + "Cart Value :" + getCartValue() + " ");
    }

    public void setCartValue(int count) {
        editor.putInt(KEY_CART, count);
        editor.commit();
    }


    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
