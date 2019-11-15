package game;

import javafx.scene.image.Image;

import java.util.Random;

public class Dice {

    private Random random = new Random();

    private int value;
    private boolean selected;

    Dice(int value, boolean selected){
        this.value=value;
        this.selected=selected;
    }

    int rollTheDice(){
        if (!selected) {
            value = random.nextInt(6)+1;
            return value;
        }
        else return value;

    }

    void selectDice(){
        if (!selected){
            selected = true;
        }
        else {
            System.out.println("Dice was already selected");
        }
    }

    int getValue(){
        return value;
    }



}

