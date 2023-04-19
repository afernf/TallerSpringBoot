package com.bootcamp.demo.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest req) {
		String bodyOfResponse = "This should be application specific";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, req);
	}
	
	private class JsonResponse {
        private String type;
        private String title;
        private int status;
        private String detail;


        public JsonResponse() {
        	this.setType("");
        	this.setTitle("Unexpected error");
        	this.setStatus(400);
        	this.setDetail("An unexpected error ocurred");
        }


		public String getDetail() {
			return detail;
		}


		public void setDetail(String detail) {
			this.detail = detail;
		}


		public int getStatus() {
			return status;
		}


		public void setStatus(int status) {
			this.status = status;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}

     
    }
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<JsonResponse> handleException(Exception ex) {
		JsonResponse error = new JsonResponse();
		error.setType(ex.getClass().toString());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
