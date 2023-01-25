package br.com.kitplus;

import com.mercadopago.MercadoPagoConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KitPlusApplication {

	public static void main(String[] args) {
		MercadoPagoConfig.setAccessToken("APP_USR-1111532151519208-112707-05743fe6362eb4574afd0553c311945e-248275892");
		SpringApplication.run(KitPlusApplication.class, args);
	}

}
