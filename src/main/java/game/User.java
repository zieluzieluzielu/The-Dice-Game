package game;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class User {

    private final RandomDicesProvider dicesProvider;

    public User(RandomDicesProvider dicesProvider) {
        this.dicesProvider = dicesProvider;
    }

    public boolean userTurn;

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

    public void afterSelectingDice() {


        for (int n = diceList.size() - 1; n > -1; n--)
            if (diceList.get(n).getSelected()) {
                diceList.remove(n);
            }


        System.out.println("after (diceList): " + getDiceList());
        System.out.println("after (to rethrow): " + getDicesToRethrow());
//
//        diceList.stream()
//                .filter(Dice::getSelected)
//                .forEach(diceToRemove -> diceList.remove(diceToRemove));
    }

    public void afterUnselectingDice() {

        for (int n = dicesToRethrow.size() - 1; n > -1; n--)
            if (!dicesToRethrow.get(n).getSelected()) {
                dicesToRethrow.remove(n);
            }

        System.out.println("after unselect (diceList): " + getDiceList());
        System.out.println("after unselect (to rethrow): " + getDicesToRethrow());
//
//        diceList.stream()
//                .filter(Dice::getSelected)
//                .forEach(diceToRemove -> diceList.remove(diceToRemove));
    }

    public void clearDicesToRethrow() {
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

    public boolean selectDice(Dice dice) {
        if (!dice.selected) {
            dicesToRethrow.add(dice);
            return dice.selected = true;
        } else {
            System.out.println("Dice was already selected");
            return dice.selected;
        }
    }

    public boolean unSelectDice(Dice dice) {
        if (dice.selected) {
            return dice.selected = false;
        } else {
            return dice.selected = true;
        }
    }

}
