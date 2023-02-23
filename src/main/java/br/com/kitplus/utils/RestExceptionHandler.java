package br.com.kitplus.utils;

import br.com.kitplus.repository.service.ErrorService;
import com.mercadopago.exceptions.MPApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ErrorService errorService;


    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new ErrorsStack(HttpStatus.BAD_REQUEST, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorsStack apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleEntityNotFound(RuntimeException ex) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ErrorsStack apiError = new ErrorsStack(BAD_REQUEST);
        apiError.setTimestamp(localDateTime);
        String msg = errorService.searchByErrorCode(ex.getMessage());
        apiError.setMessage(msg);
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(MPApiException.class)
    protected ResponseEntity<Object> handleMPException(MPApiException ex) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ErrorsStack apiError = new ErrorsStack(BAD_REQUEST);
        apiError.setTimestamp(localDateTime);
        apiError.setMessage(ex.getApiResponse().getContent());
        return buildResponseEntity(apiError);
    }
}

