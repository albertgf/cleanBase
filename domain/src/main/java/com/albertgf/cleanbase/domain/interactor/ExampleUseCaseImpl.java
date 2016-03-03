package com.albertgf.cleanbase.domain.interactor;


import com.albertgf.cleanbase.domain.exception.ErrorBundle;
import com.albertgf.cleanbase.domain.executor.PostExecutionThread;
import com.albertgf.cleanbase.domain.executor.ThreadExecutor;
import com.albertgf.cleanbase.domain.repository.ExampleRepository;
import com.albertgf.cleanbase.domain.repository.callback.ExampleCallback;

import javax.inject.Inject;

/**
 * Created by albert on 23/02/15.
 */
public class ExampleUseCaseImpl implements ExampleUseCase {
    private final ExampleRepository repository;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    private Callback callback;

    @Inject
    public ExampleUseCaseImpl(ExampleRepository repository, ThreadExecutor executor, PostExecutionThread postExecution) {
        this.repository = repository;
        this.threadExecutor = executor;
        this.postExecutionThread = postExecution;
    }

    private final ExampleCallback.BaseCallback repositoryCallback =
            new ExampleCallback.BaseCallback() {

                @Override public void onSuccess() {
                    notifyAccessSuccessfully();
                }

                @Override public void onError(ErrorBundle errorBundle) {
                    notifyError(errorBundle);
                }
            };

    private void notifyAccessSuccessfully() {
        this.postExecutionThread.post(new Runnable() {
            @Override public void run() {
                callback.onExampleSuccess();
            }
        });
    }

    private void notifyError(final ErrorBundle errorBundle) {
        this.postExecutionThread.post(new Runnable() {
            @Override public void run() {
                callback.onExampleError(errorBundle);
            }
        });
    }

    @Override
    public void execute(Callback callback) {
        if ( callback == null) {
            throw new IllegalArgumentException("Invalid parameter!!");
        }
        this.callback = callback;
        this.threadExecutor.execute(this);
    }

    @Override public void run() {
        this.repository.baseCall();
    }
}
