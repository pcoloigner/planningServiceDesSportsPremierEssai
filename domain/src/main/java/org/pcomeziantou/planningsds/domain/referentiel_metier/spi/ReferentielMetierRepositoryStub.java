package org.pcomeziantou.planningsds.domain.referentiel_metier.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.pcomeziantou.planningsds.domain.referentiel_metier.core.Commune;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.EquipementSportif;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.Sport;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.SyndicatIntercommunal;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.TypeZoneEquipementSportif;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.ZoneEquipementSportif;

public class ReferentielMetierRepositoryStub implements ReferentielMetierRepository{

    public List<Sport> readSports(){
        return List.of( new Sport("Volley-ball")
                        , new Sport("Football")
                        , new Sport("Handball")
                        , new Sport("Tennis")
                        , new Sport("Pingpong")
                        , new Sport("Athlétisme")
                        , new Sport("Tir-à-l'arc")
                        , new Sport("Rugby")
                        , new Sport("Cyclisme")
                        , new Sport("Gymnastique artistique")
                        , new Sport("Badminton")
                        , new Sport("Judo")
                        , new Sport("Taekwaendo")
                        , new Sport("Boxe")
        );
    }

    public List<SyndicatIntercommunal> readSyndicatsIntercommunal(){
        return List.of(
                new SyndicatIntercommunal("Syndicat Intercommunal Chevilly L'Hay-les-Roses Fresnes Cachan"
                    , readCommunes()
                )
        );
    }
    
    public List<Commune> readCommunes(){
        return List.of( new Commune("Chevilly-Larue", "94550")
                        , new Commune("L'Hay-les-Roses", "94999")            
                        , new Commune("Fresnes", "94998")            
                        , new Commune("Cachan", "94997")            
        );
    }

    public List<Commune> readCommunesDUnsyndicat(SyndicatIntercommunal syndicat){
        List<Commune> liste = Collections.emptyList();

        List<SyndicatIntercommunal> listeSi = readSyndicatsIntercommunal()
                .stream()
                .filter(s -> s.nom().equals(syndicat.nom()))
                .toList();

        if ( !listeSi.isEmpty()){
            liste = listeSi.get(0).communes();
        }
        return liste;
    }

    public Optional<Commune> findCommunesByNom(String nom){
        List<Commune> liste = readCommunes();

        Optional<Commune> commune = liste
                .stream()
                .filter(c -> c.nom().toUpperCase().equals(c.nom()))
                .findFirst();

        return commune;
       
    }


    public List<EquipementSportif> readEquipementSportifs(){
        Optional<Commune> optCommuneChevilly = this.findCommunesByNom("CHEVILLY-LARUE");

        List<EquipementSportif> listeEquipements = new ArrayList<>();

        if (optCommuneChevilly.isPresent()){

            List<ZoneEquipementSportif> zonesEquipement = new ArrayList<>();
            zonesEquipement = List.of(
                new ZoneEquipementSportif(new UUID(8, 8)
                            , "Salle Omnisport"
                            , TypeZoneEquipementSportif.SALLE_OMNISPORT)
                , new ZoneEquipementSportif(new UUID(8, 8)
                            , "Dojo"
                            , TypeZoneEquipementSportif.DOJO)
                , new ZoneEquipementSportif(new UUID(8, 8)
                            , "Tir-à-l'arc en extérieur"
                            , TypeZoneEquipementSportif.ZONE_TIR_A_L_ARC)
            );

            EquipementSportif gymnasePasteur = new EquipementSportif(
                        new UUID(8, 8)
                        ,"Gymnase Pasteur"
                        , "avenue de la Croix du Sud"
                        , optCommuneChevilly.get()
                        , zonesEquipement);

            listeEquipements.add(gymnasePasteur);
            

        }

        return listeEquipements;
    }

}
