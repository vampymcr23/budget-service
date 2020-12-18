package com.gina.budget;

import com.gina.budget.rest.DebugRESTService;
import com.gina.budget.rest.TransactionRESTSErvice;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(TransactionRESTSErvice.class);
        register(DebugRESTService.class);
    }
}
