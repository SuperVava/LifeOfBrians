import processing.core.PApplet;
import processing.core.PConstants;

public class Carre {
    private final int size;
    PApplet processing;

    public Carre(PApplet processing, int size){
        this.processing = processing;
        this.size = size;
    }

    public void draw(int positionX, int positionY, int red, int green, int blue){
        processing.rectMode(3);
        processing.noStroke();
        processing.fill(red, green, blue);
        processing.rect(positionX, positionY, size, size);
    }
}
