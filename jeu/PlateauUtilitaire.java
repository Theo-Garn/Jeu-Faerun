package jeu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe utilitaire pour le plateau du jeu.
 * Fournit des méthodes pour gérer les interactions, effectuer des lancers de dés,
 * et afficher des informations sur l'état du plateau et des guerriers.
 */
public class PlateauUtilitaire {

    private static final Random RANDOM = new Random();

    /**
     * Simule un lancer d'un dé à 3 faces.
     *
     * @return Un entier aléatoire entre 1 et 3 inclus.
     */
    public static int De3() {
        return RANDOM.nextInt(3) + 1;
    }

    public static void afficherEntrainement(Chateau chateau) {
        System.out.println("\n Château " + (chateau.estBleu() ? "Bleu" : "Rouge") + " - Entraînement");
        System.out.println("Ressources disponibles : " + chateau.getRessources());

        ArrayList<Guerrier> guerriersEntraines = chateau.entrainer();
        if (guerriersEntraines.isEmpty()) {
            System.out.println("Pas assez de ressources pour entraîner des guerriers.");
        } else {
            System.out.println("Guerriers entraînés ce tour : ");
            for (Guerrier g : guerriersEntraines) {
                System.out.println("  - " + g.getClass().getSimpleName() + " (Force : " + g.getForce() + ", PV : " + g.getPointsDeVie() + ")");
            }
        }

        System.out.println("Guerriers restants dans la file d'attente : " + chateau.getGuerriersNovices().size());
        System.out.println("----------------------------------------");
    }


    /**
     * Simule plusieurs lancers d'un dé à 3 faces et retourne la somme des résultats.
     *
     * @param nombreLances Le nombre de lancers du dé.
     * @return La somme des résultats des lancers.
     */
    public static int De3(int nombreLances) {
        int somme = 0;
        for (int i = 0; i < nombreLances; i++) {
            somme += De3();
        }
        return somme;
    }


    /**
     * Affiche l'état du plateau avec les guerriers présents sur chaque carreau.
     *
     * @param plateau Le plateau dont on souhaite afficher l'état.
     */
    public static void afficherPlateau(Plateau plateau) {
        System.out.println("\n État du Plateau :");
        System.out.println("------------------------------------------------------------------------------");
        Carreau[] carreaux = plateau.getCarreaux();

        for (int i = 0; i < carreaux.length; i++) {
            Carreau carreau = carreaux[i];
            String bleus = formatGuerriers(carreau.getGuerriersBleus(), "Bleus");
            String rouges = formatGuerriers(carreau.getGuerriersRouges(), "Rouges");
            System.out.printf(" Carreau %2d | %-40s | %-40s\n", (i + 1), bleus, rouges);
        }

        System.out.println("------------------------------------------------------------------------------");
    }

    /**
     * Formatte une liste de guerriers pour un affichage lisible.
     *
     * @param guerriers La liste des guerriers à afficher.
     * @param equipe    L'équipe associée ("Bleus" ou "Rouges").
     * @return Une représentation formatée des guerriers.
     */
    private static String formatGuerriers(List<Guerrier> guerriers, String equipe) {
        if (guerriers.isEmpty()) return "-";
        StringBuilder sb = new StringBuilder(equipe + " : ");
        for (Guerrier g : guerriers) {
            sb.append(g.getClass().getSimpleName()).append("(F:").append(g.getForce()).append(", PV:").append(g.getPointsDeVie()).append("), ");
        }
        return sb.toString();
    }


    /**
     * Affiche l'équipe gagnante à la fin de la partie.
     *
     * @param plateau Le plateau pour lequel on détermine et affiche l'équipe gagnante.
     */
    public static void afficherGagnant(Plateau plateau) {
        Couleur gagnant = plateau.getGagnant();
        if (gagnant == null) {
            System.out.println("Aucune équipe n'a gagné pour l'instant.");
        } else {
            System.out.println("L'équipe gagnante est : " + gagnant);
        }
    }

    /**
     * Affiche les guerriers présents sur un carreau spécifique.
     *
     * @param carreau Le carreau dont on souhaite afficher les guerriers.
     */
    public static void afficherGuerriersCarreau(Carreau carreau) {
        List<Guerrier> guerriersBleus = carreau.getGuerriersBleus();
        List<Guerrier> guerriersRouges = carreau.getGuerriersRouges();

        System.out.println("  Guerriers Bleus :");
        for (Guerrier guerrier : guerriersBleus) {
            System.out.println("    - Force : " + guerrier.getForce() + ", PV : " + guerrier.getPointsDeVie());
        }

        System.out.println("  Guerriers Rouges :");
        for (Guerrier guerrier : guerriersRouges) {
            System.out.println("    - Force : " + guerrier.getForce() + ", PV : " + guerrier.getPointsDeVie());
        }
    }
}