package com.ruby.java.ch13.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Service {
}

@Service
public class AnnoTest3 {

	public static void main(String[] args) {
		
		AnnoTest3 obj = new AnnoTest3();
		
		try {
			Class<?> c = obj.getClass();
			if(c.isAnnotationPresent(Service.class)) System.out.println("Service 어노테이션을 지정함");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
