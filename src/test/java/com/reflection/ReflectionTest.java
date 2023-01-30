package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> bookClass = Class.forName("com.reflection.Book");
        Constructor<?> constructor = bookClass.getConstructor(null);
        Book book = (Book) constructor.newInstance("test");

        System.out.println(book);
    }

}
