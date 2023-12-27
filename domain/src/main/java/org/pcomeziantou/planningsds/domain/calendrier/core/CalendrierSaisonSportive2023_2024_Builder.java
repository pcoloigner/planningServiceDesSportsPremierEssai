package org.pcomeziantou.planningsds.domain.calendrier.core;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalendrierSaisonSportive2023_2024_Builder {

    private static CalendrierSaisonSportive2023_2024_Builder instance = new CalendrierSaisonSportive2023_2024_Builder();
    private Annee anneeDebut = new Annee(2023);
    private Annee anneeFin = new Annee(2024);

    private JourDeCalendrier premierJourSaison;
    private JourDeCalendrier dernierJourSaison;
    /**
     * Tous les jours de la saison (avec les propriétés, qui vont être calculées)
     */
    private List<JourDeCalendrier> joursSaison = new ArrayList<>();
    private List<JourDeCalendrier> joursFeries = new ArrayList<>();
    private List<SemaineCalendrier> semaines = new ArrayList<>();
    private List<PeriodeCalendrier> vacancesScolaires = new ArrayList<>();
    private boolean joursFeriesOK = false;
    private boolean vacancesScolairesOK = false;
    private boolean joursSaisonOK = false;

    //Utilitaire
    private List<PeriodeLocalDate> vacancesScolairesLocalDate = new ArrayList<>();
    //private List<PeriodeLocalDate> semainesLocalDate = new ArrayList<>();

    public static CalendrierSaisonSportive2023_2024_Builder getInstance() {
        return instance;
    }

    public CalendrierSaisonSportive build() {
        CalendrierSaisonSportive calendrierSaison = null;

        joursFeries = getJoursFeries();
        constructionVacancesScolairesPremiereEtape();
        construitJoursSaison();
        constructionVacancesScolairesDeuxiemeEtape();

        //À la fin de la méthode, tous les champs sont calculés.
        //On peut créer le record :
        calendrierSaison = new CalendrierSaisonSportive(
                premierJourSaison
                , dernierJourSaison
                , joursSaison
                , joursFeries
                , semaines
                , vacancesScolaires
        );
        return calendrierSaison;
    }

    /*Va créer les éléments constitutifs */
    private CalendrierSaisonSportive2023_2024_Builder() {
        //this.build();
    }

    private void construitJoursSaison() {

        premierJourSaison = new JourDeCalendrier(LocalDate.of(anneeDebut.an(), Month.JULY, 1)
                , 26, false, false, JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE);

        dernierJourSaison = new JourDeCalendrier(LocalDate.of(anneeFin.an(), Month.JUNE, 30)
                , 26, false, false, JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE);

        //Première semaine : n°26 : samedi 1, dimanche 2
        //Ajout premier jour de la saison
        joursSaison.add(premierJourSaison);

        JourDeCalendrier jour = new JourDeCalendrier(
                LocalDate.of(2023, 7, 2)
                , 26
                , false
                , false
                , JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE
        );
        joursSaison.add(jour);

        SemaineCalendrier premiereSemaine;
        premiereSemaine = new SemaineCalendrier(
                new PeriodeCalendrier(premierJourSaison, jour)
                , 26
        );
        semaines.add(premiereSemaine);

        JourDeCalendrier dernierJourSemainePrecedente = jour;
        for (int i = 27; i <= 51; i++) {
            dernierJourSemainePrecedente = constructionSemaineEtJours(dernierJourSemainePrecedente, i);
        }

        JourDeCalendrier jour3112 = constructionSemaine52();
        dernierJourSemainePrecedente = jour3112;
        for (int i = 1; i <= 26; i++) {
            dernierJourSemainePrecedente = constructionSemaineEtJours(dernierJourSemainePrecedente, i);
        }
        //Il se trouve que le dimanche 30 juin 2024 est le dernier jour de la semaine 26
        joursSaisonOK = true;
    }

    private JourDeCalendrier constructionSemaineEtJours(JourDeCalendrier jourPrecedent, int noSemaine) {

        
        //LocalDate lundiLocalDate = jourPrecedent.dateJour().plusDays(1);

        JourDeCalendrier lundi = jourDeCalendrierSuivant(jourPrecedent, noSemaine);
        joursSaison.add(lundi);
        JourDeCalendrier mardi = jourDeCalendrierSuivant(lundi, noSemaine);
        joursSaison.add(mardi);
        JourDeCalendrier mercredi = jourDeCalendrierSuivant(mardi, noSemaine);
        joursSaison.add(mercredi);
        JourDeCalendrier jeudi = jourDeCalendrierSuivant(mercredi, noSemaine);
        joursSaison.add(jeudi);
        JourDeCalendrier vendredi = jourDeCalendrierSuivant(jeudi, noSemaine);
        joursSaison.add(vendredi);
        JourDeCalendrier samedi = jourDeCalendrierSuivant(vendredi, noSemaine);
        joursSaison.add(samedi);
        JourDeCalendrier dimanche = jourDeCalendrierSuivant(samedi, noSemaine);
        joursSaison.add(dimanche);

        //TO DO : COMPLETER LES SEMAINES
        SemaineCalendrier semaine = new SemaineCalendrier(
                new PeriodeCalendrier(lundi, dimanche)
                , noSemaine
        );
        semaines.add(semaine);

        return dimanche;
    }

    public JourDeCalendrier jourDeCalendrierSuivant(JourDeCalendrier jourPrecedent, int noSemaine){
        
        LocalDate localDate = jourPrecedent.dateJour().plusDays(1);
        JourDeCalendrier jdcSuivant = new JourDeCalendrier(
                localDate
                , noSemaine
                , estUnJourFerie(localDate)
                , CalendrierSaisonService.estUnJourDeVacancesLocalDate(localDate, this.vacancesScolairesLocalDate)
                , CalendrierSaisonService.rechercheJourFerie(localDate, this.joursFeries)
        );
        return jdcSuivant;
    }

    private JourDeCalendrier constructionSemaine52(){
        JourDeCalendrier jour1 = new JourDeCalendrier(
                LocalDate.of(2023, 12, 25)
                , 52
                , true
                , true
                , JourFerieEnum.NOEL
        );
        JourDeCalendrier jour2 = new JourDeCalendrier(
                LocalDate.of(2023, 12, 26)
                , 52
                , false
                , true
                , JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE
        );
        JourDeCalendrier jour3 = new JourDeCalendrier(
                LocalDate.of(2023, 12, 27)
                , 52
                , false
                , true
                , JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE
        );
        JourDeCalendrier jour4 = new JourDeCalendrier(
                LocalDate.of(2023, 12, 28)
                , 52
                , false
                , true
                , JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE
        );
        JourDeCalendrier jour5 = new JourDeCalendrier(
                LocalDate.of(2023, 12, 29)
                , 52
                , false
                , true
                , JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE
        );
        JourDeCalendrier jour6 = new JourDeCalendrier(
                LocalDate.of(2023, 12, 30)
                , 52
                , false
                , true
                , JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE
        );
        JourDeCalendrier jour7 = new JourDeCalendrier(
                LocalDate.of(2023, 12, 31)
                , 52
                , false
                , true
                , JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE
        );

        SemaineCalendrier semaine52 = new SemaineCalendrier(
                new PeriodeCalendrier(jour1, jour2)
                , 52
        );
        joursSaison.add(jour1);
        joursSaison.add(jour2);
        joursSaison.add(jour3);
        joursSaison.add(jour4);
        joursSaison.add(jour5);
        joursSaison.add(jour6);
        joursSaison.add(jour7);
        semaines.add(semaine52);

        return jour7;
}

    /**
     * Construit les vacances scolaires de la saison
     */
    private void constructionVacancesScolairesPremiereEtape(){
        vacancesScolairesLocalDate = CalendrierSaisonService.constructionVacancesScolaires2023_2024LocalDate();
    }

    private void constructionVacancesScolairesDeuxiemeEtape(){
        vacancesScolaires = CalendrierSaisonService.transformeVacancesScolairesLocalDate(vacancesScolairesLocalDate, joursSaison);
     }

    public List<JourDeCalendrier> getJoursFeries(){
        if (this.joursFeries == null || this.joursFeries.isEmpty()){
            this.joursFeries = CalendrierSaisonService.constructionJoursFeries2023_2024();
            this.joursFeriesOK = true;
        }
        return this.joursFeries;
    }

    public Optional<JourDeCalendrier> rechercheJourDeCalendrierParmiListe(LocalDate dateLocal){
        return joursSaison.stream().filter( jc -> dateLocal.equals(jc.dateJour()) ).findFirst();
    }

    /**
     * Le jour fait-il partie de la liste des jours fériés ?
     *
     * @param jour
     * @return
     */
    public boolean estUnJourFerie(LocalDate jour) {
        //List<LocalDate> listLocalDate = new ArrayList<>();
        //listLocalDate = joursFeries.stream().map(JourDeCalendrier::dateJour).collect(Collectors.toList());
        return CalendrierSaisonService.estUnJourFerie(jour, joursFeries);
    }

    //private boolean estJourSemaine(LocalDate localDate) {
    //    return !estJourWeekend(localDate);
    //}

    //private boolean estJourWeekend(LocalDate localDate) {
    //    return localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
    //}

    public Annee getAnneeDebut() {
        return anneeDebut;
    }

    public Annee getAnneeFin() {
        return anneeFin;
    }

    public JourDeCalendrier getPremierJourSaison() {
        return premierJourSaison;
    }

    public JourDeCalendrier getDernierJourSaison() {
        return dernierJourSaison;
    }

    public List<JourDeCalendrier> getJoursSaison() {
        return joursSaison;
    }

    public List<SemaineCalendrier> getSemaines() {
        return semaines;
    }

    public boolean isJoursFeriesOK() {
        return joursFeriesOK;
    }

    public boolean isVacancesScolairesOK() {
        return vacancesScolairesOK;
    }

    public boolean isJoursSaisonOK() {
        return joursSaisonOK;
    }
}
