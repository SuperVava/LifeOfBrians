import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

import java.util.ArrayList;

public class Menu {
    PApplet processing;
    PFont font;
    int positionX;
    ArrayList<ArrayList<Key>> options;

    public Menu(PApplet processing) {
        this.processing = processing;
        this.positionX = processing.displayWidth/2;

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
        options.get(2).add(new Key(processing, "10", positionX, 420));

        options.add(new ArrayList<>(3));
        options.get(3).add(new Key(processing, "Noir", positionX, 500));
        options.get(3).add(new Key(processing, "Gris", positionX, 540));
        options.get(3).add(new Key(processing, "Blanc", positionX, 580));

        options.add(new ArrayList<>(1));
        options.get(4).add(new Key(processing, "Start", positionX, 640));
    }

    public void draw(){
        processing.background(255);
        this.font = processing.createFont("Consolas Bold", 30);
        processing.textFont(font);
        processing.textAlign(PConstants.CENTER);
        processing.fill(0);
        processing.text("Couleur", positionX, 60 + (float) (font.getSize() / 3));
        processing.text("Option de sauvegarde d'images", positionX, 220 + (float) (font.getSize() / 3));
        processing.text("Taille des pixels", positionX, 380 + (float) (font.getSize() / 3));
        processing.text("Couleur de fond", positionX, 460 + (float) (font.getSize() / 3));

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

    public void write(String number) {
        options.get(2).get(0).setName(number);
        options.get(2).get(0).draw(font);
    }

    public boolean isWriting() {
        if(options.get(2).get(0).isActivated())return true;
        else return false;
    }
}
