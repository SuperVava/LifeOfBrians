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

    public void draw(PFont font) {
        this.font = font;
        processing.textFont(font);
        processing.textAlign(PConstants.CENTER);
        processing.rectMode(PConstants.CENTER);

        processing.fill(255);
        processing.rect(positionX, positionX, (float) ((name.length() * font.getSize()) / 1.7), font.getSize());
        processing.fill(0);
        processing.text(name, positionX, positionY + (float) (font.getSize() / 3));
    }

    // public void is

}
