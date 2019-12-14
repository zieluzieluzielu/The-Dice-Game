package game;

import javafx.scene.image.Image;
import ui.DiceImage;

public class Dice {

    int value;
    boolean selected;
    Image imageOfDice;
    DiceImage diceImage = new DiceImage();

    public Dice(int value, boolean selected) {
        this.value = value;
        this.selected = selected;
        setDiceImage(diceImage);
    }

    public int getValue() {
        return value;
    }

    public void setDiceImage(DiceImage diceImage) {
        if (this.value == 1) {
            this.imageOfDice = diceImage.getDice1();
        } else if (this.value == 2) {
            this.imageOfDice = diceImage.getDice2();
        } else if (this.value == 3) {
            this.imageOfDice = diceImage.getDice3();
        } else if (this.value == 4) {
            this.imageOfDice = diceImage.getDice4();
        } else if (this.value == 5) {
            this.imageOfDice = diceImage.getDice5();
        } else {
            this.imageOfDice = diceImage.getDice6();
        }
    }

    public Image getDiceImage() {
        return imageOfDice;
    }

    public boolean getSelected() {
        return selected;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "value=" + value +
                ", selected=" + selected +
                '}';
    }
}

