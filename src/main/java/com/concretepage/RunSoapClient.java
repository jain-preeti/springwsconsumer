package com.concretepage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;

import com.concretepage.wsdl.GetStudentResponse;

public class RunSoapClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	    ctx.register(ClientAppConfig.class);
	    ctx.refresh();
		StudentClient studentClient = ctx.getBean(StudentClient.class);
		System.out.println("For Student Id: 1");
		GetStudentResponse response = studentClient.getStudentById(1);
		System.out.println("Name:"+response.getStudent().getName());
		System.out.println("Age:"+response.getStudent().getAge());
		System.out.println("Class:"+response.getStudent().getClazz());
	}
	
	
	
	
}
