package br.com.kitplus.repository.impl;


import br.com.kitplus.repository.mapper.RegistredClientRowMapper;
import br.com.kitplus.repository.model.ClientRegister;
import br.com.kitplus.repository.service.RegisterServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class RegisterServiceDAO  implements RegisterServices {
    private static final Logger logger = LoggerFactory.getLogger(RegisterServiceDAO.class);

    @Autowired
    private JdbcTemplate JdbcTemplate;


    @Override
    public ClientRegister getClientDetails(Integer userId) throws Exception {
        try {

            String sql = " select" +
                    " sig.id ," +
                    " adr.street ," +
                    " adr.neighborhood ," +
                    " adr.city ," +
                    " adr.state ," +
                    " adr.zipcode ," +
                    " adr.\"number\" ," +
                    " reg.\"name\" ," +
                    " reg.last_name ," +
                    " reg.document_type ," +
                    " reg.document_number ," +
                    " reg.birth_date ," +
                    " sig.email ," +
                    " sig.\"users\" " +
                    " from" +
                    " user_address adr ," +
                    " user_register reg ," +
                    " user_sign_in sig" +
                    " where reg.id_user_sign_in_register = sig.id" +
                    " and adr.id_user_sign_in_address = sig.id" +
                    " and adr.id_user_sign_in_address = reg.id_user_sign_in_register" +
                    " and sig.id = ? ;";

            ClientRegister clientRegister = JdbcTemplate.queryForObject(sql, new RegistredClientRowMapper(), userId);
            return clientRegister;

        } catch (Exception ex) {
            logger.info(ex.getMessage());
            throw new Exception();
        }
    }
    public ClientRegister postCreateUser(ClientRegister clientRegister) throws Exception {
        try {
            JdbcTemplate.update("BEGIN");

            String sql = "INSERT INTO user_sign_in (\"password\", users, email) " +
                    "VALUES(? , ? , ? ); ";
            JdbcTemplate.update(sql,
                    clientRegister.getClientDetails().getPassword(),
                    clientRegister.getClientDetails().getUser(),
                    clientRegister.getClientDetails().getEmail());

            String sql2 = " INSERT INTO user_register ( name, last_name, document_type, document_number,  birth_date, id_user_sign_in_register ) " +
                    "VALUES( ? , ? , ? , ? , ?, (select id from user_sign_in order by id desc limit 1) ); ";
            JdbcTemplate.update(sql2,
                    clientRegister.getClientDetails().getName(),
                    clientRegister.getClientDetails().getLastName(),
                    clientRegister.getClientDetails().getClientDocuments().getDocumentType(),
                    clientRegister.getClientDetails().getClientDocuments().getDocumentNumber(),
                    clientRegister.getClientDetails().getBirthDate()
            );

            String sql3 = " INSERT INTO user_address (street, neighborhood, city, state, zipcode, \"number\", id_user_sign_in_address ) " +
                    "VALUES( ?, ?, ?, ?, ?, ? , (select id from user_sign_in order by id desc limit 1));";
            JdbcTemplate.update(sql3,
                    clientRegister.getClientAddress().getStreet(),
                    clientRegister.getClientAddress().getNeighborhood(),
                    clientRegister.getClientAddress().getCity(),
                    clientRegister.getClientAddress().getState(),
                    clientRegister.getClientAddress().getZipCode(),
                    clientRegister.getClientAddress().getNumber()
            );
            clientRegister.getClientDetails().setId(
                    JdbcTemplate.queryForObject("select id from user_sign_in order by id desc limit 1;", Integer.class));
            JdbcTemplate.update("COMMIT;");

            return  clientRegister;

        } catch (Exception ex) {
            JdbcTemplate.update("ROLLBACK");

            ClientRegister clientRegisterError = new ClientRegister(clientRegister);
            clientRegisterError.setErrorInfo(ex.getMessage());

            return clientRegisterError;
        }
    }
}
