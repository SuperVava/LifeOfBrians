import processing.core.PApplet;
import processing.core.PFont;

public class Menu {
    PApplet processing;
    PFont font;
    Key start;

    public Menu(PApplet processing) {
        this.processing = processing;
        start = new Key(processing, "Start", 200, 200);
    }

    public void draw(){
        processing.background(255);
        this.font = processing.createFont("Consolas", 100);
        start.draw(font);
    }
}
