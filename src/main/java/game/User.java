package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class User {

    Random random = new Random();



    boolean userTurn;

    public int rollTheDice(Dice dice){
        if (!dice.getSelected()) {
            dice.value = random.nextInt(6)+1;
            return dice.value;
        }
        else return dice.value;
    }

    public void userThrow (List<Dice> diceList, User user) {
        for (int n = 1; n <= diceList.size(); n++) {
            user.rollTheDice(diceList.get(n));
        }
    }

    public boolean selectDice(Dice dice){
        if (!dice.selected){
            return dice.selected = true;
        }
        else {
            System.out.println("Dice was already selected");
            return dice.selected;
        }
    }

    public void addDicesToList (List<Dice> diceList, List<Integer> dicesList){
        for (int n = 1; n <= diceList.size(); n++) {
            dicesList.add(diceList.get(n).getValue());
        }
    }




    HashMap<Score,Boolean> userPossibilities = new HashMap<>(); //(osobna klasa)
    HashMap<Score,Integer> userResult = new HashMap<>(); //(osobna klasa)
    HashMap<Score,Integer> userTemporarResult = new HashMap<>(); //(osobna klasa)


    //!opakowywanie stringow ew. zamienianie mapy w liste z obiektami

    ArrayList<Integer> dicesList = new ArrayList<Integer>(); //(osobna klasa)
    ArrayList<Dice> diceList = new ArrayList<Dice>(); //(osobna klasa)


    int diceFrequency(List<Integer> dicesList, int whatToCount) {
        return  Collections.frequency(dicesList, whatToCount);

    }


    public int count(List<Integer> dicesList, int whatToCount){
        if (dicesList.contains(whatToCount)) {
            int occurrences = diceFrequency(dicesList, whatToCount);
            return occurrences*whatToCount;
        }
        else {
            return 0;
        }

    }

    int countThreeOfAKind(List<Integer> dicesList) {
        if (diceFrequency(dicesList, 1)>=3 || diceFrequency(dicesList, 2)>=3 || diceFrequency(dicesList, 3)>=3 ||
                diceFrequency(dicesList, 4)>=3 || diceFrequency(dicesList, 5)>=3 || diceFrequency(dicesList, 6)>=3) {
            int sum = dicesList.stream().mapToInt(Integer::intValue).sum();
            return sum;
        }
        else {
            return 0;
        }
    }


    int countFourOfAKind(List<Integer> dicesList) {
        if (diceFrequency(dicesList, 1)>=4 || diceFrequency(dicesList, 2)>=4 || diceFrequency(dicesList, 3)>=4 ||
                diceFrequency(dicesList, 4)>=4 || diceFrequency(dicesList, 5)>=4 || diceFrequency(dicesList, 6)>=4) {
            int sum = dicesList.stream().mapToInt(Integer::intValue).sum();
            return sum;
        }
        else {
            return 0;
        }
    }


    int countFullHouse(List<Integer> dicesList) {
        if (
                ((diceFrequency(dicesList, 1)==3)
                        &&
                        (diceFrequency(dicesList, 2)==2 || diceFrequency(dicesList, 3)==2 || diceFrequency(dicesList, 4)==2 || diceFrequency(dicesList, 5)==2 || diceFrequency(dicesList, 6)==2))
                        ||
                        ((diceFrequency(dicesList, 2)==3)
                                &&
                                (diceFrequency(dicesList, 1)==2 || diceFrequency(dicesList, 3)==2 || diceFrequency(dicesList, 4)==2 || diceFrequency(dicesList, 5)==2 || diceFrequency(dicesList, 6)==2))
                        ||
                        ((diceFrequency(dicesList, 3)==3)
                                &&
                                (diceFrequency(dicesList, 1)==2 || diceFrequency(dicesList, 2)==2 || diceFrequency(dicesList, 4)==2 || diceFrequency(dicesList, 5)==2 || diceFrequency(dicesList, 6)==2))
                        ||
                        ((diceFrequency(dicesList, 4)==3)
                                &&
                                (diceFrequency(dicesList, 1)==2 || diceFrequency(dicesList, 2)==2 || diceFrequency(dicesList, 3)==2 || diceFrequency(dicesList, 5)==2 || diceFrequency(dicesList, 6)==2))
                        ||
                        ((diceFrequency(dicesList, 5)==3)
                                &&
                                (diceFrequency(dicesList, 1)==2 || diceFrequency(dicesList, 2)==2 || diceFrequency(dicesList, 3)==2 || diceFrequency(dicesList, 4)==2 || diceFrequency(dicesList, 6)==2))
                        ||
                        ((diceFrequency(dicesList, 6)==3)
                                &&
                                (diceFrequency(dicesList, 1)==2 || diceFrequency(dicesList, 2)==2 || diceFrequency(dicesList, 3)==2 || diceFrequency(dicesList, 4)==2 || diceFrequency(dicesList, 5)==2))
        ) {
            int sum = dicesList.stream().mapToInt(Integer::intValue).sum();
            return sum;
        }
        else {
            return 0;
        }
    }

    int countSmallStraight(List<Integer> dicesList) {
        if (
                (dicesList.contains(1) && dicesList.contains(2) && dicesList.contains(3) && dicesList.contains(4))
                        ||
                        (dicesList.contains(2) && dicesList.contains(3) && dicesList.contains(4) && dicesList.contains(5))
                        ||
                        (dicesList.contains(3) && dicesList.contains(4) && dicesList.contains(5) && dicesList.contains(6))
        ) {
            return 30;
        }
        else {
            return 0;
        }
    }


    int countLargeStraight(List<Integer> dicesList) {
        if (
                (dicesList.contains(1) && dicesList.contains(2) && dicesList.contains(3) && dicesList.contains(4) && dicesList.contains(5))
                        ||
                        (dicesList.contains(2) && dicesList.contains(3) && dicesList.contains(4) && dicesList.contains(5) && dicesList.contains(6))
        ) {
            return 40;
        }
        else {
            return 0;
        }
    }


    int count5dice(List<Integer> dicesList) {
        if (diceFrequency(dicesList, 1)>=5 || diceFrequency(dicesList, 2)>=5 || diceFrequency(dicesList, 3)>=5 ||
                diceFrequency(dicesList, 4)>=5 || diceFrequency(dicesList, 5)>=5 || diceFrequency(dicesList, 6)>=5) {
            return 50;
        }
        else {
            return 0;
        }
    }


    int countChance(List<Integer> dicesList) {
        int sum = dicesList.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }


   public int topScore(HashMap<String,Integer> result) {
        int countTopScore = ((result.get("acesPoints"))+(result.get("twosPoints"))+(result.get("threesPoints"))+(result.get("foursPoints"))+(result.get("fivesPoints"))+(result.get("sixesPoints")));
        return result.replace("topScorePoints",countTopScore);
    }


    int bottomScore(HashMap<String,Integer> result) {
        int countBottomScore = ((result.get("threeOfAKindPoints"))+(result.get("fourOfAKindPoints"))+(result.get("fullHousePoints"))+(result.get("smallStraightPoints"))+(result.get("largeStraightPoints"))+(result.get("5dicePoints"))+(result.get("chancePoints")));
        return result.replace("BottomScorePoints",countBottomScore);
    }


    int totalScore(HashMap<String,Integer> result) {
        return result.values().stream().mapToInt(Integer::intValue).sum();
    }


}
