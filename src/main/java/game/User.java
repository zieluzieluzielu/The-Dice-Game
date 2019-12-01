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
        this.diceList = dicesProvider.get();
    }

    public void reThrow() {
       dicesToRethrow
                .stream()
                .map(dice -> dicesProvider.getSingle())
                .forEach(newDice -> diceList.add(newDice));
        System.out.println("dices were rethrowed");
        dicesToRethrow.clear();
    }


    //docelowy (stara wersja)
//    public void userThrow(List<Dice> diceList) {
//        for (int n = 1; n <= diceList.size(); n++) {
//            rollTheDice(diceList.get(n));
//        }
//    }
//
//    public int rollTheDice(Dice dice) {
//        if (!dice.getSelected()) {
//            return singleDiceRoll();
//        } else return dice.getValue();
//    }
//
//    public int singleDiceRoll() {
//        return random.nextInt(6) + 1;
//    }
//    public void reThrowDices(List<Dice> diceList) {
//        for (int n = 1; n <= diceList.size(); n++) {
//            rollTheDice(diceList.get(n));
//        }
//    }


    public int sumOfDices(List<Dice> diceList) {
        int sum = 0;
        for (int n = 0; n < diceList.size(); n++) {
            sum += diceList.get(n).getValue();
        }
        return sum;
    }



    int totalScore(HashMap<Score, Integer> result) {
        return result.values().stream().mapToInt(Integer::intValue).sum();
        //return topScore(result)+bottomScore(result);
    }

    //mozliwosc wybrania ponizszej metody przez button -> tylko gdy kosc nie zostala wczesniej wybrana
    public boolean selectDice(Dice dice) {
        if (!dice.selected) {
            dicesToRethrow.add(dice);
            return dice.selected = true;
        } else {
            System.out.println("Dice was already selected");
            return dice.selected;
        }
    }

    //mozliwosc wybrania ponizszej metody przez button -> tylko gdy kosc zostala wczesniej wybrana
    public boolean unSelectDice(Dice dice) {
        if (dice.selected) {
            return dice.selected = false;
        } else {
            return dice.selected = true;
        }
    }

    public void addDicesToList(List<Dice> diceList, List<Integer> dicesIntList) {
        for (int n = 1; n <= diceList.size(); n++) {
            dicesIntList.add(diceList.get(n).getValue());
        }
    }



}
