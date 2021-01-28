import processing.core.PApplet;

public class CarreListe {
    PApplet processing;
    int numberOfSquares = 0;
    int numberOfBrians;
    Carre carre;
    boolean isIncrease = false;
    private int[][] positions;
    int positionX, positionY;

    private int hauteurGrille;
    private int largeurGrille;
    private int grilleSize;
    private int size;
    int centerX;
    int centerY;
    int colorType;

    float grey = 0;
    int red;
    int green;
    int blue;
    int[][] color;

    public CarreListe(PApplet processing) {
        this.processing = processing;
    }

    public void setSize(int size) {
        this.size = size;
        this.hauteurGrille = processing.displayHeight / size;
        this.largeurGrille = processing.displayWidth / size;
        this.grilleSize = hauteurGrille * largeurGrille;
        this.positions = new int[grilleSize][2];
        this.color = new int[grilleSize][3];
        this.centerX = (largeurGrille / 2) * size;
        this.centerY = (hauteurGrille / 2) * size;

        this.positions[0] = new int[]{centerX, centerY};
        numberOfSquares++;
    }

    public void add(int direction) {
        generatePosition(direction);

        if (isPositionFree()) {
            this.positions[numberOfSquares] = new int[]{positionX, positionY};
            this.color[numberOfSquares] = new int[]{color[numberOfSquares - 1][0], color[numberOfSquares - 1][1], color[numberOfSquares - 1][2]};
            isIncrease = true;
            numberOfSquares++;
            System.out.println(numberOfSquares);
        } else isIncrease = false;

    }

    boolean getIsIncrease() {
        return isIncrease;
    }

    private void randomColor() {
        red = (int) processing.random(240);
        green = (int) processing.random(240);
        blue = (int) processing.random(240);

        color[numberOfSquares] = new int[]{red, green, blue};
    }

    private void generatePosition(int direction) {
        if (direction == 0) {
            positionX = this.positions[numberOfSquares - 1][0] - size;
            positionY = this.positions[numberOfSquares - 1][1];
        } else if (direction == 1) {
            positionX = positions[numberOfSquares - 1][0];
            positionY = positions[numberOfSquares - 1][1] + size;
        } else if (direction == 2) {
            positionX = positions[numberOfSquares - 1][0] + size;
            positionY = positions[numberOfSquares - 1][1];
        } else if (direction == 3) {
            positionX = positions[numberOfSquares - 1][0];
            positionY = positions[numberOfSquares - 1][1] - size;
        }
    }

    private boolean isPositionFree() {
        if (outOfScreen(positionX, positionY)) {
            return false;
        } else for (int i = 0; i < numberOfSquares; i++) {
            if ((positions[i][0] == positionX) && (positions[i][1] == positionY)) {
                return false;
            }
        }
        return true;
    }

    boolean isStuck() {
        for (int i = 0; i < 4; i++) {
            generatePosition(i);
            if (isPositionFree()) return false;
        }
        isIncrease = false;
        return true;
    }

    boolean outOfScreen(int positionX, int positionY) {
        if (0 + size <= positionX && positionX <= processing.displayWidth - size
                && 0 + size <= positionY && positionY <= processing.displayHeight - size)
            return false;
        else
            return true;
    }

    public void newBrian() {
        positionX = positions[0][0] + size * (int) processing.random(-largeurGrille, largeurGrille);
        positionY = positions[0][1] + size * (int) processing.random(-hauteurGrille, hauteurGrille);
        if (!isPositionFree()) {
            isIncrease = false;
            System.out.println("échec");
        } else {
            if (colorType == 1) {
                grey += 0.5;
                red = (int) grey;
                green = (int) grey;
                blue = (int) grey;
                color[numberOfSquares] = new int[]{red, green, blue};
            } else if (colorType == 2) {
                int randomGrey = (int)processing.random(255);
                red = randomGrey;
                green = randomGrey;
                blue = randomGrey;
                color[numberOfSquares] = new int[]{red, green, blue};
            } else if (colorType == 3) randomColor();

            this.positions[numberOfSquares] = new int[]{positionX, positionY};
            numberOfSquares++;
            isIncrease = true;
            numberOfBrians++;
            System.out.println("New Brian at " + positionX + " ; " + positionY + ",");
            System.out.println("There is " + numberOfBrians + " Brians");
            if (isStuck()) {
                draw();
                newBrian();
            }
        }
    }

    public void draw() {
        this.carre = new Carre(processing, size);

        for (int i = 0; i < numberOfSquares; i++)
            carre.draw(this.positions[i][0], this.positions[i][1], this.color[i][0], this.color[i][1], this.color[i][2]);
        isIncrease = false;
    }

    public void setColorType(int colorType) {
        this.colorType = colorType;
    }
}