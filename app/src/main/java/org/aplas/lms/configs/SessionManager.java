package org.aplas.lms.configs;

import android.content.Context;
import android.content.SharedPreferences;

import org.aplas.lms.R;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    public static final String USER_TOKEN = "user_token";
    public static final String USER_ROLE = "user_role";
    public static final String USER_EMAIL = "user_email";

    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(context.getString(R.string.app_name), PRIVATE_MODE);
        editor = pref.edit();
    }

    // Auth Token
    public void saveAuthToken(String token) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(USER_TOKEN, token);
        editor.apply();
    }

    public final String fetchAuthToken() {
        String token = pref.getString(USER_TOKEN, null);
        return token;
    }


    // User Role
    public void saveUserRole(String role) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(USER_ROLE, role);
        editor.apply();
    }

    public final String fetchUserRole() {
        String token = pref.getString(USER_ROLE, null);
        return token;
    }

    // Auth Email
    public void saveAuthEmail(String email) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(USER_EMAIL, email);
        editor.apply();
    }

    public final String fetchAuthEmail() {
        String token = pref.getString(USER_EMAIL, null);
        return token;
    }

}
