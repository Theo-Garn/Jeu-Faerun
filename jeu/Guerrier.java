package jeu;

/**
 * Classe abstraite représentant un guerrier dans le jeu.
 * Les guerriers possèdent des caractéristiques comme la force, les points de vie,
 * une affiliation à un château et une couleur d'équipe.
 * Cette classe sert de base pour définir différents types de guerriers.
 */
public abstract class Guerrier {
    protected int force;
    protected int pointsDeVie;
    private Chateau chateau;  // Le château d'origine du guerrier
    private Couleur couleur;

    /**
     * La force de base d'un guerrier.
     */
    public static final int FORCE_BASE = 10;

    /**
     * Les points de vie maximum de base pour un guerrier.
     */
    public static final int PV_MAX_BASE = 100;

    /**
     * Le coût de ressources minimum pour entraîner un guerrier.
     */
    public static final int RESSOURCE_BASE = 1;

    private int ressources;

    /**
     * Constructeur par défaut de la classe Guerrier.
     * Initialise les valeurs de base : la force, les points de vie maximum et le château d'origine.
     */
    public Guerrier() {
        this.force = FORCE_BASE;
        this.setPointsDeVie(PV_MAX_BASE);
        this.setChateau(chateau);
        this.setRessoucesPourEntrainement(1);
    }

    /**
     * @return La force actuelle du guerrier.
     */
    public int getForce() {
        return force;
    }

    /**
     * @return Le nombre de points de vie restants du guerrier.
     */
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    /**
     * Définit les points de vie du guerrier, en s'assurant qu'ils ne soient pas négatifs.
     *
     * @param pointsDeVie Nouveau total de points de vie.
     */
    private void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = Math.max(0, pointsDeVie);
    }

    /**
     * @return {@code true} si le guerrier est encore en vie (points de vie > 0), sinon {@code false}.
     */
    public boolean estVivant() {
        return pointsDeVie > 0;
    }

    /**
     * @return Le coût en ressources pour entraîner ce guerrier.
     */
    public int getRessourcesPourEntrainement() {
        return ressources;
    }

    /**
     * Définit le château d'origine du guerrier.
     *
     * @param chateau Le château auquel ce guerrier appartient.
     */
    public void setChateau(Chateau chateau) {
        this.chateau = chateau;
    }

    /**
     * @return La couleur d'équipe du guerrier, basée sur celle de son château.
     */
    public Couleur getcouleur() {
        return chateau.getCouleur();
    }

    /**
     * @return {@code true} si le guerrier appartient à l'équipe bleue, sinon {@code false}.
     */
    public boolean estBleu() {
        return chateau != null && chateau.estBleu();
    }

    /**
     * @return {@code true} si le guerrier appartient à l'équipe rouge, sinon {@code false}.
     */
    public boolean estRouge() {
        return chateau != null && chateau.estRouge();
    }

    /**
     * Permet au guerrier d'attaquer un adversaire.
     * Les dégâts infligés sont calculés à l'aide de l'utilitaire {@code GuerrierUtilitaire}.
     *
     * @param adversaire Le guerrier à attaquer.
     */
    public void attaquer(Guerrier adversaire) {
        int degats = PlateauUtilitaire.De3() + this.force; // Force du guerrier + dégâts aléatoires (dé 3 faces)
        System.out.printf("⚔️ %s attaque %s et inflige %d dégâts !\n",
                this.getClass().getSimpleName(),
                adversaire.getClass().getSimpleName(),
                degats
        );
        adversaire.subirDegats(degats);
    }


    /**
     * Définit le coût en ressources pour entraîner ce type de guerrier.
     *
     * @param cout Le coût en ressources d'entraînement.
     */
    protected void setRessoucesPourEntrainement(int cout) {
        this.ressources = RESSOURCE_BASE;
    }

    /**
     * Méthode abstraite permettant au guerrier de subir des dégâts.
     * Elle doit être implémentée par les sous-classes pour définir le comportement spécifique.
     *
     * @param degats Le nombre de dégâts subis par le guerrier.
     */
    protected abstract void subirDegats(int degats);
}