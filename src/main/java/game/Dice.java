package game;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Random;

public class Dice {

    Random random = new Random();

    int value;
    boolean selected;

    public Dice(int value, boolean selected){
        this.value=value;
        this.selected=selected;
    }


    public int getValue(){
        return value;
    }

    boolean getSelected(){
       return selected;
    }



}

