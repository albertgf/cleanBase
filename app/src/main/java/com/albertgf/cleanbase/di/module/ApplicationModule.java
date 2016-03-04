package com.albertgf.cleanbase.di.module;

import android.content.Context;

import com.albertgf.cleanbase.BaseApp;
import com.albertgf.cleanbase.UIThread;
import com.albertgf.cleanbase.data.executor.JobExecutor;
import com.albertgf.cleanbase.data.repository.ExampleDataRepository;
import com.albertgf.cleanbase.domain.executor.PostExecutionThread;
import com.albertgf.cleanbase.domain.executor.ThreadExecutor;
import com.albertgf.cleanbase.domain.repository.ExampleRepository;
import com.albertgf.cleanbase.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albert on 17/04/15.
 */
@Module
public class ApplicationModule {
    private final BaseApp application;

    public ApplicationModule(BaseApp application) {
        this.application = application;
    }

    @Provides @Singleton Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides @Singleton ExampleRepository provideExampleRepository(ExampleDataRepository repository) {
        return repository;
    }
}
