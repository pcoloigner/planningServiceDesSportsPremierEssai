package org.pcomeziantou.planningsds.domain.calendrier.core;

import java.time.LocalDate;

public record SaisonSportive(Annee annee) {

    public LocalDate debut(){
        return LocalDate.of(annee.an(), 7, 1);
    }
    public LocalDate fin(){
        return LocalDate.of(annee.an()+1, 6, 30);
    }
    public String getLibelleSaison(){
        return annee.an()+"/"+ (annee.an()+1);
    }

}
