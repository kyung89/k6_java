package com.ruby.java.ch13.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str() default "guest";
	int val() default 1004;
}


public class AnnoTest4 {

	@MyAnno
	public static void test() {
		AnnoTest4 obj = new AnnoTest4();
		try {
			Class<?> c = obj.getClass();
			Method m = c.getMethod("test");
			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println(anno.str() + " : " + anno.val());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test();
	}
}
