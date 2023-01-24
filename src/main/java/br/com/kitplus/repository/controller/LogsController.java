package br.com.kitplus.repository.controller;

import br.com.kitplus.Api.LogsApi;
import br.com.kitplus.repository.service.LogsService;
import br.com.kitplus.repository.model.Logs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/magu")
public class LogsController implements LogsApi {

    @Autowired
    LogsService logsService;

    @PostMapping("/logs")
    public ResponseEntity<HttpStatus> inputLog(@RequestParam String userName, @RequestParam String apiName) throws Exception {
        logsService.inrLog(userName,apiName );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/logs")
    public ResponseEntity<List<Logs>> getLogs() throws Exception {
        List<Logs> logs = logsService.getAllLogs();
       return new ResponseEntity<>(logs,HttpStatus.OK);
    }

}
