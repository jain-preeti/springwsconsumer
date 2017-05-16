package com.concretepage;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.security.wss4j.Wss4jSecurityInterceptor;

import com.concretepage.wsdl.GetStudentRequest;
import com.concretepage.wsdl.GetStudentResponse;

public class StudentClient extends WebServiceGatewaySupport  {
	public GetStudentResponse getStudentById(int studentId) {
		GetStudentRequest request = new GetStudentRequest();
		request.setStudentId(studentId);
		GetStudentResponse response = (GetStudentResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/spring4soap/soapws/getStudentResponse"));
		
		System.out.println(response.getStudent().getAge());
		//GetStudentResponse response1 = (GetStudentResponse) getWebServiceTemplate().marshalSendAndReceive(request);
		
		
		return response;
	}
	
	
	
	


}
