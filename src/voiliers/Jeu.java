package voiliers;

import voiliers.fenetre.Fenetre;

import voiliers.images.ImageEntite;
import voiliers.input.Clavier;
import voiliers.Camera;
import java.awt.Toolkit;

import voiliers.statutjeu.Course;
import voiliers.statutjeu.Statut;

import java.awt.*;

import java.awt.image.BufferStrategy;



public class Jeu  implements Runnable {

    private Fenetre fenetre;
    private static int width;
    private static int height;
    private String titre;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;


    private Course statut;
    //clavier
    private Clavier clavier;
    private Camera camera;


    public Jeu(String titre, int width, int height) {
        this.titre = titre;
        this.width = width;
        this.height = height;
        clavier = new Clavier();
    }

    /**
     *
     * @return Le clavier associer a la fenetre du jeu.
     */

    public Clavier getClavier() {

        return this.clavier;
    }

    /**
     *
     * @return la camera associer au jeu.
     */
    public Camera getCamera() {

        return camera;
    }



    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return la largeur de la fenetre du jeu.
     */

    public static int getWidth() {
        return width;
    }

    /**
     *
     * @return la hauteur de la fenetre du jeu.
     */
    public static int getHeight() {
        return height;
    }

    /**
     *  Initialise les elements du jeu (fenetre,leclavier,lesimages,lacamera).
     */
    public void init() {

        fenetre = new Fenetre(titre,width, height);
        running = true;


        fenetre.getFrame().addKeyListener(clavier);


        ImageEntite.init();

        statut = new Course(this);
        Statut.setStatut(statut);
        camera= new Camera(this,statut,0,0);

    }

    /**
     * Lance la boucle principale du jeu ou tous les elements sont met a jour et dessiner .
     *
     * */

    public void run() {

        init();
        int fps = 60;
        double intervaleupdate = 1000000000 / fps;
        double n = 0;
        long tempsdebut;
        long tempsfin = System.nanoTime();
        long timer = 0;
        int nbfois = 0;

        while (running) {
            tempsdebut = System.nanoTime();
            n += (tempsdebut - tempsfin) / intervaleupdate;
            timer += tempsdebut - tempsfin;
            tempsfin = tempsdebut;


            if (n >= 1) {


                update();

                render();

                nbfois++;
                n--;

            }
            if (timer >= 1000000000) {
                System.out.println("Image par seconde " + nbfois);
                nbfois = 0;
                timer = 0;
            } /*stop()*/
        }
        stop();
    }

    /**
     * Update les elements du jeu.
     */

    private void update() {


        clavier.update();
        if (Statut.getStatut() != null) {
            Statut.getStatut().update();
        }
    }

    /**
     *
     * Dessine les elements du jeu sur le canvas.
     */

    public void render() {
        bs = fenetre.getCanvasjeu().getBufferStrategy();

        if (bs == null) {
            fenetre.getCanvasjeu().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!

        if (Statut.getStatut() != null)
            Statut.getStatut().render(g);

        //End Drawing!
        bs.show();
        g.dispose();


    }}






