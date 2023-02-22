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
    private static final Logger logger = LoggerFactory.getLogger(RegisterKTImpl.class);

    @Autowired
    private JdbcTemplate JdbcTemplate;

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRegisterEntityRepository userRegisterEntityRepository;
    @Autowired
    private UserSignInEntityRepository userSignInEntityRepository;


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
            logger.info(ex.getMessage());
            throw new Exception();
        }
    }

    @Override
    public void validateRegister(Client client) {
        this.validateParams(client);
        this.encodePassword(client);
        this.register(client);
    }

    private void register(Client client) {
        try {
            this.entityManager.persist(client);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void encodePassword(Client client) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");

            m.update(client.getUserSign().getPassword().getBytes());

            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            client.getUserSign().setPassword(s.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private void validateParams(Client client) {
        if (userRegisterEntityRepository.existsByDocumentNumber(client.getClientDetails().getDocumentNumber()) ||
                userRegisterEntityRepository.existsByEmail(client.getClientDetails().getEmail())) {
            throw new RuntimeException("USR-0001");
        }
        if (userSignInEntityRepository.existsByEmail(client.getUserSign().getEmail())) {
            throw new RuntimeException("USR-0002");
        }
        if (userSignInEntityRepository.existsByUser(client.getUserSign().getUser())) {
            throw new RuntimeException("USR-0002");
        }
        if(client.getUserSign().getPassword().length() < 8 ){
            throw new RuntimeException("USR-0003");
        }
    }
}
