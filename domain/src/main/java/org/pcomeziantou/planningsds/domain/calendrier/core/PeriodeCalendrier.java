package org.pcomeziantou.planningsds.domain.calendrier.core;

import java.time.LocalDate;

/**
 * Va servir à définir les vacances scolaires,
 * les plages de stages, ou tout ce qui se déroule sur plusieurs jours.
 *
 * @param debut
 * @param fin
 */
public record PeriodeCalendrier(JourDeCalendrier debut, JourDeCalendrier fin){

    public boolean contientLeJour(JourDeCalendrier jour){
        //int i = jour.compareTo(debut());
        //int j = fin().compareTo(jour);
        return (jour.compareTo(debut()) >= 0 && fin().compareTo(jour) >= 0 );
    }

    public boolean contientLeJour(LocalDate jour){
        return getPeriodeLocalDate().contientLeJour(jour);
    }

    public PeriodeLocalDate getPeriodeLocalDate(){
        return new PeriodeLocalDate( debut().dateJour(), fin().dateJour());
    }
}
