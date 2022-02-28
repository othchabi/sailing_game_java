package voiliers.statutjeu;


import voiliers.Jeu;


import java.awt.*;

/**
 * Le statut d'un jeu peut etre course ou en pause ou dans le menu principale.
 *
 */

public abstract class Statut {

    private static Statut statut=null;
    /**
     *  Le jeu qui est associe a ce statut.
     */
    protected Jeu jeu;

    /**
     *
     * @param statut2
     *      impose le statut du jeu.
     *
     */
    public static void setStatut(Statut statut2){

        statut=statut2;
    }

    /**
     *
     * @return le statut du jeu.
     */
    public static Statut getStatut(){

        return statut;
    }



    /**
     *
     * @param jeu
     *      construit l'objet statut a partir du jeu
     *
     *
     */
    public Statut(Jeu jeu)
    {
        this.jeu=jeu;
    }

    public abstract void update();

    public abstract void render(Graphics g);



}
