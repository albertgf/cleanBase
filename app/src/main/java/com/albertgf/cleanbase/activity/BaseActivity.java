package com.albertgf.cleanbase.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.albertgf.cleanbase.BaseApp;
import com.albertgf.cleanbase.di.component.ApplicationComponent;
import com.albertgf.cleanbase.di.module.ActivityModule;
import com.albertgf.cleanbase.navigator.Navigator;

import javax.inject.Inject;

/**
 * Created by albert on 03/02/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Inject Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((BaseApp) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

}