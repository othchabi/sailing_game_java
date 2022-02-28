package voiliers.entite.player;
import voiliers.entite.*;
import voiliers.Jeu;

/**
 *
 * Voiliers des joueurs.
 */
public abstract class VoiliersJoueur extends Entite{

    /**
     * largeur du voilier.
     */
    public static final int width_voiliers=12;
    /**
     * hauteur du voilier.
     */
    public static final int height_voiliers=20;
    /**
     * vie du voilier.
     */
    protected int vie;
    /**
     * Type du bateau (Geolier,Spinnaker).
     */
    protected String typebateau;
    /**
     * Vitesse du voilier.
     *
     * */
    protected float vitesse;



    public VoiliersJoueur(Jeu jeu,float x,float y,String voilebateau,float angle){

        super(jeu,x,y,width_voiliers,height_voiliers,angle);

        vie=100;
        typebateau=voilebateau;
        vitesse=(float)0.35;

    }


    public int getvie() {
        return vie;
    }

    public void setvie(int health) {
        this.vie = health;
    }

    public float getvitesse() {
        return vitesse;
    }
    public String getTypebateau() {
        return typebateau;
    }


    public void setvitesse(float speed) {
        this.vitesse = speed;
    }

}


