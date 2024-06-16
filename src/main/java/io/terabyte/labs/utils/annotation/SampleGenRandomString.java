package io.terabyte.labs.utils.annotation;


import io.terabyte.labs.utils.model.StringTypeFaker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SampleGenRandomString {
    StringTypeFaker typeFakerGenerator() default StringTypeFaker.RANDOM;
    int numberOfElements() default 5;
}
