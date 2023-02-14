package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("proxy");

        BookService bookService = new BookServiceProxy(new DefaultBookService());

        bookService.rent(book);

        System.out.println("-----------------");

        // BookServiceProxy를 대체
        BookService dynamicProxyBookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
                new InvocationHandler() {

                    DefaultBookService bookService = new DefaultBookService();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if(method.getName().equals("rent")) {
                            System.out.println("b");
                            Object invoke = method.invoke(bookService, args);
                            System.out.println("a");
                            return invoke;
                        }

                        return method.invoke(bookService, args);
                    }
                });

        dynamicProxyBookService.rent(book);
        dynamicProxyBookService.returnBook(book);

    }

}
