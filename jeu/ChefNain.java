package jeu;

/**
 * Représente un Chef Nain, une version améliorée et plus résistante des Nains dans le jeu.
 * Un Chef Nain subit encore moins de dégâts que les Nains ordinaires
 * et nécessite plus de ressources pour l'entraînement.
 */
public class ChefNain extends Nain {

    /**
     * Constructeur par défaut d'un Chef Nain.
     * Définit le coût en ressources pour l'entraînement à 3.
     */
    public ChefNain() {
        this.setRessoucesPourEntrainement(3);
        this.getRessourcesPourEntrainement();
    }

    /**
     * Permet au Chef Nain de subir des dégâts, avec une réduction de 75 %.
     *
     * @param degats Le nombre de dégâts infligés au Chef Nain avant réduction.
     */
    @Override
    protected void subirDegats(int degats) {
        int degatsReels = (int) (degats * 0.25); // Réduction des dégâts (75 % de réduction)
        System.out.println("Chef Nain subit " + degatsReels + " dégâts après réduction !");
        this.pointsDeVie -= degatsReels;
    }
    @Override
    public int getRessourcesPourEntrainement() {return 3;}
}