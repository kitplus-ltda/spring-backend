package br.com.kitplus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.mercadopago.MercadoPagoConfig;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MPConfig {
    
    public  void setAcessToken() {
        MercadoPagoConfig.setAccessToken("APP_USR-1111532151519208-112707-05743fe6362eb4574afd0553c311945e-248275892");
    }
}
