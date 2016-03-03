package com.albertgf.cleanbase.domain.interactor;


import com.albertgf.cleanbase.domain.exception.ErrorBundle;

/**
 * Created by albert on 23/02/15.
 */
public interface ExampleUseCase extends Interactor {
    interface Callback {
        void onExampleSuccess();
        void onExampleError(ErrorBundle errorBundle);
    }

    void execute( Callback callback);
}
