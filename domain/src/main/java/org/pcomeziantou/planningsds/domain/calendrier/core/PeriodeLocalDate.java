package org.pcomeziantou.planningsds.domain.calendrier.core;

import java.time.LocalDate;

/**
 * Va servir à définir les vacances scolaires,
 * les plages de stages, ou tout ce qui se déroule sur plusieurs jours.
 *
 * @param debut
 * @param fin
 */
public record PeriodeLocalDate(LocalDate debut, LocalDate fin){

    //Ajouter un contrôle de précédence des dates.

    public boolean contientLeJour(JourDeCalendrier jour){
        return contientLeJour(jour.dateJour());
    }

    public boolean contientLeJour(LocalDate jour){
        return (jour.compareTo(debut) >= 0 && fin.compareTo(jour) >= 0 );
    }
    
}
