package br.com.fiap.smartcities.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class ServicesConfig extends ResourceConfig {
	
	public ServicesConfig() {
		packages("br.com.fiap.smartcities.service");
		register(RolesAllowedDynamicFeature.class);
	}
}
