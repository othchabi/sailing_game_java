package voiliers.maptexture;

import java.awt.*;
import java.awt.image.*;

/**
 *  Les elements de la map du jeu.
 *
 */

public class MAP {
    /**
     * Tableau pour sauvegarder les elements de la map;
     */
    public static MAP[] map= new MAP[100];
    /**
     * l'objet plage de la MAP
     */
    public static MAP Plage = new Plage(1);
    /**
     * L'objet EauCalme de la MAP
     */
    public static MAP EauCalme = new EauCalme(2);
    /**
     * L'objet Eauvague1 de la MAP.
     */
    public static MAP EauVague1 = new EauVague1(3);
    /**
     * L'objet Eauvague2 de la MAP.
     */
    public static MAP EauVague2 = new EauVague2(4);
    /**
     * Image.
     */

    protected BufferedImage image;
    /**
     * Objet Graphics pour faire les dessins des elements de la MAP
     */
    protected Graphics g2;
    /**
     * largeur de tous les elements de la MAP.
     */
    public static final int imagewidth=64;
    /**
     * hauteur de tous les elements de la MAP.
     */
    public static final int imageheight=64;
    /**
     *  Numero unique de l'element de la MAP
     */
    protected final int id;

    /**
     *
     * @param image
     *        image associe a l'element.
     * @param id
     *         id de l'element.
     */

    public MAP(BufferedImage image,int id){
        this.image=image;
        this.id=id;

        map[id]=this;


    }

    /**
     *
     * @param g
     *   Objet Graphics pour faire des dessins.
     * @param x
     *    Coordonnee X pour placer l'element de la MAP.
     * @param y
     *    Coordonee Y pour placer l'element de la MAP.
     *
     */

    public void render(Graphics g,int x,int y){



        g.drawImage(image,x,y,imagewidth,imageheight,null);



    }



}
