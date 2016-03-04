package com.albertgf.cleanbase.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by albert on 17/04/15.
 */
@Scope
@Retention (RUNTIME)
public @interface PerActivity {}
