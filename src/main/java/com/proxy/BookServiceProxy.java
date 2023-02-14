package com.proxy;

public class BookServiceProxy implements BookService{

    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("before");
        bookService.rent(book);
        System.out.println("after");
    }

    @Override
    public void returnBook(Book book) {
        bookService.rent(book);
    }

}
