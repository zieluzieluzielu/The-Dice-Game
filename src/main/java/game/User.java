package game;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class User {
    HashMap<String,Boolean> userPossibilities = new HashMap<String,Boolean>();
    HashMap<String, Integer> userResult = new HashMap<String, Integer>();

    int count(List<Integer> dicesList, int whatToCount){
        if (dicesList.contains(1)) {
            int occurrences = Collections.frequency(dicesList, whatToCount);
            return occurrences*1;
        }
        else {
            return 0;
        }

    }

    int countThreeOfAKind(List<Integer> dicesList) {
        if (Collections.frequency(dicesList, 1)>=3 || Collections.frequency(dicesList, 2)>=3 || Collections.frequency(dicesList, 3)>=3 ||
                Collections.frequency(dicesList, 4)>=3 || Collections.frequency(dicesList, 5)>=3 || Collections.frequency(dicesList, 6)>=3) {
            int sum = dicesList.stream().mapToInt(Integer::intValue).sum();
            return sum;
        }
        else {
            return 0;
        }
    }


    int countFourOfAKind(List<Integer> dicesList) {
        if (Collections.frequency(dicesList, 1)>=4 || Collections.frequency(dicesList, 2)>=4 || Collections.frequency(dicesList, 3)>=4 ||
                Collections.frequency(dicesList, 4)>=4 || Collections.frequency(dicesList, 5)>=4 || Collections.frequency(dicesList, 6)>=4) {
            int sum = dicesList.stream().mapToInt(Integer::intValue).sum();
            return sum;
        }
        else {
            return 0;
        }
    }


    int countFullHouse(List<Integer> dicesList) {
        if (
                ((Collections.frequency(dicesList, 1)==3)
                        &&
                        (Collections.frequency(dicesList, 2)==2 || Collections.frequency(dicesList, 3)==2 || Collections.frequency(dicesList, 4)==2 || Collections.frequency(dicesList, 5)==2 || Collections.frequency(dicesList, 6)==2))
                        ||
                        ((Collections.frequency(dicesList, 2)==3)
                                &&
                                (Collections.frequency(dicesList, 1)==2 || Collections.frequency(dicesList, 3)==2 || Collections.frequency(dicesList, 4)==2 || Collections.frequency(dicesList, 5)==2 || Collections.frequency(dicesList, 6)==2))
                        ||
                        ((Collections.frequency(dicesList, 3)==3)
                                &&
                                (Collections.frequency(dicesList, 1)==2 || Collections.frequency(dicesList, 2)==2 || Collections.frequency(dicesList, 4)==2 || Collections.frequency(dicesList, 5)==2 || Collections.frequency(dicesList, 6)==2))
                        ||
                        ((Collections.frequency(dicesList, 4)==3)
                                &&
                                (Collections.frequency(dicesList, 1)==2 || Collections.frequency(dicesList, 2)==2 || Collections.frequency(dicesList, 3)==2 || Collections.frequency(dicesList, 5)==2 || Collections.frequency(dicesList, 6)==2))
                        ||
                        ((Collections.frequency(dicesList, 5)==3)
                                &&
                                (Collections.frequency(dicesList, 1)==2 || Collections.frequency(dicesList, 2)==2 || Collections.frequency(dicesList, 3)==2 || Collections.frequency(dicesList, 4)==2 || Collections.frequency(dicesList, 6)==2))
                        ||
                        ((Collections.frequency(dicesList, 6)==3)
                                &&
                                (Collections.frequency(dicesList, 1)==2 || Collections.frequency(dicesList, 2)==2 || Collections.frequency(dicesList, 3)==2 || Collections.frequency(dicesList, 4)==2 || Collections.frequency(dicesList, 5)==2))
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
        if (Collections.frequency(dicesList, 1)>=5 || Collections.frequency(dicesList, 2)>=5 || Collections.frequency(dicesList, 3)>=5 ||
                Collections.frequency(dicesList, 4)>=5 || Collections.frequency(dicesList, 5)>=5 || Collections.frequency(dicesList, 6)>=5) {
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


    int topScore(HashMap<String,Integer> result) {
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
