import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Key {
    PApplet processing;
    String name;
    int positionX;
    int positionY;
    PFont font;

    public Key(PApplet processing, String name, int positionX, int positionY) {
        this.processing = processing;
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;


    }

    public void draw() {
        processing.textFont(font);
        processing.fill(0, 240, 0);
        processing.textAlign(PConstants.LEFT);
        processing.rect(positionX, positionX, name.length()*font.getSize(), font.getSize());
    }

   // public void is

}
