package com.albertgf.cleanbase.data.repository.datasource;

import android.content.Context;

import com.albertgf.cleanbase.data.util.PreferenceHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by albert on 23/02/15.
 */
@Singleton
public class DataSourceFactory {
    private final Context context;

    @Inject
    public DataSourceFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException(("constructor parameters cannot be null!!!"));
        }
        this.context = context.getApplicationContext();
    }

    public DiskDataSource createDiskDataSource() {
        return new DiskDataSourceImpl(PreferenceHelper.getInstance(context));
    }
}
