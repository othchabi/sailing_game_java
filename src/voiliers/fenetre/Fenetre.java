package voiliers.fenetre;


import java.awt.*;
import javax.swing.JFrame;



public class Fenetre extends JFrame{
    /**
     * Titre De la fenetre.
     */
    public static String titre;
    /**
     * Largeur de la fenetre.
     */

    public static int width;
    /**
     * hauteur de la fenetre.
     */
    public static int height;
    /**
     * JFrame de la fenetre.
     *
     */
    private JFrame frame;
    /**
     * Canvas de la fenetre pour dessiner les elements du jeu.
     */
    private Canvas canvas;





    public Fenetre(String titre,int width,int height) {

        frame = new JFrame(titre);


        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();


    }

    /**
     *
     * @return le canvas de la fenetre.
     */
   public Canvas getCanvasjeu(){
        return canvas;
    }

    /**
     *
     * @return le JFrame de la fenetre
     */
    public JFrame getFrame(){
        return frame;
    }





}