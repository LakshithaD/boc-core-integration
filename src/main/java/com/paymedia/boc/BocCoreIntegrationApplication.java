package com.paymedia.boc;

import com.paymedia.boc.integration.XmlLib;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class BocCoreIntegrationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BocCoreIntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
