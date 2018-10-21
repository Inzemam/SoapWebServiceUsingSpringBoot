package com.inze.soapWebService.SoapSpringBoot.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs


@Configuration

public class WebServiceConfig {


	//messageDispatcherservlet
	//applicaitoncontext
	//url -> /ws/*

	@Bean
	ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {

		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");
	}

	///ws/courses.wsdl
	//PortType = COusePort
	//Namespace
	//course-details.xsd
	@Bean(name="courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		///ws/courses.wsdl
		//PortType = COusePort
		//Namespace
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://inzemamwebsite/courses");
		definition.setLocationUri("/ws");
		definition.setSchema(coursesSchema);

		return definition;
	}


	@Bean
	XsdSchema coursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}

}
