package com.ahouzi.msbanque;

import com.ahouzi.msbanque.entities.Client;
import com.ahouzi.msbanque.entities.Compte;
import com.ahouzi.msbanque.entities.TypeCompte;
import com.ahouzi.msbanque.repositories.ClientRepository;
import com.ahouzi.msbanque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository, RepositoryRestConfiguration restConfiguration, ClientRepository clientRepository){
        return args-> {
            restConfiguration.exposeIdsFor(Compte.class);
            Client c1=clientRepository.save(new Client(null,"MOHAMED",null));
            Client c2=clientRepository.save(new Client(null,"CRISTIANO",null));

            compteRepository.save(new Compte(null, Math.random() * 8000, new Date(), TypeCompte.COURANT,c2));
            compteRepository.save(new Compte(null,Math.random()*8000,new Date(), TypeCompte.EPARGNE,c1));
            compteRepository.save(new Compte(null,Math.random()*8000,new Date(), TypeCompte.COURANT,c2));
//            compteRepository.findAll().forEach(c ->
//                System.out.println(c.toString())
//            );
        };
    }
}
