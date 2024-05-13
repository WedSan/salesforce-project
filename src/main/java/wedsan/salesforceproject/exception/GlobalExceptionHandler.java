package wedsan.salesforceproject.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import wedsan.salesforceproject.dto.response.BasicErrorMessage;
import wedsan.salesforceproject.dto.response.RequestErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RequestErrorResponse> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(createErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<RequestErrorResponse> handleValidationException(ValidationException ex) {
        return ResponseEntity.badRequest()
                .body(createErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<RequestErrorResponse> handleValidationException(RuntimeException ex) {
        return ResponseEntity.badRequest()
                .body(createErrorResponse(ex.getMessage()));
    }

    private RequestErrorResponse createErrorResponse(String errorMessage) {
        BasicErrorMessage basicErrorMessage = new BasicErrorMessage(errorMessage);
        return new RequestErrorResponse(basicErrorMessage);
    }
}
