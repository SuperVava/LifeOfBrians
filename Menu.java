import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;

public class Menu {
    PApplet processing;
    PFont font;
    ArrayList<Key> keys;

    public Menu(PApplet processing) {
        this.processing = processing;
        keys = new ArrayList<>(4);
        int positionX = processing.displayWidth/2;
        keys.add(new Key(processing, "Une image par pixel", positionX, 100));
        keys.add(new Key(processing, "Une image par motif", positionX, 140));
        keys.add(new Key(processing, "Sans prises d'images", positionX, 180));
        keys.add(new Key(processing, "Start", positionX, 500));
    }

    public void draw(){
        processing.background(255);
        this.font = processing.createFont("Consolas", 30);
        for(int i = 0; i < keys.size(); i++) {
            keys.get(i).draw(font);
        }
    }

    public String keyPressed(int mousePositionX, int mousePositionY) {
        for(int i = 0; i < keys.size(); i++) {
            if(keys.get(i).isActivated(mousePositionX, mousePositionY)){
                return keys.get(i).getName();
            }
        }
        return "null";
    }
}
