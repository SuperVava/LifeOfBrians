import processing.core.PApplet;


public class LaVieDesBrian extends PApplet {
    private CarreListe list;
    private int picture = 0;
    private Menu menu;
    String information;
    int color;
    private boolean isStarted = false;
    private int saveMode = 0;
    String number = "";

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

            background(color);
            noCursor();
            while (!list.getIsIncrease())
                list.add((int) random(4));
            list.draw();
            if(saveMode == 2){
                picture++;
                save("out/Brian" + picture + ".png");
            }

            if (list.isStuck()) {
                if(saveMode == 1){
                    picture++;
                    save("out/Brian" + picture + ".png");
                }
                while (list.getIsIncrease() == false) {
                    list.newBrian();
                }
            }

        } else {
            menu.draw();
            if (mousePressed) {
                information = menu.keyPressed(mouseX, mouseY);
                treat(information);
            }
            mousePressed = false;
        }
    }

    private void treat(String information) {
        if (information == "null") ;
        else if (information == "Start") {
            isStarted = true;
            if(number == ""){
                number = "10";
            }
            list.setSize(Integer.parseInt(number));
        }
        else if (information == "Échelle de gris croissante") list.setColorType(1);
        else if (information == "Échelle de gris aléatoire") list.setColorType(2);
        else if (information == "Couleurs aléatoires") list.setColorType(3);
        else if (information == "Noir") color = 0;
        else if (information == "Gris") color = 125;
        else if (information == "Blanc") color = 255;
        else if (information == "Une image par motif") saveMode = 1;
        else if (information == "Une image par pixel") saveMode = 2;


    }

    @Override
    public void keyTyped() {
        if (menu.isWriting()){
            number += key;
            menu.write(number);
        }
    }
}

