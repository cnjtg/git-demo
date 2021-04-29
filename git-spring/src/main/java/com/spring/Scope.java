package com.spring;

/**
 * @author cnjtg
 * @version 1.0
 * @className Scope
 * @date 2021-04-29 16:27
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Scope {

    String value();
}

