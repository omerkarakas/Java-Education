package com.omer.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.omer.aopdemo.domain.Student;

@Aspect
@Component
public class InsertAspect {

	@Before("execution(* add*(*))")
	public void beforeInsertStudentAdvice() {
		System.out.println("beforeInsertStudentAdvice called");
	}
	
}

/*

Yeni bir aspect ile tüm getter''ları loglayalım

Container'a bir Student nesnesi oluşturtup, nesneyi alıp, bir iki get çağrısı yapalım.
Hem get'e hem de advice'a log yazdıralım.
*/