package com.albertgf.cleanbase.data.repository.datasource;


import com.albertgf.cleanbase.data.util.PreferenceHelper;

/**
 * Created by albert on 03/02/16.
 */
public class DiskDataSourceImpl implements DiskDataSource {

    private final PreferenceHelper preference;

    public DiskDataSourceImpl(PreferenceHelper preference) {
        this.preference = preference;
    }
}
