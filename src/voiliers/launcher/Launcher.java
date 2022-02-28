package voiliers.launcher;

import voiliers.Jeu;

/** Classe responsable du lancement du jeu (contient le main) .
 *
 */
public class Launcher {




    public static void main(String[] args){

       Jeu game=new Jeu("Jeu Voilier",700,700);
       game.start();
    }
}