package org.pcomeziantou.planningsds.domain.calendrier.core;

/**
 *
 * Manque le contrôle qu'il s'agit bien d'une semaine !
 * Mais ce n'est peut-être pas nécessaire tout de suite.
 *
 * @param periode

 */

    public record SemaineCalendrier(PeriodeCalendrier periode, int numero) {

        public Annee annee(){
            return new Annee(periode.debut().dateJour().getYear());
        }

        public JourDeCalendrier premierJour(){
            return periode().debut();
        }

        public JourDeCalendrier dernierJour(){
            return periode().fin();
        }

}
