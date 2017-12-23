package com.centili.rest.core.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionHandler implements ExceptionMapper<Throwable> {

    public class ApplicationExceptionInfo {
	
	private String _message;

	public String getMessage() {
	    return _message;
	}

	public void setMessage(String message) {
	    _message = message;
	}
	
    }
    
    @Override
    public Response toResponse(Throwable exception) {
	
	ApplicationExceptionInfo info = new ApplicationExceptionInfo();
	info.setMessage(exception.getMessage());
	
	return Response.serverError().entity(info)
		.type(MediaType.APPLICATION_JSON)
		.build();
    }

}