package fr.softeam.evenementrappel.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiPersonneAdapter {

    private RestTemplate restTemplate;

    public ApiPersonneAdapter(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String getNomPrenomParId(String idPersonne){
        //TODO implementation
        return null;
    }
}
