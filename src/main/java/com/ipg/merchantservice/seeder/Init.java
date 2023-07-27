package com.ipg.merchantservice.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Init {

    @Autowired
    private UserSeeder userSeeder;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        userSeeder.seedUsersTable();
    }
}
