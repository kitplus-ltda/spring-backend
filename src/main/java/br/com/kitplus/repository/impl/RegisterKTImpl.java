package br.com.kitplus.repository.impl;


import br.com.kitplus.repository.entity.UserRegisterEntity;
import br.com.kitplus.repository.entity.UserRegisterEntityRepository;
import br.com.kitplus.repository.mapper.RegistredClientRowMapper;
import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.RegisterServices;
import com.google.inject.internal.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.validation.ConstraintDeclarationException;


@Repository
public class RegisterKTImpl implements RegisterServices {
    private static final Logger logger = LoggerFactory.getLogger(RegisterKTImpl.class);

    @Autowired
    private JdbcTemplate JdbcTemplate;

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRegisterEntityRepository userRegisterEntityRepository;


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
    public void register(Client client) {
        try {
            this.entityManager.persist(client.getClientDetails());
            client.getClientAddress().setUser_id_pk(client.getClientDetails());
            this.entityManager.persist(client.getClientAddress());
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public boolean validateRegister(Client client) {
        UserRegisterEntity document =
                userRegisterEntityRepository
                        .findByDocumentNumberLike(client.getClientDetails().getDocumentNumber());
        UserRegisterEntity email =
                userRegisterEntityRepository.findByEmail(client.getClientDetails().getEmail());
        return Objects.equal(document, null) && Objects.equal(email, null);
    }

}
