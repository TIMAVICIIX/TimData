package com.forjakarta.javaee_for_jakarta;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodMapping {

    String value();

}
