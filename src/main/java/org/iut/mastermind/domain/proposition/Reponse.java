package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.unmodifiableList;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();

    public Reponse(String motSecret) {
        this.motSecret = motSecret;

        for (int i = 0; i < motSecret.length(); i++) {
            resultat.add(Lettre.MAL_PLACEE);
        }
    }

    public Lettre lettre(int position) {
        return this.resultat.get(position);
    }

    public void verifierEssai(String essai) {
        for (int i = 0; i < essai.length(); i++) {
            this.resultat.set(i, statutCaractere(essai.charAt(i), i));
        }
    }

    public boolean lettresToutesPlacees() {
        for (var l : this.resultat) {
            if (!l.equals(Lettre.PLACEE)) {
                return false;
            }
        }
        return true;
    }

    public List<Lettre> lettresResultat() {
        return unmodifiableList(resultat);
    }

    private Lettre statutCaractere(char carCourant, int i) {
        if (this.motSecret.contains(String.valueOf(carCourant))) {
            if (estBienPlace(carCourant, i)) {
                return Lettre.PLACEE;
            } else {
                return Lettre.MAL_PLACEE;
            }
        }
        return Lettre.INEXISTANTE;
    }

    private boolean estBienPlace(char carCourant, int i) {
        var c = this.motSecret.charAt(i);
        return c == carCourant;
    }
}