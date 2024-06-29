package br.com.emsbackend.exception;

import org.springframework.http.HttpStatus;

public class ManagementAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public ManagementAPIException(HttpStatus httpStatus, String s) {


    }
}
