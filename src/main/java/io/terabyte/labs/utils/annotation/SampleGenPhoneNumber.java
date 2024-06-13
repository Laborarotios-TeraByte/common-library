package io.terabyte.labs.utils.annotation;

import io.terabyte.labs.utils.model.TelephoneType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SampleGenPhoneNumber {
    TelephoneType type() default TelephoneType.PHONE;
}
