package fr.softeam.evenementrappel.scheduled;

import fr.softeam.evenementrappel.dto.EvenementRappel;
import fr.softeam.evenementrappel.exception.EvenementRappelException;
import fr.softeam.evenementrappel.mail.EmailServiceImpl;
import fr.softeam.evenementrappel.service.ApiGroupePersonneAdapter;
import fr.softeam.evenementrappel.service.ApiPersonneAdapter;
import fr.softeam.evenementrappel.service.EvenementParcoursIntegrationAdapter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TacheEvenementRappel {

    private ApiGroupePersonneAdapter apiGroupePersonneAdapter;

    private EvenementParcoursIntegrationAdapter evenementParcoursIntegrationAdapter;

    private EmailServiceImpl emailService;

    private ApiPersonneAdapter apiPersonneAdapter;

    public TacheEvenementRappel(ApiGroupePersonneAdapter apiGroupePersonneAdapter,
                                EvenementParcoursIntegrationAdapter evenementParcoursIntegrationAdapter,
                                EmailServiceImpl emailService,
                                ApiPersonneAdapter apiPersonneAdapter){
        this.apiGroupePersonneAdapter = apiGroupePersonneAdapter;
        this.evenementParcoursIntegrationAdapter = evenementParcoursIntegrationAdapter;
        this.emailService = emailService;
        this.apiPersonneAdapter = apiPersonneAdapter;
    }

    @Scheduled(cron="0 7 * * * *")
    public void sendRappel() throws EvenementRappelException {
        List<EvenementRappel> evenementRappelList = evenementParcoursIntegrationAdapter.getEvenementsARappeler();
        for (EvenementRappel evenementRappel: evenementRappelList
             ) {
            List<String> destinataires = evenementRappel.getDestinataires();
            for (String groupe: destinataires
                 ) {
                for (String email : apiGroupePersonneAdapter.getEmailByGroupe(groupe)
                     ) {
                    String message = "L'évènement "+ evenementRappel.getInformationEvenement().getNom()
                            + " du collaborateur " + apiPersonneAdapter.getNomPrenomParId((evenementRappel.getIdPersonne()))
                            + " est le " + evenementRappel.getInformationEvenement().getDateEvenement()+".";
                    emailService.sendSimpleMessage(email,"Rappel évènement",message);
                }
            }
        }
    }


}
