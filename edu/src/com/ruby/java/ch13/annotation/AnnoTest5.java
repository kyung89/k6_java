package com.ruby.java.ch13.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Bean {
	String value();
}

@Bean("Member")
public class AnnoTest5 {

	public static void main(String[] args) {
		AnnoTest5 obj = new AnnoTest5();
		try {
			Class<?> c = obj.getClass();
			Bean b = c.getAnnotation(Bean.class);
			System.out.println(b.value());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
