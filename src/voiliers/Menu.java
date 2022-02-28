package voiliers;

import java.awt.*;


import voiliers.entite.player.Joueur;
import voiliers.statutjeu.Course;

import voiliers.images.ImageEntite;

/**
 *
 * Menu affichant les informations du jeu.
 */
public class Menu {
    /**
     * position x du menu par rapport au jeu
     */

    private static int posmenux;
    /**
     * position y du menu par rapport au jeu
     */
    private static int posmenuy;
    /**
     * Largeur du menu de la partie.
     */
    private static int widthmenu;
    /**
     *
     * Hauteur du menu de la partie.
     */
    private static int heightmenu;
    /**
     *
     * Informations concerant le joueur et sa position
     */
    private static float posjoueurx,posjoueury,anglejoueur;
    /**
     *
     * Joueur de la partie.
     */
    private Joueur player;


    public Menu(Jeu jeu, Course statut) {

        this.posjoueurx = 12;
        this.posjoueury = 1;

        this.widthmenu = 150;
        this.posmenux = jeu.getWidth() - widthmenu;
        this.posmenuy = 0;
        this.heightmenu = jeu.getHeight();
        this.player = statut.getplayer();
        this.posjoueurx = player.getX();
        this.posjoueury = player.getY();
        this.anglejoueur = player.getangle();


    }

    /**
     * Rafraichit le menu avec les nouvelles informations.
     */
    public void update() {

        this.posjoueurx = player.getX();
        this.posjoueury = player.getY();
        this.anglejoueur = player.getangle();


    }

    /**
     *
     * Dessine les elements du menu.
     * @param g
     */

    public void render(Graphics g) {


        g.setColor(Color.GRAY);
        g.fillRect(posmenux, posmenuy, widthmenu, heightmenu);
        g.drawImage(ImageEntite.boussole, posmenux + 12, posmenuy + 12, null);
        g.setColor(Color.black);
        g.drawString("Joueur : " + player.getTypebateau(), posmenux + 10, posmenuy + 140);

        g.drawString("Coordonee X : " + (int) posjoueurx, posmenux + 15, posmenuy + 160);
        g.drawString("Coordonee Y : " + (int) posjoueury, posmenux + 15, posmenuy + 180);

        g.drawString("Vitesse bateau : "+player.getvitessedeplacement()*100 + "km/h", posmenux + 7, posmenuy + 200);

        g.drawString("MON CAP  : " + angletocap(anglejoueur), posmenux + 15, posmenuy + 220);

        g.drawString("Informations sur la Zone : " , posmenux + 10, posmenuy + 260);



        g.drawString("Direction du vent : "  , posmenux + 15, posmenuy + 280);

        g.drawString(""+ angletocap(player.getZone().getAnglevent()) , posmenux + 15, posmenuy + 300);

        g.drawString("Vitesse du vent : " , posmenux + 15, posmenuy + 320);

        g.drawString("" + player.getZone().getVitessevent(), posmenux + 15, posmenuy + 340);

        g.drawString("Hauteur des vagues : ", posmenux + 15, posmenuy + 360);

        g.drawString("" + player.getZone().getHauteurvague(), posmenux + 15, posmenuy + 380);

    }

    /**
     *
     * Transforme les angles en direction (NORD-SUD/EST..).
     * @param angle
     *    Un angle (vent/joueur).
     * @return Orientation (NORD-SUD/EST..).
     *
     */
    public String angletocap(float angle) {

        if ((Math.abs(angle) == 0) || (Math.abs(angle) == 360)) {
            return "NORD";
        }
        if ((Math.abs(angle) == 180)) {
            return "SUD";
        }
        if ((Math.abs(angle) == 90) || ((angle) == -270 )) {
            return "EST";
        }
        if ((Math.abs(angle) == 270) || ((angle) == -90 )) {
            return "WEST";
        }
        if ((((angle) > 0) && ((angle) < 90)) || ((Math.abs(angle) > 270) && ((angle) < 0 )) ) {
            return "NORD-EST";
        }
        if ((((angle) > 90) && ((angle) < 180)) || ((Math.abs(angle) > 180) && ((angle) > -270 ) && ((angle) < 0 )) ) {
            return "SUD-EST";
        }

        if ((((angle) > 180) && ((angle) < 270)) || ((Math.abs(angle) > 90) && ((angle) > -180 ) && ((angle) < 0 )) ){
            return "SUD-WEST";
        }
        if ( ( (angle) > 270)  || ( (Math.abs(angle) > 0) && ((angle) > -90 ) && ((angle) < 0 ))) {
            return "NORD-WEST";
        }

        return "";
    }
}