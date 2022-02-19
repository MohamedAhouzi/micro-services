package com.ahouzi.msbanque.web;

import com.ahouzi.msbanque.entities.Compte;
import com.ahouzi.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@RestController
@RequestMapping("/banque")
public class CompteRestControllerAPI {
    private final CompteRepository compteRepository;
     @Autowired
    public CompteRestControllerAPI(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

     @GetMapping(value = "/comptes",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Compte> compteList(){
    return compteRepository.findAll();
    }

   @GetMapping(value = "/compte/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Compte getCompte(@PathVariable(value="id") Long id){
        return compteRepository.findById(id).get();
    }
    @PostMapping(value = "/comptes",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping(value = "/compte/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Compte update(Compte compte,@PathVariable(value = "id") Long id){
         compte.setId(id);
         return compteRepository.save(compte);
    }
    @DeleteMapping(value = "/compte/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable(value = "id") Long id){
         compteRepository.deleteById(id);
    }


}
