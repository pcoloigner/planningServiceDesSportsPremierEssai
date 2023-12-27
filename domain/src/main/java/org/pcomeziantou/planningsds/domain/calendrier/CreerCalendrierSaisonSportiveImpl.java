package org.pcomeziantou.planningsds.domain.calendrier;

import org.pcomeziantou.planningsds.domain.calendrier.api.CreerCalendrierSaisonSportive;
import org.pcomeziantou.planningsds.domain.calendrier.core.Annee;
import org.pcomeziantou.planningsds.domain.calendrier.core.CalendrierSaisonSportive;
import org.pcomeziantou.planningsds.domain.calendrier.core.CalendrierSaisonSportive2023_2024_Builder;


public class CreerCalendrierSaisonSportiveImpl implements CreerCalendrierSaisonSportive {

    CalendrierSaisonSportive2023_2024_Builder builder = CalendrierSaisonSportive2023_2024_Builder.getInstance();

    @Override
    public CalendrierSaisonSportive creer(Annee anneeDebut) {
        if( anneeDebut.an() != 2023){
            return null;
        }
        CalendrierSaisonSportive cal = builder.build();

        return cal;
    }
}
