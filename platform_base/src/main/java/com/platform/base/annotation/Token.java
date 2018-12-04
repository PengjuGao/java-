package com.platform.base.annotation;

/**
 * Created by Administrator on 2017/1/13.
 * 防止重复提交
 */

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
    boolean save() default false;
    boolean remove() default false;
}
