package org.pcomeziantou.planningsds.domain.referentiel_metier.api;

import java.util.List;

import org.pcomeziantou.planningsds.domain.referentiel_metier.core.Commune;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.EquipementSportif;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.Sport;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.SyndicatIntercommunal;

public interface InitialiseReferentielMetier {

    void initialiseReferenceMetier();

    List<Sport> sports();
    List<SyndicatIntercommunal> syndicatsIntercommunal();
    List<Commune> communes();
    List<Commune> communesDUnsyndicat(SyndicatIntercommunal syndicat);    
    List<EquipementSportif> equipementSportifs();

}
