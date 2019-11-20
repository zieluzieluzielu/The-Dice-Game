package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class User {

    Random random = new Random();

    public boolean userTurn;

    Score aces = new Score("Aces");
    Score twos = new Score("Twos");
    Score threes = new Score("Threes");
    Score fours = new Score("Fours");
    Score fives = new Score("Fives");
    Score sixes = new Score("Sixes");
    Score threeOfaAKind = new Score("Three Of A Kind");
    Score fourOfaAKind = new Score("Four Of A Kind");
    Score fullHouse = new Score("Full House");
    Score smallStraight = new Score("Small Straight");
    Score largeStraight = new Score("Large Straight");
    Score fiveDice = new Score("5 dice");
    Score chance = new Score("Chance");
    Score bonusPoints = new Score("Bonus");

    public int rollTheDice(Dice dice) {
        if (!dice.getSelected()) {
            dice.value = random.nextInt(6) + 1;
            return dice.value;
        } else return dice.value;
    }

    public void userThrow(List<Dice> diceList) {
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


    int diceFrequency(List<Integer> dicesIntList, int whatToCount) {
        return Collections.frequency(dicesIntList, whatToCount);

    }

    HashMap<Score, Boolean> userPossibilities = new HashMap<>();
    HashMap<Score, Integer> userResult = new HashMap<>();
    HashMap<Score, Integer> userTemporarResult = new HashMap<>();
    ArrayList<Integer> dicesIntList = new ArrayList<Integer>();
    ArrayList<Dice> diceList = new ArrayList<Dice>();


    public int count(List<Integer> dicesIntList, int whatToCount) {
        if (dicesIntList.contains(whatToCount)) {
            int occurrences = diceFrequency(dicesIntList, whatToCount);
            return occurrences * whatToCount;
        } else {
            return 0;
        }

    }

    int countThreeOfAKind(List<Integer> dicesIntList) {
        if (diceFrequency(dicesIntList, 1) >= 3 || diceFrequency(dicesIntList, 2) >= 3 || diceFrequency(dicesIntList, 3) >= 3 ||
                diceFrequency(dicesIntList, 4) >= 3 || diceFrequency(dicesIntList, 5) >= 3 || diceFrequency(dicesIntList, 6) >= 3) {
            int sum = dicesIntList.stream().mapToInt(Integer::intValue).sum();
            return sum;
        } else {
            return 0;
        }
    }


    int countFourOfAKind(List<Integer> dicesIntList) {
        if (diceFrequency(dicesIntList, 1) >= 4 || diceFrequency(dicesIntList, 2) >= 4 || diceFrequency(dicesIntList, 3) >= 4 ||
                diceFrequency(dicesIntList, 4) >= 4 || diceFrequency(dicesIntList, 5) >= 4 || diceFrequency(dicesIntList, 6) >= 4) {
            int sum = dicesIntList.stream().mapToInt(Integer::intValue).sum();
            return sum;
        } else {
            return 0;
        }
    }


    int countFullHouse(List<Integer> dicesIntList) {
        if (
                ((diceFrequency(dicesIntList, 1) == 3)
                        &&
                        (diceFrequency(dicesIntList, 2) == 2 || diceFrequency(dicesIntList, 3) == 2 || diceFrequency(dicesIntList, 4) == 2 || diceFrequency(dicesIntList, 5) == 2 || diceFrequency(dicesIntList, 6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, 2) == 3)
                                &&
                                (diceFrequency(dicesIntList, 1) == 2 || diceFrequency(dicesIntList, 3) == 2 || diceFrequency(dicesIntList, 4) == 2 || diceFrequency(dicesIntList, 5) == 2 || diceFrequency(dicesIntList, 6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, 3) == 3)
                                &&
                                (diceFrequency(dicesIntList, 1) == 2 || diceFrequency(dicesIntList, 2) == 2 || diceFrequency(dicesIntList, 4) == 2 || diceFrequency(dicesIntList, 5) == 2 || diceFrequency(dicesIntList, 6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, 4) == 3)
                                &&
                                (diceFrequency(dicesIntList, 1) == 2 || diceFrequency(dicesIntList, 2) == 2 || diceFrequency(dicesIntList, 3) == 2 || diceFrequency(dicesIntList, 5) == 2 || diceFrequency(dicesIntList, 6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, 5) == 3)
                                &&
                                (diceFrequency(dicesIntList, 1) == 2 || diceFrequency(dicesIntList, 2) == 2 || diceFrequency(dicesIntList, 3) == 2 || diceFrequency(dicesIntList, 4) == 2 || diceFrequency(dicesIntList, 6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, 6) == 3)
                                &&
                                (diceFrequency(dicesIntList, 1) == 2 || diceFrequency(dicesIntList, 2) == 2 || diceFrequency(dicesIntList, 3) == 2 || diceFrequency(dicesIntList, 4) == 2 || diceFrequency(dicesIntList, 5) == 2))
        ) {
            return 25;
        } else {
            return 0;
        }
    }

    int countSmallStraight(List<Integer> dicesIntList) {
        if (
                (dicesIntList.contains(1) && dicesIntList.contains(2) && dicesIntList.contains(3) && dicesIntList.contains(4))
                        ||
                        (dicesIntList.contains(2) && dicesIntList.contains(3) && dicesIntList.contains(4) && dicesIntList.contains(5))
                        ||
                        (dicesIntList.contains(3) && dicesIntList.contains(4) && dicesIntList.contains(5) && dicesIntList.contains(6))
        ) {
            return 30;
        } else {
            return 0;
        }
    }


    int countLargeStraight(List<Integer> dicesIntList) {
        if (
                (dicesIntList.contains(1) && dicesIntList.contains(2) && dicesIntList.contains(3) && dicesIntList.contains(4) && dicesIntList.contains(5))
                        ||
                        (dicesIntList.contains(2) && dicesIntList.contains(3) && dicesIntList.contains(4) && dicesIntList.contains(5) && dicesIntList.contains(6))
        ) {
            return 40;
        } else {
            return 0;
        }
    }


    int count5dice(List<Integer> dicesIntList) {
        if (diceFrequency(dicesIntList, 1) >= 5 || diceFrequency(dicesIntList, 2) >= 5 || diceFrequency(dicesIntList, 3) >= 5 ||
                diceFrequency(dicesIntList, 4) >= 5 || diceFrequency(dicesIntList, 5) >= 5 || diceFrequency(dicesIntList, 6) >= 5) {
            return 50;
        } else {
            return 0;
        }
    }

    int countChance(List<Integer> dicesIntList) {
        int sum = dicesIntList.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

    int topScore(HashMap<Score, Integer> result) {
        int countTopScore = ((result.get(aces)) + (result.get(twos)) + (result.get(threes)) + (result.get(fours)) + (result.get(fives)) + (result.get(sixes)) + (result.get(bonusPoints)));
        return countTopScore;
    }

    int bottomScore(HashMap<Score, Integer> result) {
        int countBottomScore = ((result.get(threeOfaAKind)) + (result.get(fourOfaAKind)) + (result.get(fullHouse)) + (result.get(smallStraight)) + (result.get(largeStraight)) + (result.get(fiveDice)) + (result.get(chance)));
        return countBottomScore;
    }

    int totalScore(HashMap<Score, Integer> result) {
        return result.values().stream().mapToInt(Integer::intValue).sum();
        //return topScore(result)+bottomScore(result);
    }


}
