package ru.itmo.lab_4.exception.handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itmo.lab_4.exception.DotIncorrectData;
import ru.itmo.lab_4.exception.UserAlreadyExistsException;

@ControllerAdvice
public class DotGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DotIncorrectData> handleException(
            UserAlreadyExistsException exception) {
        DotIncorrectData data = new DotIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
