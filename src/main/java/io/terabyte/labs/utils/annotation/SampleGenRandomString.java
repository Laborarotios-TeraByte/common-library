package io.terabyte.labs.utils.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SampleGenRandomString {
    int numberOfElements() default 12;
}
