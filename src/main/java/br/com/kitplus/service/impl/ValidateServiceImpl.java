package br.com.kitplus.service.impl;

import br.com.kitplus.repository.entity.ClientEntity;
import br.com.kitplus.repository.entity.UserRegisterEntityRepository;
import br.com.kitplus.repository.entity.UserSignInEntityRepository;
import br.com.kitplus.repository.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class ValidateServiceImpl implements ValidateService {

    @Autowired
    private UserRegisterEntityRepository userRegisterEntityRepository;

    @Autowired
    private UserSignInEntityRepository userSignInEntityRepository;

    @Override
    public void parametrizeClient(ClientEntity clientEntity) {
        clientEntity.getClientAddress().setUser_id_pk(clientEntity.getClientDetails());
        clientEntity.getUserSign().setUser_id_pk(clientEntity.getClientDetails());
    }

    @Override
    public void validateParamsClient(ClientEntity clientEntity) {
        if (userRegisterEntityRepository.existsByDocumentNumber(clientEntity.getClientDetails().getDocumentNumber()) ||
                userRegisterEntityRepository.existsByEmail(clientEntity.getClientDetails().getEmail())) {
            throw new RuntimeException("USR-0001");
        }
        if (userSignInEntityRepository.existsByEmail(clientEntity.getUserSign().getEmail())) {
            throw new RuntimeException("USR-0002");
        }
        if (userSignInEntityRepository.existsByUser(clientEntity.getUserSign().getUser())) {
            throw new RuntimeException("USR-0002");
        }
        if (clientEntity.getUserSign().getPassword().length() < 8) {
            throw new RuntimeException("USR-0003");
        }
        this.encodePassword(clientEntity);
    }

    private void encodePassword(ClientEntity clientEntity) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");

            m.update(clientEntity.getUserSign().getPassword().getBytes());

            byte[] bytes = m.digest();

            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            clientEntity.getUserSign().setPassword(s.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
