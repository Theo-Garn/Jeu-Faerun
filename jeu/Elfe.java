package jeu;

/**
 * Représente un guerrier de type Elfe.
 * Les elfes possèdent une force deux fois supérieure à la force de base et nécessitent
 * 2 ressources pour leur entraînement.
 */
public class Elfe extends Guerrier {

    /**
     * Constructeur de la classe Elfe.
     * Initialise la force d'un elfe à une valeur double de la force de base
     * et définit à 2 le nombre de ressources nécessaires pour leur entraînement.
     */
    public Elfe() {
        this.force = FORCE_BASE * 2; // Un Elfe a une force double
        this.setRessoucesPourEntrainement(2); // Nécessite 2 ressources pour l'entraînement
        this.getRessourcesPourEntrainement();
    }

    /**
     * Permet à l'Elfe de subir des dégâts.
     * Réduit les points de vie en fonction des dégâts subis.
     *
     * @param degats Le nombre de dégâts infligés à l'Elfe.
     */
    @Override
    protected void subirDegats(int degats) {
        System.out.println("Elfe subit " + degats + " dégâts !");
        this.pointsDeVie -= degats; // L'Elfe subit les dégâts
    }
    @Override
    public int getRessourcesPourEntrainement() {return 2;}
}



