package br.com.kitplus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mercadopago.MercadoPagoConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
public class MPConfig implements IMPConfig {

    @Value("${access.token}")
    private String token;

    @Override
    @Bean
    public  void setAcessToken() {
        MercadoPagoConfig.setAccessToken(token);
    }
}
