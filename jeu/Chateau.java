package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class Chateau {
    private Couleur couleur; // La couleur du château (Bleu ou Rouge)
    private int ressources; // Nombre actuel de ressources disponibles dans le château
    private LinkedList<Guerrier> guerriersNovices; // Liste des guerriers novices dans le château

    private static final int RESSOURCES_INITIAL = 3; // Nombre de ressources initiales d'un château
    private static final int RESSOURCE_AJOUTEE_PAR_TOUR = 1; // Ressources ajoutées par tour

    /**
     * Constructeur d'un château avec une couleur spécifique et des ressources initiales.
     *
     * @param couleur La couleur du château (BLEU ou ROUGE).
     */
    public Chateau(Couleur couleur) {
        this.setCouleur(couleur);
        this.ressources = RESSOURCES_INITIAL;
        this.guerriersNovices = new LinkedList<>();
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Ajoute un guerrier novice au château, s'il correspond à la couleur du château.
     *
     * @param guerrier Le guerrier à ajouter.
     */
    public void ajoutGuerrierNovice(Guerrier guerrier) {
        if (guerrier.getcouleur().compareTo(this.couleur) == 0) {
            this.guerriersNovices.addLast(guerrier);
        }
    }

    /**
     * Retourne le nombre actuel de ressources disponibles dans le château.
     *
     * @return Le nombre de ressources disponibles.
     */
    public int getRessources() {
        return ressources;
    }


    /**
     * Retourne la liste des guerriers novices actuellement présents dans le château.
     *
     * @return Une liste de guerriers novices.
     */
    public List<Guerrier> getGuerriersNovices() {
        return guerriersNovices;
    }

    /**
     * Entraîne les guerriers novices qui peuvent l'être en fonction des ressources
     * actuellement disponibles dans le château.
     * Pour chaque guerrier entraîné, les ressources nécessaires sont consommées,
     * et ce guerrier est retiré de la file.
     *
     * Seuls les guerriers pouvant être entraînés (selon les ressources) sont retirés.
     *
     * @return Une liste de guerriers entraînés avec succès.
     */

    public ArrayList<Guerrier> entrainer() {
        // Liste des guerriers entraînés
        ArrayList<Guerrier> guerriersEntraines = new ArrayList<>();

        // Parcours des guerriers novices pour en entraîner un certain nombre
        Iterator<Guerrier> iterateur = this.guerriersNovices.iterator();
        int guerriersRestants = this.guerriersNovices.size(); // Guerriers à entraîner

        while (iterateur.hasNext() && guerriersRestants > 0) {
            Guerrier guerrier = iterateur.next(); // Obtenir le prochain guerrier novice

            // Vérifier si les ressources sont suffisantes pour entraîner ce guerrier
            if (this.ressources >= guerrier.getRessourcesPourEntrainement()) {
                // Entraîner le guerrier
                guerriersEntraines.add(guerrier);

                // Décrémenter les ressources selon le coût de l'entraînement
                this.ressources -= guerrier.getRessourcesPourEntrainement();

                // Retirer le guerrier de la liste des novices
                iterateur.remove();

                // Décrémenter le compteur de guerriers restants
                guerriersRestants--;
            } else {
                // Si pas assez de ressources : passer au tour suivant
                System.out.println("Pas assez de ressources pour entraîner " + guerrier.getClass().getSimpleName());
            }
        }

        // Afficher un message si tous les guerriers n'ont pas pu être entraînés
        if (guerriersRestants > 0) {
            System.out.println("Il reste " + (guerriersRestants) + " guerriers à entraînés car manque de ressources.");
        }

        // Retourner les guerriers entraînés
        incrementerRessources();
        return guerriersEntraines;
    }



    /**
     * Augmente les ressources du château d'un montant fixe défini par {@code RESSOURCE_AJOUTEE_PAR_TOUR}.
     */
    private void incrementerRessources() {
        ressources += RESSOURCE_AJOUTEE_PAR_TOUR;
    }

    /**
     * Retourne la couleur du château.
     *
     * @return La couleur du château.
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Vérifie si la couleur du château est BLEU.
     *
     * @return {@code true} si le château est bleu, sinon {@code false}.
     */
    public boolean estBleu() {
        return couleur == Couleur.BLEU;
    }

    /**
     * Vérifie si la couleur du château est ROUGE.
     *
     * @return {@code true} si le château est rouge, sinon {@code false}.
     */
    public boolean estRouge() {
        return couleur == Couleur.ROUGE;
    }
}
