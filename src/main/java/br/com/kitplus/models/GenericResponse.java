package br.com.kitplus.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse <T> {
    private int code;
    private T body;

}
