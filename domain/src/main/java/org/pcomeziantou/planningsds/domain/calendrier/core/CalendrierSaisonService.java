package org.pcomeziantou.planningsds.domain.calendrier.core;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public  class CalendrierSaisonService {

    public static Optional<JourDeCalendrier> rechercheJourDeCalendrierParmiListe(
            LocalDate dateLocal
            , List<JourDeCalendrier> listeJours
    ){
        return listeJours.stream().filter( jc -> dateLocal.equals(jc.dateJour()) ).findFirst();
    }

    public static Optional<PeriodeCalendrier> transformePeriodeLocalDateEnPeriodeCalendrier(PeriodeLocalDate p, List<JourDeCalendrier> listeJours){
        Optional<PeriodeCalendrier> pc = Optional.empty() ;
        Optional<JourDeCalendrier> j1 = rechercheJourDeCalendrierParmiListe(p.debut() , listeJours);
        Optional<JourDeCalendrier> j2 = rechercheJourDeCalendrierParmiListe(p.fin() , listeJours);

        if (j1.isPresent() && j2.isPresent() ){
            pc = Optional.of(new PeriodeCalendrier(j1.get(), j2.get()));
        }

        return pc;
    }

    public static boolean jourAppartientALaPeriode(LocalDate jour, PeriodeLocalDate periode){
        boolean lb = jour.compareTo(periode.debut()) >= 0 && periode.fin().compareTo(jour) >= 0;

        return lb;
    }

    public static boolean estUnJourDeVacances(
            LocalDate jour
            , List<PeriodeCalendrier> listePeriodes) {
        return estUnJourDeVacancesLocalDate(jour
                , listePeriodes.stream().map(PeriodeCalendrier::getPeriodeLocalDate).toList()
        );
    }

    public static boolean estUnJourDeVacancesLocalDate(
            LocalDate jour
            , List<PeriodeLocalDate> listePeriodes) {
        return listePeriodes
                .stream()
                .anyMatch(p ->  CalendrierSaisonService.jourAppartientALaPeriode(jour,p)  );
    }

    /**
     * Le jour fait-il partie de la liste des jours fériés ?
     *
     * @param jour
     * @return
     */
    public static boolean estUnJourFerie(LocalDate jour, List<JourDeCalendrier> joursFeries) {
        return joursFeries.stream().map(JourDeCalendrier::dateJour).collect(Collectors.toList()).contains(jour);
    }

    public static JourFerieEnum  rechercheJourFerie(LocalDate localDate, List<JourDeCalendrier> joursFeries){
        JourFerieEnum jourFerieEnum = JourFerieEnum.N_EST_PAS_UN_JOUR_FERIE;
        if ( estUnJourFerie(localDate, joursFeries)) {
            Optional<JourDeCalendrier> jdc = joursFeries
                    .stream()
                    .filter((JourDeCalendrier jc) -> jc.dateJour().equals(localDate))
                    .findFirst();
            // JourDeCalendrier jdc = rechercheJourDeCalendrierParmiListe(localDate).get();
            jourFerieEnum = jdc.get().jourFerie();
        }
        return jourFerieEnum;
    }

    public static List<JourDeCalendrier> constructionJoursFeries2023_2024(){

        List<JourDeCalendrier> joursFeries = new ArrayList<>();

        JourDeCalendrier j = new JourDeCalendrier(LocalDate.of(2023, Month.JULY, 14)
                , 28, true, true, JourFerieEnum.QUATORZE_JUILLET);
        joursFeries.add(j);
        j = new JourDeCalendrier(LocalDate.of(2023, Month.AUGUST, 15)
                , 33, true, true, JourFerieEnum.QUINZE_AOUT);
        joursFeries.add(j);
        j = new JourDeCalendrier(LocalDate.of(2023, Month.NOVEMBER, 1)
                , 44, true, true, JourFerieEnum.PREMIER_NOVEMBRE);
        joursFeries.add(j);
        j = new JourDeCalendrier(LocalDate.of(2023, Month.NOVEMBER, 11)
                , 45, true, false, JourFerieEnum.ONZE_NOVEMBRE);
        joursFeries.add(j);
        j = new JourDeCalendrier(LocalDate.of(2023, Month.DECEMBER, 25)
                , 52, true, true, JourFerieEnum.NOEL);
        joursFeries.add(j);
        j = new JourDeCalendrier(LocalDate.of(2024, Month.JANUARY, 1)
                , 52, true, true, JourFerieEnum.PREMIER_JANVIER);
        joursFeries.add(j);
        j = new JourDeCalendrier(LocalDate.of(2024, Month.MARCH, 31)
                , 13
                , true
                , false
                , JourFerieEnum.DIMANCHE_DE_PAQUES
        );
        joursFeries.add(j);

        j = new JourDeCalendrier(LocalDate.of(2024, Month.APRIL, 1)
                , 14
                , true
                , false
                , JourFerieEnum.LUNDI_DE_PAQUES
        );
        joursFeries.add(j);

        j = new JourDeCalendrier(LocalDate.of(2024, Month.MAY, 1)
                , 18
                , true
                , false
                , JourFerieEnum.PREMIER_MAI
        );
        joursFeries.add(j);

        j = new JourDeCalendrier(LocalDate.of(2024, Month.MAY, 8)
                , 19
                , true
                , false
                , JourFerieEnum.HUIT_MAI
        );
        joursFeries.add(j);

        j = new JourDeCalendrier(LocalDate.of(2024, Month.MAY, 9)
                , 19
                , true
                , false
                , JourFerieEnum.ASCENSION
        );
        joursFeries.add(j);

        j = new JourDeCalendrier(LocalDate.of(2024, Month.MAY, 20)
                , 21
                , true
                , false
                , JourFerieEnum.LUNDI_DE_PENTECOTE
        );
        joursFeries.add(j);

         return joursFeries;

    }


    public static List<PeriodeLocalDate> constructionVacancesScolaires2023_2024LocalDate(){

        List<PeriodeLocalDate> vacancesScolairesLocalDate = new ArrayList<>();
        //Eté
        vacancesScolairesLocalDate.add(new PeriodeLocalDate(
                        LocalDate.of(2023,7,1)
                        ,LocalDate.of(2023,9,3)
                )
        );
        //Toussaint
        vacancesScolairesLocalDate.add(new PeriodeLocalDate(
                        LocalDate.of(2023,10,21)
                        , LocalDate.of(2023,11,5)
                )
        );
        //Noël
        vacancesScolairesLocalDate.add(new PeriodeLocalDate(
                        LocalDate.of(2023,12,23)
                        , LocalDate.of(2024,01,7)
                )
        );
        //Printemps
        vacancesScolairesLocalDate.add(new PeriodeLocalDate(
                        LocalDate.of(2024,2,10)
                        , LocalDate.of(2024,2,25)
                )
        );
        //Pâques
        vacancesScolairesLocalDate.add(new PeriodeLocalDate(
                        LocalDate.of(2024,4,6)
                        , LocalDate.of(2024,4,21)
                )
        );
        return vacancesScolairesLocalDate;
    }

    public static List<PeriodeCalendrier> transformeVacancesScolairesLocalDate( List<PeriodeLocalDate> periodeLocalDates, List<JourDeCalendrier> listeJours){
        List<PeriodeCalendrier> vacances = periodeLocalDates.stream()
                .map( p -> CalendrierSaisonService.transformePeriodeLocalDateEnPeriodeCalendrier(p, listeJours))
                .filter(p -> p.isPresent())
                .map(p -> p.get())
                .collect(Collectors.toList());
        return vacances;
    }
}
