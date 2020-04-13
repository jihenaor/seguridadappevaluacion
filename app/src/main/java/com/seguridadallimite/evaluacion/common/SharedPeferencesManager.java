package com.seguridadallimite.evaluacion.common;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPeferencesManager {
    private static  final String APP_SETTINGS_FILE = "APP_SETTINGS";

    private SharedPeferencesManager(){

    }

    private static SharedPreferences getSharedPreferences() {
        return MyApp.getcontext().
                getSharedPreferences(APP_SETTINGS_FILE, Context.MODE_PRIVATE);
    }

    public static void setSomeStringValue(String dataLabel, String dataValue) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();

        editor.putString(dataLabel, dataValue);
        editor.commit();
    }

    public static void setSomeBooleanValue(String dataLabel, Boolean dataValue) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();

        editor.putBoolean(dataLabel, dataValue);
        editor.commit();
    }

    public static String getSomeStringValue(String dataLabel) {
        return getSharedPreferences().getString(dataLabel, null);
    }
}
