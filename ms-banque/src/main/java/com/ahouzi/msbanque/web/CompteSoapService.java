package com.ahouzi.msbanque.web;

import com.ahouzi.msbanque.entities.Compte;
import com.ahouzi.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@WebService(name = "BanqueWs")
public class CompteSoapService {
    @Autowired
    private  CompteRepository compteRepository;

     // public CompteSoapService(CompteRepository compteRepository) {
     //        this.compteRepository = compteRepository;
     //    }
    @WebMethod
    public List<Compte> compteList(){
    return compteRepository.findAll();
    }

   @WebMethod
    public Compte getCompte(@WebParam(name="id") Long id){
        return compteRepository.findById(id).get();
    }


}
