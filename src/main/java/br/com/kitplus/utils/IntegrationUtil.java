package br.com.kitplus.utils;

import br.com.kitplus.models.GenericResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class IntegrationUtil {

    public <T>ResponseEntity<T> getRestCall(String curl, String Method, String Body, TypeReference<T> referenceType, String token) throws IOException, ErrorsException {
        URL url = new URL(curl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String > mapHeaders = headers.toSingleValueMap();

        StringBuilder responseBuffer = new StringBuilder();
        connection.setRequestMethod(Method);
        connection.setDoOutput( true );
        connection.setDoInput(true);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Token",  token);
        for(Map.Entry<String, String> entry: mapHeaders.entrySet()){
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }

        GenericResponse<String> response = new GenericResponse<>();

        if(Body != null) {
            try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write(Body.getBytes(StandardCharsets.UTF_8));
            }
        }

        response.setCode(connection.getResponseCode());

        try (
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader input = new BufferedReader(inputReader)
        ){
                    String inputLine = input.readLine();
                    while(inputLine != null){
                        responseBuffer.append(inputLine);
                        inputLine = input.readLine();
                    }

                     response.setBody(responseBuffer.toString());
        }
        if(response.getCode() == HttpURLConnection.HTTP_OK){
            return ResponseEntity.ok(new ObjectMapper().readValue(response.getBody(), referenceType));
        }
        throw new ErrorsException(new Errors());
    }
}
