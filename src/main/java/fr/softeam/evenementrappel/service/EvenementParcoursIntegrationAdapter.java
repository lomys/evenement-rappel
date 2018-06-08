package fr.softeam.evenementrappel.service;

import fr.softeam.evenementrappel.dto.EvenementGenerique;
import fr.softeam.evenementrappel.dto.EvenementRappel;
import fr.softeam.evenementrappel.exception.EvenementRappelException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EvenementParcoursIntegrationAdapter {
    private RestTemplate restTemplate;

    @Value("${evenement.parcours.integration}")
    private String evenementParcoursIntegration;

    @Value("${rappel.evenement}")
    private String rappelEvenement;

    public EvenementParcoursIntegrationAdapter(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<EvenementRappel> getEvenementsARappeler() throws EvenementRappelException{
        try{
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> entity = new HttpEntity<>("", headers);
            ResponseEntity<List<EvenementRappel>> responseEntity =
                    restTemplate.exchange(evenementParcoursIntegration+rappelEvenement,
                            HttpMethod.GET,
                            entity,
                            new ParameterizedTypeReference<List<EvenementRappel>>(){});
            return responseEntity.getBody();
        }catch(HttpClientErrorException  exception){
            throw new EvenementRappelException(exception.getResponseBodyAsString());
        }
    }
}
