package com.albertgf.cleanbase.di.module;

import android.app.Activity;

import com.albertgf.cleanbase.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albert on 17/04/15.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides @PerActivity Activity activity() {
        return this.activity;
    }
}
