package org.pcomeziantou.planningsds.domain.calendrier.core;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

public record JourDeCalendrier(LocalDate dateJour
        //, DayOfWeek day
        , int numeroSemaine
        , boolean estFerie
        , boolean estJourDeVacancesScolaires
        , JourFerieEnum jourFerie
        ) implements Comparable<JourDeCalendrier> {

    Optional<JourFerieEnum> getOptionalJourFerie(){
        return Optional.ofNullable(jourFerie);
    }
    public DayOfWeek getDayOfWeek(){
        return dateJour().getDayOfWeek();
    }
    public boolean estJourSemaine(){
        return !estJourWeekend();
    }
    public boolean estJourWeekend(){
        return (DayOfWeek.SATURDAY.equals(dateJour.getDayOfWeek())
                || DayOfWeek.SATURDAY.equals(dateJour.getDayOfWeek()) );
    }

    public Annee annee(){
        return new Annee(dateJour.getYear());
    }

    public boolean isSameLocalDate(JourDeCalendrier o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JourDeCalendrier that = o;

        return dateJour.equals(that.dateJour);
    }

    @Override
    public int hashCode() {
        return dateJour.hashCode();
    }

    @Override
    //public int compareTo(@NotNull JourDeCalendrier o) {
    public int compareTo(JourDeCalendrier o) {
        return this.dateJour().compareTo(o.dateJour());
    }

}
