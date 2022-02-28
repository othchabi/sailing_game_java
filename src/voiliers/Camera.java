package voiliers;


import voiliers.statutjeu.Course;

/**
 * La camera qui suit le joueur.
 */
public class Camera {
    /**
     * position x de la camera.
     */
    private float posX;
    /**
     * position y de la camera.
     *
     */
    private float posY;
    /**
     *
     * Le jeu de la camera.
     */
    private Jeu jeu;
    /**
     * La course de la camera.
     */
    private Course course;

    public Camera(Jeu jeu,Course course, float posX, float posY) {
        this.jeu = jeu;
        this.course=course;
        this.posX = posX;
        this.posY = posY;
    }

    /**
     *
     * Change la position de la camera pour suivre le joueur.
     */

    public void centrecamera() {


        posX = course.player.getX()- jeu.getWidth()/2 + course.player.getWidth()/2 ;
        posY = course.player.getY()- jeu.getHeight()/2 + course.player.getHeight()/2 ;

        depassement();

    }

    /**
     *
     * Empeche la camera de depasser les bords de la map du jeu.
     */
    private void depassement(){

        if (this.getPosX()<0){
            this.setPosX(0);

        }
        if (this.getPosY()<0){
            this.setPosY(0);

        }

        if (this.getPosX() + jeu.getWidth() > course.getmap().getWidth()){
            this.setPosX( course.getmap().getWidth() - jeu.getWidth());

        }

    }


    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;

    }
}
