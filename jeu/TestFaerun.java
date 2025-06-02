package jeu;

import java.util.ArrayList;
import java.util.Scanner;

public class TestFaerun {

    public static void main(String[] args) {
        // Initialisation des objets nécessaires
        Scanner scanner = new Scanner(System.in);
        Chateau chateauBleu = new Chateau(Couleur.BLEU);
        Chateau chateauRouge = new Chateau(Couleur.ROUGE);
        Plateau plateau = new Plateau(5);

        // Ajout des guerriers novices au château Bleu
        System.out.println("Ajoutez des guerriers novices pour le Château Bleu :");
        demanderGuerriers(chateauBleu, scanner);

        // Ajout des guerriers novices au château Rouge
        System.out.println("Ajoutez des guerriers novices pour le Château Rouge :");
        demanderGuerriers(chateauRouge, scanner);

        // Entraîner les guerriers pour les deux châteaux
        ArrayList<Guerrier> guerriersBleusEntraines = chateauBleu.entrainer();
        ArrayList<Guerrier> guerriersRougesEntraines = chateauRouge.entrainer();

        // Placement des guerriers entraînés sur le plateau
        plateau.ajouterGuerriers(chateauBleu, guerriersBleusEntraines);
        plateau.ajouterGuerriers(chateauRouge, guerriersRougesEntraines);


        // Étape 3 : Simulation du déroulement du jeu
        System.out.println("===== DÉBUT DE LA PARTIE =====");
        int tour = 0;
        while (!plateau.estPartieTerminee()) {
            tour++;
            System.out.println("--- Tour " + tour + " ---");

            // Entraîner les guerriers pour les deux châteaux
            guerriersBleusEntraines = chateauBleu.entrainer();
            guerriersRougesEntraines = chateauRouge.entrainer();

            // Placement des guerriers entraînés sur le plateau
            plateau.ajouterGuerriers(chateauBleu, guerriersBleusEntraines);
            plateau.ajouterGuerriers(chateauRouge, guerriersRougesEntraines);

            // Affiche l'état initial du plateau
            PlateauUtilitaire.afficherPlateau(plateau);

            // Étape 3.1 : Entraînement des guerriers novices
            ArrayList<Guerrier> guerriersBleus = chateauBleu.entrainer();
            ArrayList<Guerrier> guerriersRouges = chateauRouge.entrainer();

            // Placement des guerriers entraînés
            if (!guerriersBleus.isEmpty()) {
                plateau.ajouterGuerriers(chateauBleu, guerriersBleus);
                System.out.println("Guerriers BLEUS entraînés et placés sur le plateau :");
                GuerrierUtilitaire.afficherGuerriersListe(guerriersBleus, "Bleus");
            }
            if (!guerriersRouges.isEmpty()) {
                plateau.ajouterGuerriers(chateauRouge, guerriersRouges);
                System.out.println("Guerriers ROUGES entraînés et placés sur le plateau :");
                GuerrierUtilitaire.afficherGuerriersListe(guerriersRouges, "Rouges");
            }

            // Étape 3.2 : Déplacement des guerriers
            plateau.deplacerGuerriers();

            // Étape 3.3 : Lancer les combats
            plateau.lanceCombat();

            // Afficher l'état du plateau après le déplacement et les combats
            System.out.println("État du plateau après les déplacements et combats :");
            PlateauUtilitaire.afficherPlateau(plateau);
        }

        // Résultat final : gagnant ou égalité
        System.out.println("===== FIN DE LA PARTIE =====");
        PlateauUtilitaire.afficherGagnant(plateau);

        scanner.close();
    }

    // Permet à l'utilisateur de sélectionner les guerriers pour chaque château au début
    public static void demanderGuerriers(Chateau chateau, Scanner scanner) {
        System.out.println("Château " + chateau.getCouleur() + " : Choisissez 5 guerriers à recruter comme novices.");
        int i = 1;
        Guerrier guerrieraffichage;
        while (i <= 5) {
            System.out.println("Guerrier " + i + " :");
            guerrieraffichage = new Nain();
            System.out.println("1. Nain coûte" + guerrieraffichage.getRessourcesPourEntrainement());
            guerrieraffichage = new ChefNain();
            System.out.println("2. Chef Nain coûte" + guerrieraffichage.getRessourcesPourEntrainement());
            guerrieraffichage = new Elfe();
            System.out.println("3. Elfecoûte" + guerrieraffichage.getRessourcesPourEntrainement());
            guerrieraffichage = new ChefElfe();
            System.out.println("4. Chef Elfe coûte" + guerrieraffichage.getRessourcesPourEntrainement());
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();
            Guerrier guerrier;

            if (choix == 1) {
                guerrier = new Nain();
            } else if (choix == 2) {
                guerrier = new ChefNain();
            } else if (choix == 3) {
                guerrier = new Elfe();
            } else if (choix == 4) {
                guerrier = new ChefElfe();
            } else {
                System.out.println("Choix invalide ! Un Nain sera ajouté par défaut.");
                guerrier = new Nain();
            }

            guerrier.setChateau(chateau);
            chateau.ajoutGuerrierNovice(guerrier);
            i++;
        }
    }
}
