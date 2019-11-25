package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class User {

    Random random;

    public User(Random random) {
        this.random = random;
    }

    public boolean userTurn;

    private ArrayList<Dice> diceList = new ArrayList<>();

    private ArrayList<Integer> dicesIntList = new ArrayList<>();

    public ArrayList<Integer> getDicesIntList() {
        return dicesIntList;
    }
    public ArrayList<Dice> getDicesList() {
        return diceList;
    }

    //na potrzeby testow:
    public void userThrow1() {
        diceList.clear();
        diceList.add(new Dice(random.nextInt(6)+1 , false));
        diceList.add(new Dice(random.nextInt(6)+1 , false));
        diceList.add(new Dice(random.nextInt(6)+1 , false));
        diceList.add(new Dice(random.nextInt(6)+1 , false));
        diceList.add(new Dice(random.nextInt(6)+1 , false));
    }


    public ArrayList<Integer> mapDices(ArrayList<Dice> list) {
        ArrayList<Integer> dicesIntList = new ArrayList<Integer>();
            for (Dice dice : list) {
                dicesIntList.add(dice.getValue());
            }
        return dicesIntList;
    }


    public ArrayList<Dice> getDiceList() {
        return diceList;
    }

    public int singleDiceRoll() {
        return random.nextInt(6) + 1;
    }

    public int rollTheDice(Dice dice) {
        if (!dice.getSelected()) {
            return singleDiceRoll();
        } else return dice.value;
    }


    public int sumofDices(List<Dice> diceList) {
        int sum = 0;
        for (int n = 0; n < diceList.size(); n++) {
            sum += diceList.get(n).getValue();
        }
        return sum;
    }

    //docelowy:
    public void userThrow(List<Dice> diceList) {
        for (int n = 1; n <= diceList.size(); n++) {
            rollTheDice(diceList.get(n));
        }
    }


    int totalScore(HashMap<Score, Integer> result) {
        return result.values().stream().mapToInt(Integer::intValue).sum();
        //return topScore(result)+bottomScore(result);
    }

    public void reThrowDices(List<Dice> diceList) {
        for (int n = 1; n <= diceList.size(); n++) {
            rollTheDice(diceList.get(n));
        }
    }

    //mozliwosc wybrania ponizszej metody przez button -> tylko gdy kosc nie zostala wczesniej wybrana
    public boolean selectDice(Dice dice) {
        if (!dice.selected) {
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
