package voiliers.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 *  La Clavier du jeu.
 */

public class Clavier implements KeyListener{
    /**
     *
     * Les touches du claviers.
     */
    private boolean[] keys;
    /**
     *
     * touche du clavier qui va etre lu
     */
    public boolean haut,bas,gauche,droite;
 /**
  *
  * Cree un Clavier avec 256 touches.
  */
    public Clavier(){

        keys=new boolean[256];

    }

    /**
     *
     * Rafraichit les etats des touches.
     */


    public void update(){
        haut=keys[KeyEvent.VK_UP];
        bas=keys[KeyEvent.VK_DOWN];
        gauche=keys[KeyEvent.VK_LEFT];
        droite=keys[KeyEvent.VK_RIGHT];

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     *
     * La touche qui a ete activer
     * @param e
     *    Evenement du clavier.
     */

    public void keyPressed(KeyEvent e){


        keys[e.getKeyCode()]=true;


    }

    /**
     *  Les touches qui sont plus active.
     * @param e
     *    Evenement du clavier.
     */
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()]=false;

    }


}