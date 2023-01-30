package com.reflection;

import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited // 상속하는 클래스에도 적용
public @interface MyAnnotation {

    String name() default "defalut";

    int num() default 100;

    // 쓸때 값의 key를 쓸 필요가 없다
    String value() default "simple";

}
