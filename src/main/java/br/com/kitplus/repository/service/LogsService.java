package br.com.kitplus.repository.service;

import br.com.kitplus.repository.model.Logs;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;


@Configurable
public interface LogsService {

    String inrLog(String user, String api ) throws Exception;

    List<Logs> getAllLogs () throws Exception;


}
