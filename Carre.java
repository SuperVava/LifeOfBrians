import processing.core.PApplet;
import processing.core.PConstants;

public class Carre {
    PApplet processing;
    private int size = 10;
    public Carre(PApplet processing){
        this.processing = processing;
    }

    public void draw(int positionX, int positionY, int red, int green, int blue){
        processing.rectMode(3);
        processing.noStroke();
        processing.fill(red, green, blue);
        processing.rect(positionX, positionY, this.size, this.size);

    }

    int size(){
        return this.size;
    }
}
