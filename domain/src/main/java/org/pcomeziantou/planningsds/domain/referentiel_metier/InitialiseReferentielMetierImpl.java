package org.pcomeziantou.planningsds.domain.referentiel_metier;

import java.util.List;

import org.pcomeziantou.planningsds.domain.referentiel_metier.api.InitialiseReferentielMetier;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.Commune;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.Sport;
import org.pcomeziantou.planningsds.domain.referentiel_metier.core.SyndicatIntercommunal;

public class InitialiseReferentielMetierImpl implements InitialiseReferentielMetier {

    @Override
    public void initialiseReferenceMetier() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialiseReferenceMetier'");
    }

    @Override
    public List<Sport> sports() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sports'");
    }

    @Override
    public List<SyndicatIntercommunal> syndicatsIntercommunal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'syndicatsIntercommunal'");
    }

    @Override
    public List<Commune> communes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'communes'");
    }

    @Override
    public List<Commune> communesDUnsyndicat(SyndicatIntercommunal syndicat) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'communesDUnsyndicat'");
    }

}
