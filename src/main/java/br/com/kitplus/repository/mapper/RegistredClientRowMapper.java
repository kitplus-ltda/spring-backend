package br.com.kitplus.repository.mapper;


import br.com.kitplus.repository.entity.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistredClientRowMapper implements RowMapper<Client> {
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {

       Client clientRegister = new Client();
//        ClientDetails clientDetails = new ClientDetails();
//        ClientAddress clientAddress = new ClientAddress();
//        ClientDocuments clientDocuments = new ClientDocuments();
//
//        clientDetails.setId(Integer.valueOf(String.valueOf(rs.getInt("id"))));
//        clientDetails.setName(rs.getString("name"));
//        clientDetails.setEmail(rs.getString("email"));
//        clientDetails.setLastName(rs.getString("last_name"));
//        clientDetails.setBirthDate(rs.getDate("birth_date"));
//        clientDetails.setUser(rs.getString("users"));
//        clientAddress.setStreet(rs.getString("street"));
//        clientAddress.setCity(rs.getString("city"));
//        clientAddress.setState(rs.getString("state"));
//        clientAddress.setNeighborhood(rs.getString("neighborhood"));
//        clientAddress.setZipCode(rs.getString("zipcode"));
//        clientAddress.setNumber(rs.getInt("number"));
//        clientDocuments.setDocumentNumber(rs.getString("document_number"));
//        clientDocuments.setDocumentType(rs.getString("document_type"));
//
//        clientDetails.setClientDocuments(clientDocuments);
//        clientRegister.setClientAddress(clientAddress);
//        clientRegister.setClientDetails(clientDetails);

        return clientRegister;

    }
}
