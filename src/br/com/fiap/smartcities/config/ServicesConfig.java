package br.com.fiap.smartcities.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ServicesConfig extends ResourceConfig {
	
	public ServicesConfig() {
		packages("br.com.fiap.smartcities.service");
	}
}
