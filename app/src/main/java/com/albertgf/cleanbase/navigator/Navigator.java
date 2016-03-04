package com.albertgf.cleanbase.navigator;

import android.app.Activity;
import android.content.Intent;

import com.albertgf.cleanbase.activity.MainActivity;

public class Navigator {
    public void navigateToMain(Activity context) {
        if(context != null) {
            Intent intentToLaunch = MainActivity.getCallingIntent(context);
            intentToLaunch.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intentToLaunch);
        }
    }
}