package br.com.kitplus.repository.impl;


import br.com.kitplus.models.ResumeOrderDTO;
import br.com.kitplus.repository.entity.ProductCategoriesEntity;
import br.com.kitplus.repository.entity.ProductEntity;
import br.com.kitplus.repository.entity.UserRegisterEntityRepository;
import br.com.kitplus.repository.mapper.RegistredClientRowMapper;
import br.com.kitplus.repository.mapper.ResumeOrderListRowMapper;
import br.com.kitplus.repository.model.Client;
import br.com.kitplus.repository.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class RegisterKTImpl implements RegisterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterKTImpl.class);

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
            LOGGER.info(ex.getMessage());
            throw new Exception();
        }
    }

    @Override
    public void registerClient(Client client) {
        try {
            this.entityManager.persist(client);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void updateClientId(String idMP, Client client) {
        userRegisterEntityRepository.updateIdPaymentIntegrationByDocumentNumber(
                idMP, client.getClientDetails().getDocumentNumber());
    }

    @Override
    public List<ResumeOrderDTO> getOrderById(String userId) {
        try {
            String sql = "select" +
                    " orde.id_order ," +
                    " orde.cod_rastr_entr ," +
                    " orde.hora_data ," +
                    " orde.quantidade ," +
                    " orde.ref_rastr_entr ," +
                    " ur.user_id ," +
                    " ur.document_number ," +
                    " ur.user_email ," +
                    " ur.name ," +
                    " ur.last_name ," +
                    " ua.city ," +
                    " ua.neighborhood ," +
                    " ua.`number` ," +
                    " ua.state ," +
                    " ua.street ," +
                    " ua.zipcode ," +
                    " tp.nome ," +
                    " tp.descricao ," +
                    " tp.altura ," +
                    " tp.largura ," +
                    " tp.comprimento ," +
                    " tp.preco ," +
                    " tc.name as product_category ," +
                    " usi.`user`  " +
                    " from" +
                    " user_register ur ," +
                    " user_sign_in usi ," +
                    " user_address ua ," +
                    " tbl_product tp ," +
                    " tbl_categories tc ," +
                    " tbl_order orde " +
                    " where " +
                    " orde.product_id = tp.product_id" +
                    " and orde.user_sign_in = usi.user_sign_id" +
                    " and orde.address_id = ua.address_id" +
                    " and tc.category_id = tp.category_id ;";

            List<ResumeOrderDTO> resumerOrder = this.JdbcTemplate.query(sql, new ResumeOrderListRowMapper());
            return resumerOrder;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void registerProduct(ProductEntity product) {
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("PRD-0005");

        }
    }

    @Override
    public List<ProductCategoriesEntity> getAllProductCategories() {
        try {

            Query sql = entityManager.createQuery(
                    "SELECT c FROM ProductCategoriesEntity c");
            List<ProductCategoriesEntity> catergories = sql.getResultList();
            return catergories;

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("PRD-0005");
        }
    }

    @Override
    @Transactional
    public void createProductCategoty(ProductCategoriesEntity category) {
        try {
            this.entityManager.persist(category);
        } catch (Exception e) {
            LOGGER.error("Falha ao criar categoria");
            throw new RuntimeException("PRD-0005");
        }
    }
}
