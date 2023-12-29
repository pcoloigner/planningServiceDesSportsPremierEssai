package org.pcomeziantou.planningsds.domain.referentiel_metier.core;

import java.util.List;
import java.util.UUID;

public record EquipementSportif(UUID uid, String nom, String adresse, Commune commune, List<ZoneEquipementSportif> zonesEquipementSportif) {

}
