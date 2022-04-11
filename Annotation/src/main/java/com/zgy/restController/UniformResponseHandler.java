package com.zgy.restController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class UniformResponseHandler<T> {
    @ResponseStatus(HttpStatus.OK)
    public CallResultMsg sendSuccessResponse() {
        return new CallResultMsg(true, CodeAndMsg.SUCCESS, null);
    }

    @ResponseStatus(HttpStatus.OK)
    public CallResultMsg sendSuccessResponse(T data) {
        return new CallResultMsg(true, CodeAndMsg.SUCCESS, data);
    }

    @ExceptionHandler(UserDefinedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CallResultMsg sendErrorResponse_UserDefined(Exception exception) {
        return new CallResultMsg(false, ((UserDefinedException) exception).getException(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CallResultMsg sendErrorResponse_System(Exception exception) {
        if (exception instanceof UserDefinedException) {
            return this.sendErrorResponse_UserDefined(exception);
        }

        return new CallResultMsg(false, CodeAndMsg.UNKNOWN_EXCEPTION, null);
    }
}
