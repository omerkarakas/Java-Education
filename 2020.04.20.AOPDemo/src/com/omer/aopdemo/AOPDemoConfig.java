package com.omer.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.omer")
@EnableAspectJAutoProxy
public class AOPDemoConfig {

}
