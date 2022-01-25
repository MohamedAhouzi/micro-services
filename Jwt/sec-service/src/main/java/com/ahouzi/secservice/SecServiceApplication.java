package com.ahouzi.secservice;

import com.ahouzi.secservice.entities.AppRole;
import com.ahouzi.secservice.entities.AppUser;
import com.ahouzi.secservice.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecServiceApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(AccountService accountService){
        return args -> {
          accountService.addNewRole(new AppRole(null,"USER"));
            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"COSTUMER-MANAGER"));
            accountService.addNewRole(new AppRole(null,"PRODUCT-MANAGER"));
            accountService.addNewRole(new AppRole(null,"BILLS-MANAGER"));

            accountService.addNewUser(new AppUser(null,"user1","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"admin","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user2","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user3","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user4","12345",new ArrayList<>()));

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("user2","USER");
            accountService.addRoleToUser("user2","COSTUMER-MANAGER");
            accountService.addRoleToUser("user3","USER");
            accountService.addRoleToUser("user3","PRODUCT-MANAGER");
            accountService.addRoleToUser("user4","USER");
            accountService.addRoleToUser("user4","BILLS-MANAGER");

            accountService.loadUserByUsername("user1");

            accountService.listUsers().forEach(appUser -> System.out.println(appUser.getUsername()));




        };
    }
}
