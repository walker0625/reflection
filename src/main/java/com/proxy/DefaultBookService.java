package com.proxy;

public class DefaultBookService implements BookService{
    @Override
    public void rent(Book book) {
        System.out.println(book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        System.out.println(book.getTitle());
    }
}
