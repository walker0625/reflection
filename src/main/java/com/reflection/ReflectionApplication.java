package com.reflection;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@SpringBootApplication
public class ReflectionApplication {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<Book> bookClass = Book.class;

		Book book = new Book();
		Class<? extends Book> aClass = book.getClass();

		Class<?> aClass1 = Class.forName("com.reflection.Book");
		/////////////// 위는 클래스의 정보를 알아오는 3가지 방법

		// public 필드의 정보 출력
		Arrays.stream(bookClass.getFields()).forEach(System.out::println);

		// 가지고 있는 모든 필드 정보 출력
		Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

		// 필드의 실제 값 출력
		Arrays.stream(aClass.getDeclaredFields()).forEach(f -> {
			try {
				f.setAccessible(true); // public 외의 필드에도 접근 가능
				System.out.println(f.get(book));
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		});

		// 클래스가 가진 메소드 목록(object에서 상속 받은 것도 포함)
		Arrays.stream(aClass.getMethods()).forEach(System.out::println);

		// 생성자 목록
		Arrays.stream(aClass.getConstructors()).forEach(System.out::println);

		// 부모 클래스
		System.out.println(MyBook.class.getSuperclass());

		// 인터페이스
		System.out.println(MyBook.class.getInterfaces());

		Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
			int modifiers = f.getModifiers();
			System.out.println(f);
			System.out.println(Modifier.isPublic(modifiers));
			System.out.println(Modifier.isPrivate(modifiers));
			System.out.println(Modifier.isStatic(modifiers));
		});

		System.out.println(MyBook.class.getAnnotations());
		System.out.println(MyBook.class.getDeclaredAnnotations());
	}

}
