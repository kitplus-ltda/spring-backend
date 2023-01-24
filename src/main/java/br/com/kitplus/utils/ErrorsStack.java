package br.com.kitplus.utils;

import org.springframework.http.HttpStatus;

public class ErrorsStack {
    public HttpStatus errorStatusTratement(String error) {
        if (error != null && !error.isBlank()) {
            return HttpStatus.BAD_REQUEST;
        } else return HttpStatus.OK;
    }

    public String errorStackTratement(String error) {
        if (error != null && error.contains("already exists")) {
            return "Usuário/Email já existem";
        } else return null;
    }
}
