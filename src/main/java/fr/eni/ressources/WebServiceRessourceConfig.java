package fr.eni.ressources;

import org.glassfish.jersey.server.ResourceConfig;

public class WebServiceRessourceConfig extends ResourceConfig {
	
	public WebServiceRessourceConfig() {
        packages("fr.eni.ressources");
    }
}
