package com.inze.soapWebService.SoapSpringBoot.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import inzemamwebsite.courses.CourseDetails;
import inzemamwebsite.courses.GetCourseDetailsRequest;
import inzemamwebsite.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndpoint {

	//method
	//input -req object GetCOurseDetailsRequest
	// resp object



	@PayloadRoot(namespace="http://inzemamwebsite/courses",localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {

		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("first course object");
		courseDetails.setDescription("thsi is description of first course object");
		response.setCourseDetails(courseDetails);

		return response;
	}

}
