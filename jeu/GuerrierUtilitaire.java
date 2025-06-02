package jeu;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe utilitaire pour les opérations liées aux guerriers.
 * Fournit des méthodes pour lancer des dés, afficher les informations des guerriers,
 * et effectuer d'autres tâches liées au combat.
 */
public class GuerrierUtilitaire {
    private static Random random = new Random();

    /**
     * Simule un lancer d'un dé à 3 faces.
     *
     * @return Un entier aléatoire entre 1 et 3 inclus.
     */
    public static int de3() {
        return random.nextInt(3) + 1;
    }

    /**
     * Simule plusieurs lancers d'un dé à 3 faces puis calcule la somme obtenue.
     *
     * @param nombreLance Le nombre de lancers du dé.
     * @return La somme des lancers du dé.
     */
    public static int de3(int nombreLance) {
        int somme = 0;
        for (int i = 0; i < nombreLance; i++) {
            somme += de3();
        }
        return somme;
    }

    /**
     * Affiche les guerriers présents dans une liste.
     *
     * @param guerriers La liste des guerriers à afficher.
     * @param equipe    Le nom de l'équipe (e.g. "Bleus" ou "Rouges") pour le contexte.
     */
    public static void afficherGuerriersListe(ArrayList<Guerrier> guerriers, String equipe) {
        System.out.println("Guerriers " + equipe + " :");
        if (guerriers.isEmpty()) {
            System.out.println("    Aucun guerrier présent.");
        } else {
            for (Guerrier guerrier : guerriers) {
                System.out.println(guerrier.getClass().getSimpleName() +"    - Force : " + guerrier.getForce() + ", Points de Vie : " + guerrier.getPointsDeVie());
            }
        }
    }

    /**
     * Affiche les guerriers présents sur un carreau spécifique, en différenciant les deux équipes.
     *
     * @param carreau Le carreau dont on souhaite afficher les guerriers.
     */
    public static void afficherGuerriersCarreau(Carreau carreau) {
        System.out.println("État du Carreau :");
        afficherGuerriersListe(carreau.getGuerriersBleus(), "Bleus");
        afficherGuerriersListe(carreau.getGuerriersRouges(), "Rouges");
    }

    /**
     * Affiche les guerriers présents sur chaque carreau du plateau.
     *
     * @param plateau Le plateau à afficher.
     */
    public static void afficherGuerriersPlateau(Plateau plateau) {
        Carreau[] carreaux = plateau.getCarreaux();
        for (int i = 0; i < carreaux.length; i++) {
            System.out.println("Carreau " + i + " :");
            afficherGuerriersCarreau(carreaux[i]);
        }
    }

    /**
     * Affiche les informations d'un guerrier individuel.
     * Peut être utilisée pour des détails plus précis ou spécifiques.
     *
     * @param guerrier Le guerrier à afficher.
     */
    public static void afficherGuerrierIndividuel(Guerrier guerrier) {
        System.out.println("Guerrier :");
        System.out.println("  Force : " + guerrier.getForce());
        System.out.println("  Points de Vie : " + guerrier.getPointsDeVie());
        System.out.println("  Type : " + guerrier.getClass().getSimpleName()); // Nom de la classe du guerrier
    }
}
