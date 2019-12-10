package game;

import javafx.scene.image.Image;

public class Dice {

    int value;
    boolean selected;
    Image diceImage;

    public Dice(int value, boolean selected) {
        this.value = value;
        this.selected = selected;
        setDiceImage();
    }

    public int getValue() {
        return value;
    }

    public void setDiceImage() {
        if(this.value==1) {
            this.diceImage = new Image("dices/dice_1.png", 125, 125, true, true);
        }
        else if (this.value==2){
            this.diceImage = new Image("dices/dice_2.png", 125, 125, true, true);
        }
        else if (this.value==3){
            this.diceImage = new Image("dices/dice_3.png", 125, 125, true, true);
        }
        else if (this.value==4){
            this.diceImage = new Image("dices/dice_4.png", 125, 125, true, true);
        }
        else if (this.value==5){
            this.diceImage = new Image("dices/dice_5.png", 125, 125, true, true);
        }
        else if (this.value==6){
            this.diceImage = new Image("dices/dice_6.png", 125, 125, true, true);
        }
        else {
            this.diceImage = new Image("dices/dice_6.png", 125, 125, true, true);
        }
    }

    public Image getDiceImage() {
        return diceImage;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected() {
        this.selected = true;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "value=" + value +
                ", selected=" + selected +
                '}';
    }
}

