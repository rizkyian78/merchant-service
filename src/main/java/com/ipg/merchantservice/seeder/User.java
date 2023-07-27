package com.ipg.merchantservice.seeder;

import com.ipg.merchantservice.entity.User;
import com.ipg.merchantservice.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
class UserSeeder {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRepository userRepository;

    public void seedUsersTable() {
        if (userRepository.findFirstByEmail("admin@gmail.com").isEmpty()) {
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setName("admin");
            user.setRealm("admin");
            user.setPhotoUrl("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.giantbomb.com%2Fa%2Fuploads%2Fscale_medium%2F5%2F56742%2F3058593-arthur_portrait.jpg&f=1&nofb=1&ipt=c6ebf79f7f70ab2d3b612fcfffc1421541db15c0fb6ec8f1f329dc334f42691a&ipo=images");
            user.setStatus("active");
            user.setRoles("admin");
            user.setUsername("admin");
            user.setPassword(BCrypt.hashpw("asdasdsad", BCrypt.gensalt()));
            userRepository.save(user);
        } else {
            System.out.println("User Already Exist");
        }
    }
}
