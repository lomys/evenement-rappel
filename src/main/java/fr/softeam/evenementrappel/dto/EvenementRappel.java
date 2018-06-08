package fr.softeam.evenementrappel.dto;

import java.util.List;

public class EvenementRappel {
    private EvenementGenerique informationEvenement;
    private List<String> destinataires;
    private String idPersonne;

    public EvenementRappel() {

    }

    public EvenementGenerique getInformationEvenement() {
        return informationEvenement;
    }

    public void setInformationEvenement(EvenementGenerique informationEvenement) {
        this.informationEvenement = informationEvenement;
    }

    public List<String> getDestinataires() {
        return destinataires;
    }

    public void setDestinataires(List<String> destinataires) {
        this.destinataires = destinataires;
    }

    public String getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(String idPersonne) {
        this.idPersonne = idPersonne;
    }
}
