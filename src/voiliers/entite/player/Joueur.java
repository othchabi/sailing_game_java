package voiliers.entite.player;

import voiliers.statutjeu.Course;

import voiliers.images.ImageEntite;
import voiliers.Zone.Zone;
import voiliers.*;
import java.awt.*;

/**
 *
 *  le piloteur du voilier.
 */
public class Joueur extends VoiliersJoueur{

    private Graphics2D g2d;
    /**
     * La zone dans laquelle le joueur se trouve.
     */
    private Zone zonejoueur;
    /**
     *
     * Le Type de voilier.
     */

    private String voile_bateau;
    /**
     *
     * La course dans laquelle le joueur se trouve.
     */
    private Course course;
    /**
     *
     * vitesse de deplacement du joueur.
     */
    private float vitessedeplace;
    /**
     *
     * difference entre l'angle du vent et du joueur.
     */
    private float diffangle;
    /**
     *
     * angle du joueur.
     */
    private float angle;



    public Joueur(Jeu jeu,Course statut, float x, float y, String voilebateau, float angle) {
        super(jeu,x, y,voilebateau,angle);

        this.voile_bateau=voilebateau;
        this.course=statut;
        this.vitessedeplace= this.getvitesse();
        this.angle=angle;
    }

    /**
     *
     * @return l'angle du joueur.
     */
    public float getangle() {

        return angle;
    }

    /**
     *
     * @return La zone du joueur.
     *
     */
    public Zone getZone() {

        return zonejoueur;
    }

    /**
     *
     *
     * @param v2
     *         nouvelle vitesse du voilier.
     */
    public void setvitessedeplacement(float v2){

        this.vitessedeplace=v2;
    }

    /**
     *
     * @return la vitesse du bateau.
     */
    public float getvitessedeplacement(){

        return vitessedeplace;
    }

    /**
     * Calcul la difference de langle du joueur et du vent pour determiner la vitesse
     * de deplacement.
     * @param statut
     *       La course dans laquelle le joueur participe.
     */

    public void maZone(Course statut){



        if ((x > statut.getmap().zoneblanche.getX()) && (x<statut.getmap().zoneblanche.getWidth()+statut.getmap().zoneblanche.getX()))
        {
            System.out.println("Vous etes dans la zone blanche");

            zonejoueur= statut.getmap().zoneblanche;


        }
       else if ((x > statut.getmap().zonebleu.getX()) && (x<statut.getmap().zonebleu.getWidth()+statut.getmap().zonebleu.getX()))
        {
            System.out.println("Vous etes dans la zone bleu");
            zonejoueur= statut.getmap().zonebleu;


        }
       else if ((x > statut.getmap().zonerouge.getX()) && (x<statut.getmap().zonerouge.getWidth()+statut.getmap().zonerouge.getX()))
        {
            System.out.println("Vous etes dans la zone rouge");
            zonejoueur= statut.getmap().zonerouge;

        }

       if (angle >= 0 ) {
            diffangle = zonejoueur.getAnglevent() - this.getangle();
       }else if (angle < 0){
            diffangle = zonejoueur.getAnglevent() + this.getangle();
       }
        if ( Math.abs(diffangle) == 45 ) { this.setvitessedeplacement(this.vitesse);
                                         }
        if ( Math.abs(diffangle) == 90 ) { this.setvitessedeplacement(this.vitesse*(float)0.5);
        }
        if ( Math.abs(diffangle) == 0 ) { this.setvitessedeplacement(this.vitesse*(float)0);
        }

    }

    /**
     * Rafraichit les touches du joueur et sa camera .
     */
    public void update() {
         getkeys();


         jeu.getCamera().centrecamera();

    }

    /**
     *
     * Deplace le joueur selon sa vitesse et son angle par rapport au vent suivant laxe x et y.
     */
    private void getkeys(){





            y -= Math.cos(Math.toRadians(angle))*vitessedeplace;
            x += Math.sin(Math.toRadians(angle))*vitessedeplace;


        if(jeu.getClavier().bas){System.out.println("bas");
            y += Math.cos(Math.toRadians(angle))*vitessedeplace;
            x -= Math.sin(Math.toRadians(angle))*vitessedeplace;

        }
        if(jeu.getClavier().gauche){
            if (angle == -359 )  angle = 0;
            else angle -= 1;



        }

        if(jeu.getClavier().droite){
            if (angle == 359)  angle = 0;
            else angle +=1;




        }

    }

    /**
     *
     * Dessine le voilier sur la map.
     * @param g
     *  Objet de Dessin
     */
    public void render(Graphics g) {


        g2d = (Graphics2D) g;

        g2d.rotate(Math.toRadians(angle),x+(width_voiliers/2) -jeu.getCamera().getPosX(),y +(height_voiliers/2) - jeu.getCamera().getPosY());


        g2d.drawImage(ImageEntite.player, (int) (x - jeu.getCamera().getPosX()), (int) (y - jeu.getCamera().getPosY()), width_voiliers, height_voiliers, null);


    }

}