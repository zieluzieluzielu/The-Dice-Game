package game;

import java.util.*;

public class User {

    private final RandomDicesProvider dicesProvider;

    public User(RandomDicesProvider dicesProvider) {
        this.dicesProvider = dicesProvider;
    }

    boolean userTurn;

    private List<Dice> diceList = new ArrayList<>();

    private List<Dice> dicesToRethrow = new ArrayList<>();

    public List<Dice> getDiceList() {
        return diceList;
    }

    public List<Dice> getDicesToRethrow() {
        return dicesToRethrow;
    }

    public void userThrow1() {
        clearDicesToRethrow();
        this.diceList = dicesProvider.get();
    }

    private void afterSelectingDice() {


        for (int n = diceList.size() - 1; n > -1; n--)
            if (diceList.get(n).getSelected()) {
                diceList.remove(n);
            }


        System.out.println("after (diceList): " + getDiceList());
        System.out.println("after (to rethrow): " + getDicesToRethrow());

    }

    public void afterUnselectingDice() {

        for (int n = dicesToRethrow.size() - 1; n > -1; n--)
            if (!dicesToRethrow.get(n).getSelected()) {
                dicesToRethrow.remove(n);
            }

        System.out.println("after unselect (diceList): " + getDiceList());

    }

    private void clearDicesToRethrow() {
        dicesToRethrow.clear();
    }

    public void reThrow() {
        afterSelectingDice();
        dicesToRethrow
                .stream()
                .map(dice -> dicesProvider.getSingle())
                .forEach(newDice -> diceList.add(newDice));
        clearDicesToRethrow();
        System.out.println("dices were rethrown");
    }

    public void selectDice(Dice dice) {
        if (!dice.selected) {
            dicesToRethrow.add(dice);
            dice.selected = true;
        } else {
            System.out.println("Dice was already selected");
        }
    }

    public void unSelectDice(Dice dice) {
        dice.selected = !dice.selected;
    }

}
