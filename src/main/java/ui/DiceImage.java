package ui;

import javafx.scene.image.Image;

public class DiceImage {
    private Image dice1 = new Image("dices/dice_1.png", 125, 125, true, true);
    private Image dice2 = new Image("dices/dice_2.png", 125, 125, true, true);
    private Image dice3 = new Image("dices/dice_3.png", 125, 125, true, true);
    private Image dice4 = new Image("dices/dice_4.png", 125, 125, true, true);
    private Image dice5 = new Image("dices/dice_5.png", 125, 125, true, true);
    private Image dice6 = new Image("dices/dice_6.png", 125, 125, true, true);

    public Image getDice1() {
        return dice1;
    }

    public Image getDice2() {
        return dice2;
    }

    public Image getDice3() {
        return dice3;
    }

    public Image getDice4() {
        return dice4;
    }

    public Image getDice5() {
        return dice5;
    }

    public Image getDice6() {
        return dice6;
    }
}
