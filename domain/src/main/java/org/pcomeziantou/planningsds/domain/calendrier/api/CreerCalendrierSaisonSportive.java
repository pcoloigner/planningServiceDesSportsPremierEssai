package org.pcomeziantou.planningsds.domain.calendrier.api;

import org.pcomeziantou.planningsds.domain.calendrier.core.Annee;
import org.pcomeziantou.planningsds.domain.calendrier.core.CalendrierSaisonSportive;

public interface CreerCalendrierSaisonSportive {
    public CalendrierSaisonSportive creer(Annee anneeDebut);

}
