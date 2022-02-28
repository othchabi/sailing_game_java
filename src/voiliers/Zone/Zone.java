package voiliers.Zone;

public class Zone {

    public  float x;
    public  float y;
    public  float width;
    public  float height;
    public float anglevent;
    public float vitessevent;
    public double hauteurvague;



    public Zone(float x,float y,float width,float height,float anglevent,float vitessevent,double hauteurvague){


        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.anglevent=anglevent;
        this.vitessevent=vitessevent;
        this.hauteurvague=hauteurvague;

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getAnglevent() {
        return anglevent;
    }

    public float getVitessevent() {
        return vitessevent;
    }

    public double getHauteurvague() {
        return hauteurvague;
    }
}
