package org.pcomeziantou.planningsds;

//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.pcomeziantou.planningsds.domain.calendrier.CreerCalendrierSaisonSportiveImpl;
import org.pcomeziantou.planningsds.domain.calendrier.api.CreerCalendrierSaisonSportive;
import org.pcomeziantou.planningsds.domain.calendrier.core.Annee;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        org.junit.jupiter.api.Assertions.assertTrue( true );
    }

    @Test void shouldCreateCalendrierSaisonSportive20232024(){
        CreerCalendrierSaisonSportive creerCalendrierSaisonSportive20232024 = new CreerCalendrierSaisonSportiveImpl();
        Annee annee20232024 = new Annee(2023);
        creerCalendrierSaisonSportive20232024.creer(annee20232024);

         org.junit.jupiter.api.Assertions.assertTrue( true );
    }
}
