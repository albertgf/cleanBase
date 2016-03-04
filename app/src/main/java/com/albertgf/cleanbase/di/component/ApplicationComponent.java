package com.albertgf.cleanbase.di.component;

import android.content.Context;


import com.albertgf.cleanbase.activity.BaseActivity;
import com.albertgf.cleanbase.di.module.ApplicationModule;
import com.albertgf.cleanbase.domain.executor.PostExecutionThread;
import com.albertgf.cleanbase.domain.executor.ThreadExecutor;
import com.albertgf.cleanbase.domain.repository.ExampleRepository;
import com.albertgf.cleanbase.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by albert on 17/04/15.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();

    Navigator Navigator();
    //THREADS
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    //REPOSITORIES
    ExampleRepository exampleRepository();

}
