import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Key {
    PApplet processing;
    String name;
    int positionX;
    int positionY;
    boolean isActivated;
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

        if (isActivated == true) processing.fill(100);
        else processing.fill(255);

        processing.rect(positionX, positionY, (float) ((name.length() * font.getSize()) / 1.7), font.getSize());
        processing.fill(0);
        processing.text(name, positionX, positionY + (float) (font.getSize() / 3));
    }

    public boolean isActivated(int cursorPositionX, int cursorPositionY) {
        if (cursorPositionX > positionX - (float) ((name.length() * font.getSize()) / 1.7) / 2 && cursorPositionX < positionX + (float) ((name.length() * font.getSize()) / 1.7) / 2 && cursorPositionY > positionY - font.getSize() / 2 && cursorPositionY < positionY + font.getSize() / 2) {
            if (isActivated == false) isActivated = true;
            else isActivated = false;
            return true;
        }
        else return false;
    }

    public String getName() {
        return name;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public void setName(String name) {
        this.name = name;
    }
}
