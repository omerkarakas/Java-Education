package com.omer.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GetterAspect {
	
	@Pointcut("execution (* get*(..))")
	private void getterPC() {
		
	}
	
	@Pointcut("execution (* *sim(..))")
	private void simPC() {
		
	}
	/*
	private void logmesaj() {
		System.out.println("logluyoruz...");
		
	}
	
	@Before("getterPC()")
	public void logMesaj1() {
		logmesaj();
	}
	
	@Before("getterSoyPC()")
	public void logMesaj2() {
		logmesaj();
	}
	*/
	@Before("getterPC() && simPC()")
	public void logMesaj2() {
		System.out.println("iki pc yakaladık, logluyoruz...");
	}

	@Before("getterPC() || simPC()")
	public void logMesaj3() {
		System.out.println("iki pcden birini yakaladık, logluyoruz...");
	}	
	/*
	@Before("getterPC()")
	public void manageTransaction() {
		System.out.println("manageTransaction...");
	}
	
	@Before("getterSoyPC()")
	public void logToFile() {
		System.out.println("logToFile...");
	}
		
		*/

}
