package ygorgarofalo.SpringU2W2Project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestExc.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsBody handleBadRequest(BadRequestExc ex) {
        return new ErrorsBody(ex.getMessage());
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundExc.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsBody handleNotFoundExc(NotFoundExc ex) {
        return new ErrorsBody(ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsBody handleGenericError(Exception ex) {
        ex.printStackTrace();
        return new ErrorsBody("Problema lato server.");
    }
}

