package game;

import java.util.*;
import java.util.stream.Collectors;

public class PointCounter {

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

    Score bonusPoints = new Score("BonusPoints");
    Score topScore = new Score("Top Score");
    Score bottomScore = new Score("Bottom Score");

    ArrayList<Integer> dicesIntList = new ArrayList<Integer>();
    ArrayList<Dice> diceList = new ArrayList<Dice>();

    HashMap<Score, Boolean> userPossibilities = new HashMap<>();
    HashMap<Score, Integer> userResult = new HashMap<>();
    HashMap<Score, Integer> userTemporarResult = new HashMap<>();

    SingleDiceScore diceScore1 = new SingleDiceScore(1);
    SingleDiceScore diceScore2 = new SingleDiceScore(2);
    SingleDiceScore diceScore3 = new SingleDiceScore(3);
    SingleDiceScore diceScore4 = new SingleDiceScore(4);
    SingleDiceScore diceScore5 = new SingleDiceScore(5);
    SingleDiceScore diceScore6 = new SingleDiceScore(6);


    //collect(Collectors.toList())

    int diceFrequency(List<Dice> diceList, SingleDiceScore singleDiceScore) {
        return Collections.frequency(diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()), singleDiceScore.getDiceScore());

    }

    public int count(List<Dice> diceList, SingleDiceScore singleDiceScore) {
        if (diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(singleDiceScore.getDiceScore())) {
            int occurrences = diceFrequency(diceList, singleDiceScore);
            return occurrences * singleDiceScore.getDiceScore();
        } else {
            return 0;
        }

    }

    public int countThreeOfAKind(List<Dice> diceList) {
        if (diceFrequency(diceList, diceScore1) >= 3 || diceFrequency(diceList, diceScore2) >= 3 || diceFrequency(diceList, diceScore3) >= 3 ||
                diceFrequency(diceList, diceScore4) >= 3 || diceFrequency(diceList, diceScore5) >= 3 || diceFrequency(diceList, diceScore6) >= 3) {
            int sum = diceList.stream().mapToInt(i -> i.getValue()).sum();
            return sum;
        } else {
            return 0;
        }
    }


    public int countFourOfAKind(List<Dice> diceList) {
        if (diceFrequency(diceList, diceScore1) >= 4 || diceFrequency(diceList, diceScore2) >= 4 || diceFrequency(diceList, diceScore3) >= 4 ||
                diceFrequency(diceList, diceScore4) >= 4 || diceFrequency(diceList, diceScore5) >= 4 || diceFrequency(diceList, diceScore6) >= 4) {
            int sum = diceList.stream().mapToInt(i -> i.getValue()).sum();
            return sum;
        } else {
            return 0;
        }
    }


    public int countFullHouse(List<Dice> diceList) {
        if (
                ((diceFrequency(diceList, diceScore1) == 3)
                        &&
                        (diceFrequency(diceList, diceScore2) == 2 || diceFrequency(diceList, diceScore3) == 2 || diceFrequency(diceList, diceScore4) == 2 || diceFrequency(diceList, diceScore5) == 2 || diceFrequency(diceList, diceScore6) == 2))
                        ||
                        ((diceFrequency(diceList, diceScore2) == 3)
                                &&
                                (diceFrequency(diceList, diceScore1) == 2 || diceFrequency(diceList, diceScore3) == 2 || diceFrequency(diceList, diceScore4) == 2 || diceFrequency(diceList, diceScore5) == 2 || diceFrequency(diceList, diceScore6) == 2))
                        ||
                        ((diceFrequency(diceList, diceScore3) == 3)
                                &&
                                (diceFrequency(diceList, diceScore1) == 2 || diceFrequency(diceList, diceScore2) == 2 || diceFrequency(diceList, diceScore4) == 2 || diceFrequency(diceList, diceScore5) == 2 || diceFrequency(diceList, diceScore6) == 2))
                        ||
                        ((diceFrequency(diceList, diceScore4) == 3)
                                &&
                                (diceFrequency(diceList, diceScore1) == 2 || diceFrequency(diceList, diceScore2) == 2 || diceFrequency(diceList, diceScore3) == 2 || diceFrequency(diceList, diceScore5) == 2 || diceFrequency(diceList, diceScore6) == 2))
                        ||
                        ((diceFrequency(diceList, diceScore5) == 3)
                                &&
                                (diceFrequency(diceList, diceScore1) == 2 || diceFrequency(diceList, diceScore2) == 2 || diceFrequency(diceList, diceScore3) == 2 || diceFrequency(diceList, diceScore4) == 2 || diceFrequency(diceList, diceScore6) == 2))
                        ||
                        ((diceFrequency(diceList, diceScore6) == 3)
                                &&
                                (diceFrequency(diceList, diceScore1) == 2 || diceFrequency(diceList, diceScore2) == 2 || diceFrequency(diceList, diceScore3) == 2 || diceFrequency(diceList, diceScore4) == 2 || diceFrequency(diceList, diceScore5) == 2))
        ) {
            return 25;
        } else {
            return 0;
        }
    }


    public int countSmallStraight(List<Dice> diceList) {
        if (
                (diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore1.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore2.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore3.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore4.getDiceScore()))
                        ||
                        (diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore2.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore3.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore4.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore5.getDiceScore()))
                        ||
                        (diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore3.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore4.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore5.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore6.getDiceScore()))
        ) {
            return 30;
        } else {
            return 0;
        }
    }


    public int countLargeStraight(List<Dice> diceList) {
        if (
                (diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore1.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore2.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore3.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore4.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore5.getDiceScore()))
                        ||
                        (diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore2.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore3.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore4.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore5.getDiceScore()) && diceList.stream().map(i -> i.getValue()).collect(Collectors.toList()).contains(diceScore6.getDiceScore()))
        ) {
            return 40;
        } else {
            return 0;
        }
    }


    public int count5dice(List<Dice> diceList) {
        if (diceFrequency(diceList, diceScore1) >= 5 || diceFrequency(diceList, diceScore2) >= 5 || diceFrequency(diceList, diceScore3) >= 5 ||
                diceFrequency(diceList, diceScore4) >= 5 || diceFrequency(diceList, diceScore5) >= 5 || diceFrequency(diceList, diceScore6) >= 5) {
            return 50;
        } else {
            return 0;
        }
    }

    public int countChance(List<Dice> diceList) {
        int sum = diceList.stream().mapToInt(i -> i.getValue()).sum();
        return sum;
    }

    public int topScore(HashMap<Score, Integer> result) {
        int countTopScore = ((result.get(aces)) + (result.get(twos)) + (result.get(threes)) + (result.get(fours)) + (result.get(fives)) + (result.get(sixes)) + (result.get(bonusPoints)));
        return countTopScore;
    }

    public int bottomScore(HashMap<Score, Integer> result) {
        int countBottomScore = ((result.get(threeOfaAKind)) + (result.get(fourOfaAKind)) + (result.get(fullHouse)) + (result.get(smallStraight)) + (result.get(largeStraight)) + (result.get(fiveDice)) + (result.get(chance)));
        return countBottomScore;
    }

    public int totalScore(HashMap<Score, Integer> result) {
        return result.values().stream().mapToInt(Integer::intValue).sum();
        //return topScore(result)+bottomScore(result);
    }


    public int tableResult(Score score, User user) {
        if (!userPossibilities.get(score)) {
            return userResult.get(score);
        } else if (userPossibilities.get(score)) {
            return userTemporarResult.get(score);
        } else {
            return 0;
        }
    }


    public void acesAcceptanceButton(User user) {
        userResult.replace(aces, count(diceList, diceScore1));
        userPossibilities.replace(aces, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void twosAcceptanceButton(User user) {
        userResult.replace(twos, count(diceList, diceScore2));
        userPossibilities.replace(twos, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void threesAcceptanceButton(User user) {
        userResult.replace(threes, count(diceList, diceScore3));
        userPossibilities.replace(threes, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void foursAcceptanceButton(User user) {
        userResult.replace(fours, count(diceList, diceScore4));
        userPossibilities.replace(fours, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fivesAcceptanceButton(User user) {
        userResult.replace(fives, count(diceList, diceScore5));
        userPossibilities.replace(fives, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void sixesAcceptanceButton(User user) {
        userResult.replace(sixes, count(diceList, diceScore6));
        userPossibilities.replace(sixes, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void threeOfaAKindAcceptanceButton(User user) {
        userResult.replace(threeOfaAKind, countThreeOfAKind(diceList));
        userPossibilities.replace(threeOfaAKind, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fourOfaAKindOfaAKindAcceptanceButton(User user) {
        userResult.replace(fourOfaAKind, countFourOfAKind(diceList));
        userPossibilities.replace(fourOfaAKind, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fullHouseAcceptanceButton(User user) {
        userResult.replace(fullHouse, countFullHouse(diceList));
        userPossibilities.replace(fullHouse, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void smallStraightAcceptanceButton(User user) {
        userResult.replace(smallStraight, countSmallStraight(diceList));
        userPossibilities.replace(smallStraight, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void largeStraightAcceptanceButton(User user) {
        userResult.replace(largeStraight, countLargeStraight(diceList));
        userPossibilities.replace(largeStraight, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fiveDiceAcceptanceButton(User user) {
        userResult.replace(fiveDice, count5dice(diceList));
        userPossibilities.replace(fiveDice, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void chanceAcceptanceButton(User user) {
        userResult.replace(chance, countChance(diceList));
        userPossibilities.replace(chance, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }


    public void rollTheDicePointCounter(User user) {

        if (userPossibilities.get(aces)) {
            userTemporarResult.replace(aces, count(diceList, diceScore1));
            //[BUTTON] zatwierdzający:
            acesAcceptanceButton(user);
        }


        if (userPossibilities.get(twos)) {
            userTemporarResult.replace(twos, count(diceList, diceScore2));
            //[BUTTON] zatwierdzający:
            twosAcceptanceButton(user);
        }


        if (userPossibilities.get(threes)) {
            userTemporarResult.replace(threes, count(diceList, diceScore3));
            //[BUTTON] zatwierdzający:
            threesAcceptanceButton(user);
        }


        if (userPossibilities.get(fours)) {
            userTemporarResult.replace(fours, count(diceList, diceScore4));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            foursAcceptanceButton(user);
        }


        if (userPossibilities.get(fives)) {
            userTemporarResult.replace(fives, count(diceList, diceScore5));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fivesAcceptanceButton(user);
        }


        if (userPossibilities.get(sixes)) {
            userTemporarResult.replace(sixes, count(diceList, diceScore6));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            sixesAcceptanceButton(user);
        }


        if (userPossibilities.get(threeOfaAKind)) {
            userTemporarResult.replace(threeOfaAKind, countThreeOfAKind(diceList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            threeOfaAKindAcceptanceButton(user);
        }


        if (userPossibilities.get(fourOfaAKind)) {
            userTemporarResult.replace(fourOfaAKind, countFourOfAKind(diceList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fourOfaAKindOfaAKindAcceptanceButton(user);
        }

        if (userPossibilities.get(fullHouse)) {
            userTemporarResult.replace(fullHouse, countFullHouse(diceList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fullHouseAcceptanceButton(user);
        }


        if (userPossibilities.get(smallStraight)) {
            userTemporarResult.replace(smallStraight, countSmallStraight(diceList));
            //[BUTTON] zatwierdzający:
            smallStraightAcceptanceButton(user);

        }

        if (userPossibilities.get(largeStraight)) {
            userTemporarResult.replace(largeStraight, countLargeStraight(diceList));
            //[BUTTON] zatwierdzający:
            largeStraightAcceptanceButton(user);
        }


        if (userPossibilities.get(fiveDice)) {
            userTemporarResult.replace(fiveDice, count5dice(diceList));
            //[BUTTON] zatwierdzający:
            fiveDiceAcceptanceButton(user);
        }


        if (userPossibilities.get(chance)) {
            userTemporarResult.replace(chance, countChance(diceList));
            //[BUTTON] zatwierdzający:
            chanceAcceptanceButton(user);
        }


        if (userPossibilities.get(bonusPoints)) {
            if
            (((userResult.get(aces)) + (userResult.get(twos)) + (userResult.get(threes)) + (userResult.get(fours)) +
                    (userResult.get(fives)) + (userResult.get(sixes))) >= 65) {
                userResult.replace(bonusPoints, 35);
                userPossibilities.replace(bonusPoints, false);
            }
        }

        userResult.replace(topScore, topScore(userResult));
        userResult.replace(bottomScore, bottomScore(userResult));

    }

    public int getBottomScore(User user) {
        int bottomScore = bottomScore(userResult);
        return bottomScore;
    }

    public int getTopScore(User user) {
        int topScore = topScore(userResult);
        return topScore;
    }

    public int getTotalScore(User user) {
        int totalScore = totalScore(userResult);
        return totalScore;
    }

    public void clearTheTemporaryPoints(User user) {
        for (Map.Entry<Score, Integer> entry : userTemporarResult.entrySet()) {
            entry.setValue(0);
        }

    }


}
