package org.iut.mastermind.domain.partie;

public class Joueur {

    private final String nom;

    public Joueur(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Joueur)) {
            return false;
        }
        return this.nom.equals(((Joueur) o).nom);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash * 6;
    }
}