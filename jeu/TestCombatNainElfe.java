package jeu;

import java.util.ArrayList;

public class TestCombatNainElfe {
    public static void main(String[] args) {
        // Création des guerriers
        Nain nain = new Nain();
        Elfe elfe = new Elfe();

        // Création d'un carreau
        Carreau carreau = new Carreau();

        // Ajout du Nain et de l'Elfe sur le même carreau
        ArrayList<Guerrier> guerriersBleus = new ArrayList<>();
        ArrayList<Guerrier> guerriersRouges = new ArrayList<>();
        guerriersBleus.add(nain);
        guerriersRouges.add(elfe);

        carreau.ajouterGuerriersBleus(guerriersBleus);
        carreau.ajouterGuerriersRouges(guerriersRouges);

        // Affichage initial
        System.out.println("Début du combat !");
        System.out.println("Points de vie initiaux :");
        System.out.println("Nain (Bleu) : " + nain.getPointsDeVie());
        System.out.println("Elfe (Rouge) : " + elfe.getPointsDeVie());

        // Lancement du combat sur la case
        carreau.lanceCombat();

        // Affichage des résultats après le combat
        System.out.println("\nFin du combat !");
        System.out.println("Points de vie restants :");
        System.out.println("Nain (Bleu) : " + nain.getPointsDeVie());
        System.out.println("Elfe (Rouge) : " + elfe.getPointsDeVie());

        // Vérification des survivants
        if (nain.estVivant() && elfe.estVivant()) {
            System.out.println("Le combat s'est terminé, mais les deux guerriers sont toujours vivants.");
        } else if (nain.estVivant()) {
            System.out.println("Le Nain a gagné le combat !");
        } else if (elfe.estVivant()) {
            System.out.println("L'Elfe a gagné le combat !");
        } else {
            System.out.println("Les deux guerriers ont péri dans le combat.");
        }
    }
}