package com.albertgf.cleanbase;

import android.app.Application;

import com.albertgf.cleanbase.di.component.ApplicationComponent;
import com.albertgf.cleanbase.di.component.DaggerApplicationComponent;
import com.albertgf.cleanbase.di.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by albert on 04/03/16.
 */
public class BaseApp extends Application {
    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        //logger
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        //DI
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
