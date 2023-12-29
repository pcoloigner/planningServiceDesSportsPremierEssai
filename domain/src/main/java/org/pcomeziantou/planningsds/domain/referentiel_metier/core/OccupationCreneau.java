package org.pcomeziantou.planningsds.domain.referentiel_metier.core;

/**
 * A quoi, par qui sera utilisé le créneau.
 * exemple : Entraînement Filles Régionale FFVB
 *
 * C'est juste un libellé
 * 
 * Revoir le but de ce Record !
 *
 * @param libelleCourt
 * @param libelleLong
 */
public record OccupationCreneau(String libelleCourt, String libelleLong) {
}
