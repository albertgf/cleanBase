package com.albertgf.cleanbase.di.component;

import android.app.Activity;


import com.albertgf.cleanbase.di.PerActivity;
import com.albertgf.cleanbase.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by albert on 17/04/15.
 */
@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
