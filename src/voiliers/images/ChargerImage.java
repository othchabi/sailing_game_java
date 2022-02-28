package voiliers.images;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ChargerImage {

    public static BufferedImage ChargerImage(String chemin){

            try { return ImageIO.read(ChargerImage.class.getResource(chemin));
    }
      catch (IOException e){
        System.out.println("Erreur Image");
        System.exit(1);
    }
        return null;

}
}

