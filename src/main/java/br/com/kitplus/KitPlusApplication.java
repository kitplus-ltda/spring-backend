package br.com.kitplus;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import br.com.kitplus.config.MPConfig;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KitPlusApplication {

	

	public static void main(String[] args) {
		MPConfig mpConfig = new MPConfig();
		mpConfig.setAcessToken();	 
		SpringApplication.run(KitPlusApplication.class, args);
	}

}
