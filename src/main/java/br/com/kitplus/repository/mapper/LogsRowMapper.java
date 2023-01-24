package br.com.kitplus.repository.mapper;


import br.com.kitplus.repository.model.Logs;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogsRowMapper implements RowMapper<Logs> {
    public Logs mapRow(ResultSet rs, int rowNum) throws SQLException{
        Logs logs = new Logs();
        logs.setId(String.valueOf(rs.getInt("id")));
        logs.setApiName(rs.getString("api_name"));
        logs.setUserName(rs.getString("user_name"));
        logs.setLocalData(rs.getString("local_data"));
        return logs;

    }
}
