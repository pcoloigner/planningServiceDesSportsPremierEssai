package org.pcomeziantou.planningsds.domain.calendrier.core;

import java.time.LocalDate;

/**
 *
 * Il faudrait deux manières de créer SemaineCalendrier :
 * avec PeriodeCalendrier
 *
 * @param periode

 */
//public record SemaineCalendrier(PeriodeCalendrier periode, Annee annee, int numero) {
public record SemaineLocalDate(PeriodeLocalDate periode, int numero) {

    public Annee annee(){
        return new Annee(periode.debut().getYear());
    }

    public LocalDate premierJour(){
        return periode().debut();
    }

    public LocalDate dernierJour(){
        return periode().fin();
    }

}
