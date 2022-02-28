package voiliers.images;
import java.awt.image.BufferedImage;

/**
 *
 * Tous les images des entites du programme.
 */
public class ImageEntite {
    /**
     * Image d'une entite du programme.
     */

    public static BufferedImage player,eaucalme,eauvague1,eauvague2,plage,boussole;

    /**
     *
     * Charge les images du dossier texture.
     */

    public static void init(){

        allimages images=new allimages(ChargerImage.ChargerImage("/texture/lesimages256.png"));

        eaucalme= images.selection(0,0,64,64);
        eauvague1= images.selection(64,0,64,64);
        eauvague2= images.selection(128,0,64,64);
        plage= images.selection(192,0,64,64);
        player= images.selection(0,64,12,21);
        boussole = images.selection(12,64,100,100);

    }
}
