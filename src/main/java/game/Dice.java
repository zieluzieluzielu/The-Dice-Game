package game;

public class Dice {

    int value;
    boolean selected;

    public Dice(int value, boolean selected) {
        this.value = value;
        this.selected = selected;
    }

    public int getValue() {
        return value;
    }

    boolean getSelected() {
        return selected;
    }


}

