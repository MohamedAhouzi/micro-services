package com.ahouzi.msbanque.web;

import com.ahouzi.msbanque.entities.Compte;
import com.ahouzi.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    private final CompteRepository compteRepository;
     @Autowired
    public CompteRestJaxRSAPI(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }
     @Path("/comptes")
     @GET
     @Produces({MediaType.APPLICATION_JSON})
    public List<Compte> compteList(){
    return compteRepository.findAll();
    }

    @Path("/compte/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getCompte(@PathParam(value="id") Long id){
        return compteRepository.findById(id).get();
    }
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }

    @Path("/compte/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte update(Compte compte,@PathParam(value = "id") Long id){
         compte.setId(id);
         return compteRepository.save(compte);
    }
    @Path("/compte/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void delete(@PathParam(value = "id") Long id){
         compteRepository.deleteById(id);
    }


}
