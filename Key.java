import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Key {
    PApplet processing;
    String name;
    int positionX;
    int positionY;
    PFont font;
    int color = 255;

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

        processing.fill(color);
        processing.rect(positionX, positionY, (float) ((name.length() * font.getSize()) / 1.7), font.getSize());
        processing.fill(0);
        processing.text(name, positionX, positionY + (float) (font.getSize() / 3));
    }

       public boolean isActivated(int cursorPositionX, int cursorPositionY){
        if(cursorPositionX > positionX - (float) ((name.length() * font.getSize()) / 1.7) / 2 && cursorPositionX < positionX + (float) ((name.length() * font.getSize()) / 1.7) / 2 && cursorPositionY > positionY - font.getSize()/2 && cursorPositionY < positionY + font.getSize()/2 ) return true;
        else return false;
       }

    public String getName() {
        color = 100;
        return name;
    }
}
