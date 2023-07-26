package com.ipg.merchantservice.seeder;

import com.ipg.merchantservice.entity.User;
import com.ipg.merchantservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
class UserSeeder {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRepository userRepository;
    @EventListener
    public void seed(ContextRefreshedEvent event) {

        seedUsersTable();

    }

    private void seedUsersTable() {
        Boolean checkUser = userRepository.findFirstByName("admin").isEmpty();
        if (checkUser) {
            User user = new User();
            user.setEmail("rizkyian78@gmail.com");

            userRepository.save(user);
        } else {
            System.out.println("User Already Exist");
        }
    }
}
