package com.reflection;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void reflectionTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("com.reflection.Book");
        Constructor<?> constructor = bookClass.getConstructor(null); // 기본 생성자
        Book book = (Book) constructor.newInstance();

        System.out.println(book);

        Field b = Book.class.getDeclaredField("b");
        System.out.println(b.get(null));
        b.set(null, "changedBook");
        System.out.println(b.get(null));

        Method f = Book.class.getDeclaredMethod("f");
        f.setAccessible(true);
        f.invoke(book);
    }

}
