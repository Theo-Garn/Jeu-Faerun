package jeu;

import java.util.List;
import java.util.ArrayList;

public class Plateau {
    private Carreau[] carreaux; // Tableau de carreaux composant le plateau
    private int longueur;       // Longueur du plateau

    /**
     * Constructeur de la classe Plateau.
     * Initialise le plateau avec une série de carreaux d'une longueur spécifiée.
     *
     * @param longueur La longueur du plateau (nombre de carreaux).
     */
    public Plateau(int longueur) {
        if (longueur < 2) {
            throw new IllegalArgumentException("La longueur du plateau doit être au moins 2.");
        }
        this.longueur = longueur;
        this.carreaux = new Carreau[longueur];
        for (int i = 0; i < longueur; i++) {
            carreaux[i] = new Carreau(); // Initialisation de chaque carreau
        }
    }

    /**
     * Ajoute les guerriers d'un château à leur position initiale sur le plateau.
     * Les guerriers bleus démarrent à l'extrémité gauche (index 0),
     * tandis que les guerriers rouges commencent à l'extrémité droite (index longueur - 1).
     *
     * @param chateau   Le château auquel appartiennent les guerriers.
     * @param guerriers Une liste de guerriers à placer.
     */
    public void ajouterGuerriers(Chateau chateau, List<Guerrier> guerriers) {
        if (chateau.estBleu()) {
            getDepartBleu().ajouterGuerriersBleus(guerriers);  // Aucun contrôle ici
        } else if (chateau.estRouge()) {
            getDepartRouge().ajouterGuerriersRouges(guerriers); // Aucun contrôle ici
        }
    }


    /**
     * Déplace les guerriers sur le plateau.
     * Les guerriers bleus avancent vers la droite (index +1),
     * tandis que les guerriers rouges avancent vers la gauche (index -1).
     */
    public void deplacerGuerriers() {
        // Déplacer les guerriers bleus vers la droite
        for (int i = longueur - 1; i >= 0; i--) { // Parcours inversé pour éviter la réinsertion immédiate
            List<Guerrier> guerriersBleus = carreaux[i].retirerGuerriersBleus();
            if (i + 1 < longueur) {
                carreaux[i + 1].ajouterGuerriersBleus(guerriersBleus);
            }
        }

        // Déplacer les guerriers rouges vers la gauche
        for (int i = 0; i < longueur; i++) { // Parcours normal pour éviter la réinsertion immédiate
            List<Guerrier> guerriersRouges = carreaux[i].retirerGuerriersRouges();
            if (i - 1 >= 0) {
                carreaux[i - 1].ajouterGuerriersRouges(guerriersRouges);
            }
        }
    }

    /**
     * Lance les combats sur chaque carreau du plateau où des guerriers de deux couleurs sont présents.
     */
    public void lanceCombat() {
        for (int i = 0; i < longueur; i++) {
            Carreau carreau = carreaux[i];
            if (carreau.estChampDeBataille()) {
                carreau.lanceCombat(); // Déclenche le combat sur le carreau
            }
        }
    }

    /**
     * Vérifie si la partie est terminée.
     * La partie se termine lorsqu'il ne reste que des guerriers d'une seule couleur sur le plateau
     * ou si aucun guerrier n'est présent.
     *
     * @return {@code true} si la partie est terminée, sinon {@code false}.
     */
    public boolean estPartieTerminee() {
        boolean bleuPresent = false;
        boolean rougePresent = false;

        for (Carreau carreau : carreaux) {
            if (!carreau.getGuerriersBleus().isEmpty()) {
                bleuPresent = true;
            }
            if (!carreau.getGuerriersRouges().isEmpty()) {
                rougePresent = true;
            }
        }

        // La partie est terminée si une seule couleur est présente ou si aucun guerrier n'est présent
        return !bleuPresent || !rougePresent;
    }

    /**
     * Détermine la couleur gagnante lorsqu'une partie se termine.
     *
     * @return La couleur gagnante, ou {@code null} s'il n'y a pas de gagnant (égalité ou aucun guerrier).
     */
    public Couleur getGagnant() {
        boolean bleuPresent = false;
        boolean rougePresent = false;

        for (Carreau carreau : carreaux) {
            if (!carreau.getGuerriersBleus().isEmpty()) {
                bleuPresent = true;
            }
            if (!carreau.getGuerriersRouges().isEmpty()) {
                rougePresent = true;
            }
        }

        if (bleuPresent && !rougePresent) {
            return Couleur.BLEU; // L'équipe bleue a gagné
        } else if (rougePresent && !bleuPresent) {
            return Couleur.ROUGE; // L'équipe rouge a gagné
        } else {
            return null; // Aucun gagnant (égalité ou aucun guerrier)
        }
    }

    /**
     * @return Le tableau de carreaux composant le plateau.
     */
    public Carreau[] getCarreaux() {
        return carreaux;
    }

    /**
     * @return Le premier carreau où les guerriers bleus commencent.
     */
    public Carreau getDepartBleu() {
        return carreaux[0];
    }

    /**
     * @return Le dernier carreau où les guerriers rouges commencent.
     */
    public Carreau getDepartRouge() {
        return carreaux[longueur - 1];
    }

    /**
     * @return La longueur du plateau.
     */
    public int getTaille() {
        return longueur;
    }
}