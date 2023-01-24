package br.com.kitplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class KitPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(KitPlusApplication.class, args);
	}

}
