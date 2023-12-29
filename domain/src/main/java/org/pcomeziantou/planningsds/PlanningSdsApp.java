package org.pcomeziantou.planningsds;

import org.pcomeziantou.planningsds.domain.calendrier.CreerCalendrierSaisonSportiveImpl;
import org.pcomeziantou.planningsds.domain.calendrier.api.CreerCalendrierSaisonSportive;
import org.pcomeziantou.planningsds.domain.calendrier.core.Annee;
import org.pcomeziantou.planningsds.domain.calendrier.core.CalendrierSaisonSportive;
import org.pcomeziantou.planningsds.domain.referentiel_metier.InitialiseReferentielMetierImpl;
import org.pcomeziantou.planningsds.domain.referentiel_metier.api.InitialiseReferentielMetier;

/**
 * Hello world!
 *
 */
public class PlanningSdsApp 
{
    {
        System.out.println( "Hello World!" );


        /* Créer le calendrier 2023/2024 */
        Annee annee20232024 = new Annee(2023);
        CreerCalendrierSaisonSportive creerCalendrierSaisonSportive = new CreerCalendrierSaisonSportiveImpl();
        CalendrierSaisonSportive calendrier20232024 = creerCalendrierSaisonSportive.creer(annee20232024);

        /* Initialiser le référentiel métier */
        InitialiseReferentielMetier initRefMetier = new InitialiseReferentielMetierImpl();
        initRefMetier.initialiseReferenceMetier();




    }
}
