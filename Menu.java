import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;

public class Menu {
    PApplet processing;
    PFont font;
    ArrayList<ArrayList<Key>> options;

    public Menu(PApplet processing) {
        this.processing = processing;
        int positionX = processing.displayWidth/2;

        options = new ArrayList<>(5);

        options.add(new ArrayList<>(3));
        options.get(0).add(new Key(processing, "Échelle de gris croissante", positionX, 100));
        options.get(0).add(new Key(processing, "Échelle de gris aléatoire", positionX, 140));
        options.get(0).add(new Key(processing, "Couleurs aléatoires", positionX, 180));

        options.add(new ArrayList<>(3));
        options.get(1).add(new Key(processing, "Une image par pixel", positionX, 260));
        options.get(1).add(new Key(processing, "Une image par motif", positionX, 300));
        options.get(1).add(new Key(processing, "Sans prises d'images", positionX, 340));

        options.add(new ArrayList<>(1));
        options.get(2).add(new Key(processing, "Start", positionX, 500));
    }

    public void draw(){
        processing.background(255);
        this.font = processing.createFont("Consolas", 30);
        for(int i = 0; i < options.size(); i++) {
            for(int j = 0; j < options.get(i).size(); j++) {
                options.get(i).get(j).draw(font);
            }
        }
    }

    public String keyPressed(int mousePositionX, int mousePositionY) {
        for(int i = 0; i < options.size(); i++) {
            for(int j = 0; j < options.get(i).size(); j++) {
                if (options.get(i).get(j).isActivated(mousePositionX, mousePositionY)) {
                    if(options.get(i).get(j).isActivated()){
                        for(int k = 0; k < options.get(i).size(); k++){
                            options.get(i).get(k).setActivated(false);
                        }
                        options.get(i).get(j).setActivated(true);
                    }
                    return options.get(i).get(j).getName();
                }
            }
        }
        return "null";
    }
}
