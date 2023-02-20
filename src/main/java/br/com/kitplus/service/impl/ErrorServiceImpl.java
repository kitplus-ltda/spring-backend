package br.com.kitplus.service.impl;

import br.com.kitplus.repository.entity.ErrorEntity;
import br.com.kitplus.repository.entity.ErrorEntityRepository;
import br.com.kitplus.repository.service.ErrorService;
import org.springframework.stereotype.Service;

@Service
public class ErrorServiceImpl implements ErrorService {
    private final ErrorEntityRepository errorEntityRepository;

    public ErrorServiceImpl(ErrorEntityRepository errorEntityRepository) {
        this.errorEntityRepository = errorEntityRepository;
    }

    @Override
    public String searchByErrorCode(String code) {
        ErrorEntity error = errorEntityRepository.findByErro(code);
        return error.getDescricao();
    }
}
