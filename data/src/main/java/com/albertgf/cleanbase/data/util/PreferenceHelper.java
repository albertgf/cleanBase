package com.albertgf.cleanbase.data.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

/**
 * Created by albert on 03/03/15.
 */
public final class PreferenceHelper {

    //CONSTANTS
    public static String PREFS_KEY_EXAMPLE = "example";

    private static Context mContext;
    private static SharedPreferences.Editor mEditor;
    private static Gson mGson;
    private static volatile PreferenceHelper mPreferenceHelper;

    private PreferenceHelper(Context context) {
        mContext = context;
        mEditor = getEditor();
        mGson = new Gson();
    }

    private static SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    private static void saveInSharedPreferences(String key, String model) {
        mEditor.putString(key, model).commit();
    }

    private static void saveInSharedPreferences(String key, boolean value) {
        mEditor.putBoolean(key, value).commit();
    }

    private static void saveInSharedPreferences(String key, int value) {
        mEditor.putInt(key, value).commit();
    }

    private static void saveInSharedPreferences(String key, double value) {
        mEditor.putFloat(key, (float) value).commit();
    }


    public static PreferenceHelper getInstance(Context context) {
        PreferenceHelper result = mPreferenceHelper;
        if (result == null) {
            synchronized (PreferenceHelper.class) {
                result = mPreferenceHelper;
                if (result == null) {
                    mPreferenceHelper = result = new PreferenceHelper(context);
                }
            }
        }
        return result;
    }

    private SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }

    public int getAppVersion() {
        return getPreferences().getInt(PREFS_KEY_EXAMPLE, Integer.MIN_VALUE);
    }

    public void setAppVersion(int version) {
        saveInSharedPreferences(PREFS_KEY_EXAMPLE, version);
    }
}
