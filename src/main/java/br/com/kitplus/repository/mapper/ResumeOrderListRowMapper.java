package br.com.kitplus.repository.mapper;


import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.repository.model.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ResumeOrderListRowMapper implements RowMapper<ResumeOrderDTO> {
    public ResumeOrderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

        ResumeOrderDTO resume = new ResumeOrderDTO();
        resume.setOrderId(String.valueOf(rs.getInt("id_order")));
        resume.setOrderDate(rs.getString("hora_data"));
        resume.setUser(rs.getString("user"));
        return resume;

    }
}
