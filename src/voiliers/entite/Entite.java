package voiliers.entite;
import java.awt.*;
import voiliers.Jeu;

/**
 *
 * Entite du programme.
 */
public abstract class Entite {
    /**
     * Le jeu pour chaque entite.
     */
    protected Jeu jeu;
    /**
     *
     * position de l'entite.
     */
    protected float x,y;

    /**
     * Taille de l'entite.
     */
    protected int width,height;
    /**
     *
     * angle d'affichage de l'entite.
     */
    protected float angle;

    public Entite(Jeu jeu,float x,float y,int width,int height,float angle){

        this.x=x;
        this.y=y;
        this.angle=angle;
        this.width=width;
        this.height=height;
        this.jeu=jeu;

    }

    public abstract void update();
    public abstract void render(Graphics g);

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setX(float x) {
        this.x = x;

    }

    public void setY(float y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
