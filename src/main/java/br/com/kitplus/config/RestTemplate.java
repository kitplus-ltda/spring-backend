package br.com.kitplus.config;

import br.com.kitplus.service.ClientServiceKitplus;
import br.com.kitplus.service.impl.ClientServiceKitplusImpl;
import br.com.kitplus.service.impl.cardsServiceImpl;
import br.com.kitplus.service.impl.clientServiceImpl;
import br.com.kitplus.repository.impl.LogsDAO;
import br.com.kitplus.repository.impl.RegisterServiceDAO;
import br.com.kitplus.repository.service.LogsService;
import br.com.kitplus.repository.service.RegisterServices;
import br.com.kitplus.service.CardsService;
import br.com.kitplus.service.ClientService;
import br.com.kitplus.utils.IntegrationUtil;
import com.mercadopago.client.cardtoken.CardTokenClient;
import com.mercadopago.client.customer.CustomerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplate {

    @Bean
    ClientService clientService() {
            return new clientServiceImpl();
    }

    @Bean
    IntegrationUtil integrationUtil(){
        return new IntegrationUtil();
    }

    @Bean
    CustomerClient customerClient() { return new CustomerClient();}

    @Bean
    CardsService cardsService() { return new cardsServiceImpl();}

    @Bean
    CardTokenClient cardTokenClient() { return new CardTokenClient();}

    @Bean
    LogsService logsService() {return  new LogsDAO();}

    @Bean
    RegisterServices registerServices() {return  new RegisterServiceDAO();}

    @Bean
    ClientServiceKitplus registerKitPlusServices() {return  new ClientServiceKitplusImpl();}



}
