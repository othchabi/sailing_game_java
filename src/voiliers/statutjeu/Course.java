package voiliers.statutjeu;

import voiliers.entite.player.Joueur;
import voiliers.Jeu;
import voiliers.mapjeu.MapJeu;
import voiliers.Menu;
import java.awt.*;

/**
 * La course est une classe herité de Statut qui represente le jeu quand une course commence.
 */

public class Course extends Statut {
    public Joueur player;
    public MapJeu mapjeu;
    public Menu menu;
    public float x1;
    public float x2;

    /**
     * Initialise les elements de la course comme la map les joueurs et la barre d'informations
     *
     * @param course
     *        Le jeu en cours d'execution.
     */

    public Course(Jeu course) {
        super(course);
        mapjeu = new MapJeu(jeu,"res/map.txt");

        player = new Joueur(jeu,this,100,100, "Geolier",140);

        menu = new Menu(jeu,this);



    }

    /**
     *
     * Met a jour les elements de la course.
     */
    public void update() {

        /*mapjeu.update();*/
        player.maZone(this);
        player.update();
        menu.update();



    }

    /**
     *
     * @return La map du jeu de la course.
     *
     */

    public  MapJeu getmap(){

        return mapjeu;
    }

    /**
     *
     * @return Le joueur de la course .
     */

   public Joueur getplayer() {
       return player;
   }

    /**
     *
     * @param g
     *           Outil de dessin des elements de la course.
     */


    public void render(Graphics g) {
        mapjeu.render(g);
        menu.render(g);
        player.render(g);

    }
}
