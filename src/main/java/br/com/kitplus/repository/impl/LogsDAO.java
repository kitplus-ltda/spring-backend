package br.com.kitplus.repository.impl;


import br.com.kitplus.repository.mapper.LogsRowMapper;
import br.com.kitplus.repository.model.Logs;
import br.com.kitplus.repository.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class LogsDAO implements LogsService {

    @Autowired
    private JdbcTemplate JdbcTemplate;

    public String inrLog(String userName, String apiName) throws Exception {

        try {
            String sql1 = "SELECT COUNT(*) ID FROM LOG_API";
            Integer id = JdbcTemplate.queryForObject(sql1, Integer.class);

            String sql = " INSERT INTO LOG_API (api_name, user_name, local_data, id) values (? ,? , CURRENT_DATE, ? + 1 )";
            JdbcTemplate.update(sql, apiName, userName , id);

            return "Sucess";
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<Logs> getAllLogs() throws Exception {
       try{

          String sql = "select *  from log_api  order by local_data desc;";
           List<Logs>  logs = JdbcTemplate.query(sql, new LogsRowMapper());
          return logs;

       }catch (Exception ex){
           throw new Exception(ex.getMessage());
       }
    }

}
