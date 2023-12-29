package org.pcomeziantou.planningsds.domain.referentiel_metier.spi;

import java.util.List;

import org.pcomeziantou.planningsds.domain.referentiel_metier.core.Commune;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.EquipementSportif;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.Sport;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.SyndicatIntercommunal;

public interface ReferentielMetierRepository {

    List<Sport> readSports();
    List<SyndicatIntercommunal> readSyndicatsIntercommunal();
    List<Commune> readCommunes();
    List<Commune> readCommunesDUnsyndicat(SyndicatIntercommunal syndicat);
    List<EquipementSportif> readEquipementSportifs();
    

}
