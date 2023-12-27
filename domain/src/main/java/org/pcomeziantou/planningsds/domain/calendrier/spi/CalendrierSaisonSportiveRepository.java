package org.pcomeziantou.planningsds.domain.calendrier.spi;

import org.pcomeziantou.planningsds.domain.calendrier.core.Annee;
import org.pcomeziantou.planningsds.domain.calendrier.core.CalendrierSaisonSportive;

/**
 * Ne sera pas implémentée dans l'immédiat car le calendrier est généré par une classe du package 'core'.
 */
public interface CalendrierSaisonSportiveRepository {
    void saveCalendrierSaisonSportive(CalendrierSaisonSportive calendrier);
    CalendrierSaisonSportive readCalendrierSaisonSportive(Annee annee);
}
