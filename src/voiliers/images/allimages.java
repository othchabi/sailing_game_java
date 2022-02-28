package voiliers.images;
import java.awt.image.BufferedImage;
public class allimages {
    private BufferedImage images;


    public allimages(BufferedImage images){

        this.images=images;
    }

    public  BufferedImage selection(int x,int y,int width,int height){

        return images.getSubimage(x,y,width,height);
    }
}
