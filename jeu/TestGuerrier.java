/*package jeu;

public class TestGuerrier {
    public static void main(String[] args) {
        Guerrier nain = new Nain();
        Guerrier elfe = new Elfe();
        Guerrier chefNain = new ChefNain();
        Guerrier chefElfe = new ChefElfe();

        System.out.println("Début du combat !");

        GuerrierUtilitaire.afficheGuerrier(nain, "Nain");
        GuerrierUtilitaire.afficheGuerrier(elfe, "Elfe");
        GuerrierUtilitaire.afficheGuerrier(chefNain, "Chef Nain");
        GuerrierUtilitaire.afficheGuerrier(chefElfe, "Chef Elfe");

        System.out.println("--- COMBAT NAIN VS ELFE ---");
        combat(nain, elfe);

        System.out.println("--- COMBAT CHEF NAIN VS CHEF ELFE ---");
        combat(chefNain, chefElfe);
    }

    public static void combat(Guerrier guerrier1, Guerrier guerrier2) {
        int tour = 1;
        while (guerrier1.estVivant() && guerrier2.estVivant()) {
            System.out.println("Tour " + tour);

            // Guerrier 1 attaque seulement s'il est encore en vie
            if (guerrier1.estVivant()) {
                guerrier1.attaquer(guerrier2);
                GuerrierUtilitaire.afficheGuerrier(guerrier2, guerrier2.getClass().getSimpleName());
            }

            // Guerrier 2 attaque seulement s'il est encore en vie
            if (guerrier2.estVivant()) {
                guerrier2.attaquer(guerrier1);
                GuerrierUtilitaire.afficheGuerrier(guerrier1, guerrier1.getClass().getSimpleName());
            }

            tour++;
        }
        System.out.println("Le combat est terminé !");
    }
}
*/