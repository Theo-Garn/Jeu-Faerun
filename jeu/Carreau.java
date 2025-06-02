package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carreau {
    private ArrayList<Guerrier> guerriersBleus = new ArrayList<>();
    private ArrayList<Guerrier> guerriersRouges = new ArrayList<>();

    /**
     * Constructeur par défaut. Initialise des listes vides pour les guerriers bleus et rouges.
     */
    public Carreau() {
        this.guerriersBleus = new ArrayList<>();
        this.guerriersRouges = new ArrayList<>();
    }

    /**
     * Obtient la liste des guerriers bleus actuellement présents sur le carreau.
     *
     * @return Une liste des guerriers bleus.
     */
    public ArrayList<Guerrier> getGuerriersBleus() {
        return guerriersBleus;
    }

    /**
     * Obtient la liste des guerriers rouges actuellement présents sur le carreau.
     *
     * @return Une liste des guerriers rouges.
     */
    public ArrayList<Guerrier> getGuerriersRouges() {
        return guerriersRouges;
    }

    /**
     * Ajoute des guerriers bleus à la liste actuelle des guerriers bleus présents sur le carreau.
     *
     * @param guerriers Une liste de guerriers bleus à ajouter.
     */
    public void ajouterGuerriersBleus(List<Guerrier> guerriers) {
        guerriersBleus.addAll(guerriers);
    }

    /**
     * Ajoute des guerriers rouges à la liste actuelle des guerriers rouges présents sur le carreau.
     *
     * @param guerriers Une liste de guerriers rouges à ajouter.
     */
    public void ajouterGuerriersRouges(List<Guerrier> guerriers) {
        guerriersRouges.addAll(guerriers);
    }

    /**
     * Retire tous les guerriers bleus du carreau.
     *
     * @return Une nouvelle liste contenant les guerriers bleus retirés du carreau.
     */
    public List<Guerrier> retirerGuerriersBleus() {
        List<Guerrier> guerriersADeplacer = new ArrayList<>(guerriersBleus);
        guerriersBleus.clear();
        return guerriersADeplacer;
    }

    /**
     * Retire tous les guerriers rouges du carreau.
     *
     * @return Une nouvelle liste contenant les guerriers rouges retirés du carreau.
     */
    public List<Guerrier> retirerGuerriersRouges() {
        List<Guerrier> guerriersADeplacer = new ArrayList<>(guerriersRouges);
        guerriersRouges.clear();
        return guerriersADeplacer;
    }

    /**
     * Supprime tous les guerriers (bleus et rouges) du carreau.
     */
    public void supprimerGuerrier(){
        retirerGuerriersBleus();
        retirerGuerriersRouges();
    }

    /**
     * Vérifie si le carreau contient au moins un guerrier bleu.
     *
     * @return {@code true} si un ou plusieurs guerriers bleus sont présents sur le carreau, sinon {@code false}.
     */
    public boolean estBleu() {
        return !guerriersBleus.isEmpty();
    }

    /**
     * Vérifie si le carreau contient au moins un guerrier rouge.
     *
     * @return {@code true} si un ou plusieurs guerriers rouges sont présents sur le carreau, sinon {@code false}.
     */
    public boolean estRouge() {
        return !guerriersRouges.isEmpty();
    }

    /**
     * Vérifie si le carreau est un champ de bataille, c'est-à-dire s'il contient à la fois
     * des guerriers bleus et rouges.
     *
     * @return {@code true} si le carreau contient à la fois des guerriers bleus et rouges, sinon {@code false}.
     */
    public boolean estChampDeBataille() {
        return estBleu() && estRouge();
    }

    /**
     * Lance un combat entre les guerriers bleus et rouges présents sur le carreau.
     * Les guerriers s'affrontent un par un, et ceux qui meurent sont retirés de leur liste respective.
     * Le combat se poursuit tant qu'il reste des guerriers des deux côtés.
     */
    public void lanceCombat() {
        System.out.println("💥 Combat sur ce carreau !");
        Iterator<Guerrier> iteratorBleus = guerriersBleus.iterator();
        Iterator<Guerrier> iteratorRouges = guerriersRouges.iterator();

        while (!guerriersBleus.isEmpty() && !guerriersRouges.isEmpty()) {
            Guerrier guerrierBleu = guerriersBleus.get(0); // Le premier guerrier bleu
            Guerrier guerrierRouge = guerriersRouges.get(0); // Le premier guerrier rouge

            System.out.printf("🛡️ %s (Bleu, PV: %d) VS %s (Rouge, PV: %d)\n",
                    guerrierBleu.getClass().getSimpleName(),
                    guerrierBleu.getPointsDeVie(),
                    guerrierRouge.getClass().getSimpleName(),
                    guerrierRouge.getPointsDeVie()
            );

            // Le guerrier bleu attaque le rouge
            guerrierBleu.attaquer(guerrierRouge);

            // Si le guerrier rouge meurt, il est supprimé
            if (!guerrierRouge.estVivant()) {
                System.out.printf("☠️ %s (Rouge) meurt...\n", guerrierRouge.getClass().getSimpleName());
                guerriersRouges.remove(guerrierRouge);
                continue; // Continue pour permettre au guerrier bleu de combattre un autre rouge
            }

            // Le guerrier rouge attaque le bleu
            guerrierRouge.attaquer(guerrierBleu);

            // Si le guerrier bleu meurt, il est supprimé
            if (!guerrierBleu.estVivant()) {
                System.out.printf("☠️ %s (Bleu) meurt...\n", guerrierBleu.getClass().getSimpleName());
                guerriersBleus.remove(guerrierBleu);
            }
        }

        // Résultat final du combat sur ce carreau
        if (guerriersBleus.isEmpty() && guerriersRouges.isEmpty()) {
            System.out.println("⚔️ Les deux camps sont anéantis sur ce carreau !");
        } else if (guerriersBleus.isEmpty()) {
            System.out.println("⚔️ Les rouges ont remporté ce combat !");
        } else if (guerriersRouges.isEmpty()) {
            System.out.println("⚔️ Les bleus ont remporté ce combat !");
        }
    }



    /**
     * Retourne une représentation du carreau sous forme de chaîne de caractères.
     * La chaîne contient les listes actuelles de guerriers bleus et rouges.
     *
     * @return Une chaîne contenant les guerriers bleus et rouges présents sur le carreau.
     */
    @Override
    public String toString() {
        return "Bleus: " + guerriersBleus + " | Rouges: " + guerriersRouges;
    }
}

