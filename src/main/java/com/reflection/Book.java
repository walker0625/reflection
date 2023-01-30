package com.reflection;

@MyAnnotation("value")
public class Book {

    @MyAnnotation("value")
    private String a = "a";
    public static  String b = "book";
    private static final String c = "book";
    @MyAnnotation("value")
    public String d = "d";
    protected String e = "e";

    public Book() {}

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("f");
    }

    private void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }

}
