package jeu;

/**
 * Représente les couleurs possibles dans le jeu.
 * Les couleurs sont utilisées pour identifier les équipes ou les éléments appartenant à celles-ci.
 */
public enum Couleur {
    /**
     * Représente la couleur bleue.
     */
    BLEU,

    /**
     * Représente la couleur rouge.
     */
    ROUGE;

    /**
     * Renvoie une représentation sous forme de chaîne de caractères colorée.
     * Le bleu est représenté avec le code ANSI 34, et le rouge avec le code ANSI 31.
     *
     * @return Une chaîne de caractères représentant la couleur avec un code de couleur ANSI.
     */
    @Override
    public String toString() {
        // 34 bleu 31 rouge
        String couleur = "";
        if (this == BLEU) {
            couleur = "34";
        } else {
            couleur = "31";
        }
        return "\033[" + couleur + "m" + super.toString() + "\033[0m";
    }
}
