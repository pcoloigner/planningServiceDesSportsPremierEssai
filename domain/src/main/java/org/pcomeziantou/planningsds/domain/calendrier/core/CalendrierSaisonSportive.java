package org.pcomeziantou.planningsds.domain.calendrier.core;

import java.time.LocalDate;
import java.util.List;

/**
 *
 *
 */
public record CalendrierSaisonSportive(
        JourDeCalendrier premierJourSaison
        , JourDeCalendrier dernierJourSaison
        , List<JourDeCalendrier> joursSaison
        , List<JourDeCalendrier> joursFeries
        , List<SemaineCalendrier> semaines
        , List<PeriodeCalendrier> vacancesScolaires
        ) {

        public boolean estUnJourFerie(LocalDate jour){
                boolean lb = CalendrierSaisonService.estUnJourFerie(jour, joursFeries);
                return lb;
        }
        public boolean estUnJourDeVacances(LocalDate jour){
                boolean lb = CalendrierSaisonService.estUnJourDeVacances(jour, vacancesScolaires());
                return lb;
        }
}

