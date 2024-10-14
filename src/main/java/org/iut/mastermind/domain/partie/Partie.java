package org.iut.mastermind.domain.partie;

import org.iut.mastermind.domain.proposition.Reponse;

public class Partie {
    private static final int NB_ESSAIS_MAX = 5;
    private final Joueur joueur;
    private final String motADeviner;
    private int nbEssais;
    private boolean partieTerminee;

    public Partie(Joueur joueur, String motADeviner, int nbEssais, boolean partieTerminee) {
        this.joueur = joueur;
        this.motADeviner = motADeviner;
        this.nbEssais = nbEssais;
        this.partieTerminee = partieTerminee;
    }

    public static Partie create(Joueur joueur, String motADeviner) {
        return new Partie(joueur, motADeviner, 0, false);
    }

    public static Partie create(Joueur joueur, String motADeviner, int nbEssais) {
        return new Partie(joueur, motADeviner, nbEssais, false);
    }

    public Joueur getJoueur() {
        return this.joueur;
    }

    public int getNbEssais() {
        return this.nbEssais;
    }

    public String getMot() {
        return this.motADeviner;
    }

    // si le nombre max d'essais n'est pas atteint,
    // on compare la proposition au mot secret
    // et on renvoie la réponse
    // si toutes les lettres sont correctement placées,
    // on a terminé la partie
    public Reponse proposerMot(String motPropose) {
        nbEssais++; // Pourquoi dès le début ?
        if (!isTerminee()) {
            var r = new Reponse(this.motADeviner);
            r.verifierEssai(motPropose);
            if (r.lettresToutesPlacees()) {
                terminerPartie();
            }
            return r;
        }
        return new Reponse(this.motADeviner);
    }

    public boolean isTerminee() {
        return this.partieTerminee || this.nbEssais >= NB_ESSAIS_MAX;
    }

    public void terminerPartie() {
        this.partieTerminee = true;
    }
}