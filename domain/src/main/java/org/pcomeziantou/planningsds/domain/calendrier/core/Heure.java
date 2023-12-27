package org.pcomeziantou.planningsds.domain.calendrier.core;

import java.time.LocalTime;

public record Heure(int heure, int minute) {
    LocalTime getLocalTime(){
        return LocalTime.of(heure, minute);
    }
    String libelle(){
        return String.format("%02d",heure) + "h" + String.format("%02d",minute);  
    }

    double dureeEnHeure(Heure origine){
        if ( origine.minute() > minute() ){
            return (origine.heure() - heure()-1) + (origine.minute() - minute()) /60;
        } else {
            return (origine.heure() - heure()) + (minute() - origine.minute()) /60;
        }
    }
}
