import processing.core.PApplet;


public class LaVieDesBrian extends PApplet {
    private CarreListe list;
    private int picture = 0;

    public static void main(String[] args) {
        PApplet.main("LaVieDesBrian");

    }

    @Override
    public void settings() {
        //setSize(1600, 900);
        fullScreen();
        this.list = new CarreListe(this);
    }

    @Override
    public void draw() {
        background(0);
        while (list.getIsIncrease() == false) list.add((int) random(4));
        if (list.isStuck()) {
            picture++;
            save("Brian" + picture + ".png");
            while (list.getIsIncrease() == false) {
                list.newBrian();
            }
        }
        noCursor();
        list.draw();
    }

}
