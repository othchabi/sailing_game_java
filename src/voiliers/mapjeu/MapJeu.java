package voiliers.mapjeu;
import voiliers.input.*;
import voiliers.Jeu;
import voiliers.maptexture.MAP;
import java.awt.*;
import voiliers.Zone.Vent;

/**
 * La map du jeu .
 */
public class MapJeu {
    /**
     * hauteur de la map du jeu.
     */
    private int height;
    /**
     *
     * le jeu pour laquelle la map a ete cree.
     */
    private final Jeu jeu;
    /**
     * largeur de la map.
     */
    private int width;
    /**
     * Objet Vent qui definie les caracteristiques de la zone.
     */

    public  Vent zoneblanche,zonebleu,zonerouge;
    /**
     * Determine si une zone a ete decouverte.
     */
    private boolean debutzoneblanche=true,debutzonebleu=true,debutzonerouge=true;
    /**
     * Coordonnee X du debut de la zone.
     */
    public int       xzoneblanche,xzonebleu,xzonerouge;
    /**
     * Largeur de la zone.
     */
    public int      widthzoneblanche,widthzonebleu,widthzonerouge;

    /**
     *
     * tableaux avec les ids de tous les elements de la map.
     */
    private int[][] map;

    /**
     *
     * @param jeu
     *    le jeu en cours dexecution.
     * @param chemin
     *    le chemin du fichier texte qui represente la map a travers les ids des elements de MAP.
     */

    public MapJeu(Jeu jeu,String chemin){
        this.jeu=jeu;
        loadMapJeu(chemin);


    }

    /**
     *
     * @param g
     *  Objet graphics qui dessine la map.
     */

    public void render(Graphics g){
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                getmapimage(x,y).render(g,(int)(x*MAP.imagewidth - jeu.getCamera().getPosX() ),(int)(y*MAP.imageheight - jeu.getCamera().getPosY()));
            }
        }


    }

    /**
     *
     * @param x
     *     Coordonnee x du tableau des elements de la map.
     * @param y
     *     Coordonnee y du tableau des elements de la map.
     * @return  Objet de MAP.
     *
     */

    public MAP getmapimage(int x,int y){

        MAP temp=MAP.map[map[x][y]];
        return temp;
    }

    /**
     *
     * @param chemin
     *    le chemin du fichier texte qui represente la map.
     */

    public void loadMapJeu(String chemin){

        String file= loadfile.loadfilestring(chemin);


        String[] token=file.split("\\s+");

        width   =  loadfile.parseInt(token[0]);
        height  =  loadfile.parseInt(token[1]);



        map=new int[width][height];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                map[x][y]=loadfile.parseInt(token[(x+y*width)+2]);

               if (y==0) {
                   if ((map[x][y] == 2) && (debutzoneblanche)) {
                       xzoneblanche = (x * MAP.imagewidth);
                       debutzoneblanche = false;
                   }
                   if ((map[x][y] == 3) && (debutzonebleu)) {
                       xzonebleu = (x * MAP.imagewidth);
                       debutzonebleu = false;
                   }
                   if ((map[x][y] == 4) && (debutzonerouge)) {
                       xzonerouge = (x * MAP.imagewidth);
                       debutzonerouge = false;
                   }
                   if ((map[x][y] == 2) && !(debutzoneblanche)) {
                       widthzoneblanche += MAP.imagewidth;
                   }
                   if ((map[x][y] == 3) && !(debutzonebleu)) {
                       widthzonebleu += MAP.imagewidth;
                   }
                   if ((map[x][y] == 3) && !(debutzonerouge)) {
                       widthzonerouge += MAP.imagewidth;
                   }
               }
               }
            }

         zoneblanche = new Vent(xzoneblanche,0,widthzoneblanche,height,100,29,0.5);
         zonebleu = new Vent(xzonebleu,0,widthzoneblanche,height,120,50,1);
         zonerouge = new Vent(xzonerouge,0,widthzoneblanche,height,130,62,1.5);



    }

    /**
     *
     * @return
     *       Largeur de la map.
     */
    public int getWidth(){
      return  map.length * MAP.imagewidth ;
    }



}
