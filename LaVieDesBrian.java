import processing.core.PApplet;


public class LaVieDesBrian extends PApplet {
    private CarreListe list;
    private int picture = 0;
    private Menu menu;
    String information;
    private boolean isStarted = false;

    public static void main(String[] args) {
        PApplet.main("LaVieDesBrian");

    }

    @Override
    public void settings() {
        this.list = new CarreListe(this);
        menu = new Menu(this);
        fullScreen();
    }

    @Override
    public void draw() {
        if (isStarted == true) {
            background(0);
            noCursor();
            while (list.getIsIncrease() == false) list.add((int) random(4));
            if (list.isStuck()) {
                picture++;
                save("Brian" + picture + ".png");
                while (list.getIsIncrease() == false) {
                    list.newBrian();
                }
            }
            list.draw();
        }
        else{
            menu.draw();
            if(mousePressed){
                information = menu.keyPressed(mouseX, mouseY);
                treat(information);
            }
        }
    }

    private void treat(String information){
        if(information == "null");
        if(information == "Start"){
            isStarted = true;
        }
    }

}
