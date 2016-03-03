package com.albertgf.cleanbase.domain.repository.callback;

import com.albertgf.cleanbase.domain.exception.ErrorBundle;

/**
 * Created by albert on 03/03/16.
 */
public interface ExampleCallback {
    interface BaseCallback {
        void onSuccess();

        void onError(ErrorBundle errorBundle);
    }
}
