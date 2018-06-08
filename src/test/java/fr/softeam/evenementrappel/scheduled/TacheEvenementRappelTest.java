package fr.softeam.evenementrappel.scheduled;

import fr.softeam.evenementrappel.dto.EvenementGenerique;
import fr.softeam.evenementrappel.dto.EvenementRappel;
import fr.softeam.evenementrappel.exception.EvenementRappelException;
import fr.softeam.evenementrappel.mail.EmailServiceImpl;
import fr.softeam.evenementrappel.service.ApiGroupePersonneAdapter;
import fr.softeam.evenementrappel.service.ApiPersonneAdapter;
import fr.softeam.evenementrappel.service.EvenementParcoursIntegrationAdapter;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TacheEvenementRappelTest {

    @Mock
    private ApiGroupePersonneAdapter apiGroupePersonneAdapter;

    @Mock
    private ApiPersonneAdapter apiPersonneAdapter;

    @Mock
    private EvenementParcoursIntegrationAdapter evenementParcoursIntegrationAdapter;

    @Mock
    private EmailServiceImpl emailService;

    @InjectMocks
    private TacheEvenementRappel tacheEvenementRappel;

    @Test
    public void given_liste_2_evenement_a_rappeler_when_envoi_des_mails_then_envoi_2_mail() throws EvenementRappelException {
        List<String> emails = new ArrayList<>();
        int cpt = 0;
        emails.add("test.test@test.fr");
        Mockito.when(apiGroupePersonneAdapter.getEmailByGroupe(Mockito.any())).thenReturn(emails);
        Mockito.when(apiPersonneAdapter.getNomPrenomParId(Mockito.any())).thenReturn("Mr Power");
        Mockito.when(evenementParcoursIntegrationAdapter.getEvenementsARappeler()).thenReturn(getListeEvenementRappelDummy());
        tacheEvenementRappel.sendRappel();
        Mockito.verify(emailService,Mockito.times(2)).sendSimpleMessage(Mockito.any(),Mockito.any(),Mockito.any());
    }

    private List<EvenementRappel> getListeEvenementRappelDummy(){
        List<EvenementRappel> evenementRappelList = new ArrayList<>();
        EvenementRappel evenementRappel = new EvenementRappel();
        List<String> destinataires = new ArrayList<>();
        destinataires.add("rh");
        evenementRappel.setDestinataires(destinataires);
        EvenementGenerique evenementGenerique = new EvenementGenerique();
        evenementGenerique.setIdEvenement(1);
        evenementGenerique.setNom("Point accueil");
        evenementGenerique.setDateEvenement("23/10/2018");
        evenementRappel.setInformationEvenement(evenementGenerique);
        evenementRappel.setIdPersonne("mr_power");
        evenementRappelList.add(evenementRappel);
        List<String> destinataires1 = new ArrayList<>();
        EvenementRappel evenementRappel1 = new EvenementRappel();
        destinataires1.add("commerce");
        evenementRappel1.setDestinataires(destinataires1);
        EvenementGenerique evenementGenerique1 = new EvenementGenerique();
        evenementGenerique1.setIdEvenement(1);
        evenementGenerique1.setNom("Point accueil");
        evenementGenerique1.setDateEvenement("23/10/2018");
        evenementRappel1.setInformationEvenement(evenementGenerique1);
        evenementRappel1.setIdPersonne("mr_power");
        evenementRappelList.add(evenementRappel1);
        return evenementRappelList;
    }

}
