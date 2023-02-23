package br.com.kitplus.repository.impl;


import br.com.kitplus.repository.entity.UserRegisterEntityRepository;
import br.com.kitplus.repository.entity.UserSignInEntityRepository;
import br.com.kitplus.repository.mapper.RegistredClientRowMapper;
import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Repository
public class RegisterKTImpl implements RegisterService {
    private static final Logger LOGGER  = LoggerFactory.getLogger(RegisterKTImpl.class);

    @Autowired
    private JdbcTemplate JdbcTemplate;

    @Autowired
    private EntityManager entityManager;


    @Override
    public Client getClientDetails(Integer userId) throws Exception {
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

            Client clientRegister = JdbcTemplate.queryForObject(sql, new RegistredClientRowMapper(), userId);
            return clientRegister;

        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            throw new Exception();
        }
    }

    @Override
    public void register(Client client) {
        try {
            this.entityManager.persist(client);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

}
