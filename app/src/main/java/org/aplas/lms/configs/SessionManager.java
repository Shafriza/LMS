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

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    public static final String USER_TOKEN = "user_token";
    public static final String USER_ROLE = "user_role";

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

}
