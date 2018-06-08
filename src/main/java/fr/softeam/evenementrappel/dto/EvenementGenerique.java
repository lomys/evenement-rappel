package fr.softeam.evenementrappel.dto;

public class EvenementGenerique {
    private Integer idEvenement;

    private String nom;

    private String description;

    private String dateEvenement;

    private String dateValidation;

    private String type;

    private Boolean cycle;

    private Integer valeurRecurrence;

    private String typeRecurrence;


    public Integer getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(Integer idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(String dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public String getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(String dateValidation) {
        this.dateValidation = dateValidation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getCycle() {
        return cycle;
    }

    public void setCycle(Boolean cycle) {
        this.cycle = cycle;
    }

    public Integer getValeurRecurrence() {
        return valeurRecurrence;
    }

    public void setValeurRecurrence(Integer valeurRecurrence) {
        this.valeurRecurrence = valeurRecurrence;
    }

    public String getTypeRecurrence() {
        return typeRecurrence;
    }

    public void setTypeRecurrence(String typeRecurrence) {
        this.typeRecurrence = typeRecurrence;
    }

}