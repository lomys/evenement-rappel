package fr.softeam.evenementrappel.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiGroupePersonneAdapter {

    private RestTemplate restTemplate;

    public ApiGroupePersonneAdapter(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * Appel de l'api rest permetant de récuperer la liste des emails d'un groupe de diffusion
     *
     * @param groupe
     * @return liste d'email
     */
    public List<String> getEmailByGroupe(String groupe){
        //TODO implementation
        return null;
    }
}
