package org.pcomeziantou.planningsds.domain.reference_metier;

/**
 * A quoi, par qui sera utilisé le créneau.
 * exemple : Entraînement Filles Régionale FFVB
 *
 * C'est juste un libellé
 *
 * @param libelleCourt
 * @param libelleLong
 */
public record OccupationCreneau(String libelleCourt, String libelleLong) {
}
