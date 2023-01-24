package br.com.kitplus.Api;

import br.com.kitplus.models.Clients.ClientResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("*")
@Api(value = "Get Client Informations")
@RequestMapping(value = "/client")

public interface ClientsApi {

    Logger log = LoggerFactory.getLogger(ClientsApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }


    @ApiOperation(value = "",
            nickname = "Clients",
            notes = "This service get Clients Information",
            response = ClientResponseDTO.class,
            authorizations = {@Authorization(value = "basicAuth")},
            tags = {"Clients"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = String.class),
            @ApiResponse(code = 400, message = "Bad request", response = Error.class),
            @ApiResponse(code = 404, message = "Not found", response = Error.class),
            @ApiResponse(code = 500, message = "Internal error", response = Error.class)})
    @RequestMapping(value = "/client",
            produces = {"application/json"},
            method = RequestMethod.GET)
    default ResponseEntity<ClientResponseDTO> getClientbyEmailMP (
            @Valid @RequestHeader(value = "email", required = true) String email) throws MPException, MPApiException  {

        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default EventsVcrApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}