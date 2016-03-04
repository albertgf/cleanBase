package com.albertgf.cleanbase.data.repository;

import com.albertgf.cleanbase.data.repository.datasource.DataSourceFactory;
import com.albertgf.cleanbase.domain.repository.ExampleRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by albert on 23/02/15.
 */
@Singleton
public class ExampleDataRepository implements ExampleRepository {

    private final DataSourceFactory dataSource;

    @Inject
    protected ExampleDataRepository(DataSourceFactory dataStore) {
        if (dataStore == null) {
            throw new IllegalArgumentException("Invalid null parameters in constructor!!!");
        }

        this.dataSource = dataStore;
    }

    @Override public void baseCall() {

    }
}
