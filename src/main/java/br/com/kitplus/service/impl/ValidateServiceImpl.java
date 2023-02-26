package br.com.kitplus.service.impl;

import br.com.kitplus.repository.entity.UserRegisterEntityRepository;
import br.com.kitplus.repository.entity.UserSignInEntityRepository;
import br.com.kitplus.repository.entity.Client;
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
    public void parametrizeClient(Client client) {
        client.getClientAddress().setUser_id_pk(client.getClientDetails());
        client.getUserSign().setUser_id_pk(client.getClientDetails());
    }

    @Override
    public void validateParamsClient(Client client) {
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
        if (client.getUserSign().getPassword().length() < 8) {
            throw new RuntimeException("USR-0003");
        }
        this.encodePassword(client);
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
}
