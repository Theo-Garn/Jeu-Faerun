package jeu;

/**
 * La classe ChefElfe représente un chef parmi les elfes, disposant d'une force doublée
 * par rapport à un elfe standard et nécessitant plus de ressources pour son entraînement.
 */
public class ChefElfe extends Elfe {

    /**
     * Constructeur de la classe ChefElfe.
     * Le chef elfe a une force doublée par rapport à un elfe standard.
     * Le coût d'entraînement est fixé à 4 ressources.
     */
    public ChefElfe() {
        this.force = getForce() * 2; // Double la force par rapport à un elfe normal
        this.setRessoucesPourEntrainement(4); // Définit les ressources nécessaires pour l'entraînement
        this.getRessourcesPourEntrainement();
    }
    @Override
    protected void subirDegats(int degats) {
        System.out.println("ChefElfe subit " + degats + " dégâts !");
        this.pointsDeVie -= degats;
    }
    @Override
    public int getRessourcesPourEntrainement() {return 4;}
}
