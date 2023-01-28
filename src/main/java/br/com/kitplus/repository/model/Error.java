package br.com.kitplus.repository.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@ApiModel
@Getter
@Setter
@NoArgsConstructor
public class Error {
    @ApiModelProperty("errorInfo")
    String errorInfo = null;
}

