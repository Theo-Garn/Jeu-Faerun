package jeu;

/**
 * Représente un guerrier de type Nain dans le jeu.
 * Les Nains sont connus pour leur robustesse et subissent des dégâts réduits de moitié.
 */
public class Nain extends Guerrier {

    /**
     * Constructeur par défaut de la classe Nain.
     * Définit le coût en ressources pour l'entraînement à 1.
     */
    public Nain(){
        this.setRessoucesPourEntrainement(1);
        this.getRessourcesPourEntrainement();
    }

    /**
     * Permet au Nain de subir des dégâts.
     * Les dégâts subis sont réduits de 50 % avant d'être déduits de ses points de vie.
     *
     * @param degats Le nombre de dégâts infligés au Nain.
     */
    @Override
    protected void subirDegats(int degats) {
        int degatsReels = (int) (degats * 0.5); // Réduction des dégâts subis de moitié
        System.out.println("Nain subit " + degatsReels + " dégâts après réduction !");
        this.pointsDeVie -= degatsReels;
    }
    @Override
    public int getRessourcesPourEntrainement() {return 1;}
}