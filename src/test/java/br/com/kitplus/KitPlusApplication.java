package br.com.kitplus;

import br.com.kitplus.controller.ClientController;
import br.com.kitplus.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class KitPlusApplication {

	@Mock private ClientService clientService;

	@InjectMocks private ClientController maguController;

	@Test
	void contextLoads() {
	}

}
