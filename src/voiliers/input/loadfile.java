package voiliers.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  Charge les elements du fichier texte du jeu.
 */
public class loadfile {
    /**
     *
     *
     * @param chemin
     *     Chemin du fichier texte du jeu.
     * @return
     *     un seul string avec tous les valeurs du fichier texte.
     */
    public static String loadfilestring(String chemin){

       StringBuilder builder=new StringBuilder();


       try {
           BufferedReader br = new BufferedReader(new FileReader(chemin));
           String ligne;
           System.out.println("test");
           while ( (ligne = br.readLine()) != null) builder.append(ligne + "\n");
                                                    br.close();
             }catch(IOException e){

              e.printStackTrace();
                                    }

        return builder.toString();

       }

    /**
     *
     * @param entier
     *    Une chaine qui represente un entier .
     * @return
     *    Un entier .
     */
       public static int parseInt(String entier){
           try{

               return Integer.parseInt(entier);

             }catch(NumberFormatException e){
               e.printStackTrace();
               return 0;
            }


    }
}
