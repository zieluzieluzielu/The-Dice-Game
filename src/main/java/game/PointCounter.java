package game;

import java.util.*;
import java.util.stream.Collectors;

public class PointCounter {

    public PointCounter() {
        scoreMap();
        scorePossibilities();
        scoreTemporarMap();
    }

    private Score aces = new Score("Aces");
    private Score twos = new Score("Twos");
    private Score threes = new Score("Threes");
    private Score fours = new Score("Fours");
    private Score fives = new Score("Fives");
    private Score sixes = new Score("Sixes");

    private Score threeOfaAKind = new Score("Three Of A Kind");
    private Score fourOfaAKind = new Score("Four Of A Kind");
    private Score fullHouse = new Score("Full House");
    private Score smallStraight = new Score("Small Straight");
    private Score largeStraight = new Score("Large Straight");
    private Score fiveDice = new Score("5 dice");
    private Score chance = new Score("Chance");

    private Score bonusPoints = new Score("BonusPoints");
    private Score topScore = new Score("Top Score");
    private Score bottomScore = new Score("Bottom Score");

    private HashMap<Score, Boolean> userPossibilities = new HashMap<>();
    private HashMap<Score, Integer> userResult = new HashMap<>();
    private HashMap<Score, Integer> userTemporarResult = new HashMap<>();

    private HashMap<Score, Integer> scoreMap() {
        userResult.put(aces, 0);
        userResult.put(twos, 0);
        userResult.put(threes, 0);
        userResult.put(fours, 0);
        userResult.put(fives, 0);
        userResult.put(sixes, 0);
        userResult.put(threeOfaAKind, 0);
        userResult.put(fourOfaAKind, 0);
        userResult.put(fullHouse, 0);
        userResult.put(smallStraight, 0);
        userResult.put(largeStraight, 0);
        userResult.put(fiveDice, 0);
        userResult.put(chance, 0);
        userResult.put(bonusPoints, 0);
        userResult.put(topScore, 0);
        userResult.put(bottomScore, 0);
        return userResult;
    }

    private HashMap<Score, Integer> scoreTemporarMap() {
        userTemporarResult.put(aces, 0);
        userTemporarResult.put(twos, 0);
        userTemporarResult.put(threes, 0);
        userTemporarResult.put(fours, 0);
        userTemporarResult.put(fives, 0);
        userTemporarResult.put(sixes, 0);
        userTemporarResult.put(threeOfaAKind, 0);
        userTemporarResult.put(fourOfaAKind, 0);
        userTemporarResult.put(fullHouse, 0);
        userTemporarResult.put(smallStraight, 0);
        userTemporarResult.put(largeStraight, 0);
        userTemporarResult.put(fiveDice, 0);
        userTemporarResult.put(chance, 0);
        userTemporarResult.put(bonusPoints, 0);
        userTemporarResult.put(topScore, 0);
        userTemporarResult.put(bottomScore, 0);
        return userTemporarResult;
    }

    private HashMap<Score, Boolean> scorePossibilities() {
        userPossibilities.put(aces, true);
        userPossibilities.put(twos, true);
        userPossibilities.put(threes, true);
        userPossibilities.put(fours, true);
        userPossibilities.put(fives, true);
        userPossibilities.put(sixes, true);
        userPossibilities.put(threeOfaAKind, true);
        userPossibilities.put(fourOfaAKind, true);
        userPossibilities.put(fullHouse, true);
        userPossibilities.put(smallStraight, true);
        userPossibilities.put(largeStraight, true);
        userPossibilities.put(fiveDice, true);
        userPossibilities.put(chance, true);
        userPossibilities.put(bonusPoints, true);
        userPossibilities.put(topScore, true);
        userPossibilities.put(bottomScore, true);
        return userPossibilities;
    }

    public HashMap<Score, Boolean> getUserPossibilities() {
        return userPossibilities;
    }

    public HashMap<Score, Integer> getUserResult() {
        return userResult;
    }

    public HashMap<Score, Integer> getUserTemporarResult() {
        return userTemporarResult;
    }

    public Score getAces() {
        return aces;
    }

    public Score getTwos() {
        return twos;
    }


    public void bonusCounter() {
        if (getUserPossibilities().get(bonusPoints)) {
            if (((getUserResult().get(aces)) + (getUserResult().get(twos)) + (getUserResult().get(threes)) + (getUserResult().get(fours)) +
                    (getUserResult().get(fives)) + (getUserResult().get(sixes))) >= 63) {
                getUserResult().replace(bonusPoints, 35);
                getUserPossibilities().replace(bonusPoints, false);
            }
        }
    }

    public Score getThrees() {
        return threes;
    }

    public Score getFours() {
        return fours;
    }

    public Score getFives() {
        return fives;
    }

    public Score getSixes() {
        return sixes;
    }

    public Score getThreeOfaAKind() {
        return threeOfaAKind;
    }

    public Score getFourOfaAKind() {
        return fourOfaAKind;
    }

    public Score getFullHouse() {
        return fullHouse;
    }

    public Score getSmallStraight() {
        return smallStraight;
    }

    public Score getLargeStraight() {
        return largeStraight;
    }

    public Score getFiveDice() {
        return fiveDice;
    }

    public Score getChance() {
        return chance;
    }

    public Score getBonusPoints() {
        return bonusPoints;
    }

    public Score getTopScore(){
        return topScore;
    }

    private SingleDiceScore diceScore1 = new SingleDiceScore(1);
    private SingleDiceScore diceScore2 = new SingleDiceScore(2);
    private SingleDiceScore diceScore3 = new SingleDiceScore(3);
    private SingleDiceScore diceScore4 = new SingleDiceScore(4);
    private SingleDiceScore diceScore5 = new SingleDiceScore(5);
    private SingleDiceScore diceScore6 = new SingleDiceScore(6);



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
        int countTopScore = ((result.get(aces)) + (result.get(twos)) + (result.get(threes)) + (result.get(fours)) + (result.get(fives)) + (result.get(sixes)));
        return countTopScore;
    }

    public int bottomScore(HashMap<Score, Integer> result) {
        int countBottomScore = ((result.get(threeOfaAKind)) + (result.get(fourOfaAKind)) + (result.get(fullHouse)) + (result.get(smallStraight)) + (result.get(largeStraight)) + (result.get(fiveDice)) + (result.get(chance)));
        return countBottomScore;
    }

    public int totalScore(HashMap<Score, Integer> result) {
        return result.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int tableResult(Score score) {
        if (!getUserPossibilities().get(score)) {
            return getUserResult().get(score);
        } else if (getUserPossibilities().get(score)) {
            return getUserTemporarResult().get(score);
        } else {
            return 0;
        }
    }


    public void acesAcceptance(User user) {
            getUserResult().replace(aces, count(user.getDiceList(), diceScore1));
            getUserPossibilities().replace(aces, false);
            user.userTurn = false;
            clearTheTemporaryPoints();
    }

    public void twosAcceptance(User user) {
        getUserResult().replace(twos, count(user.getDiceList(), diceScore2));
        getUserPossibilities().replace(twos, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void threesAcceptance(User user) {
        getUserResult().replace(threes, count(user.getDiceList(), diceScore3));
        getUserPossibilities().replace(threes, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void foursAcceptance(User user) {
        getUserResult().replace(fours, count(user.getDiceList(), diceScore4));
        getUserPossibilities().replace(fours, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void fivesAcceptance(User user) {
        getUserResult().replace(fives, count(user.getDiceList(), diceScore5));
        getUserPossibilities().replace(fives, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void sixesAcceptance(User user) {
        getUserResult().replace(sixes, count(user.getDiceList(), diceScore6));
        getUserPossibilities().replace(sixes, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }


    public void threeOfaAKindAcceptance(User user) {
        getUserResult().replace(threeOfaAKind, countThreeOfAKind(user.getDiceList()));
        getUserPossibilities().replace(threeOfaAKind, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void fourOfaAKindOfaAKindAcceptance(User user) {
        getUserResult().replace(fourOfaAKind, countFourOfAKind(user.getDiceList()));
        getUserPossibilities().replace(fourOfaAKind, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void fullHouseAcceptance(User user) {
        getUserResult().replace(fullHouse, countFullHouse(user.getDiceList()));
        getUserPossibilities().replace(fullHouse, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void smallStraightAcceptance(User user) {
        getUserResult().replace(smallStraight, countSmallStraight(user.getDiceList()));
        getUserPossibilities().replace(smallStraight, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void largeStraightAcceptance(User user) {
        getUserResult().replace(largeStraight, countLargeStraight(user.getDiceList()));
        getUserPossibilities().replace(largeStraight, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void fiveDiceAcceptance(User user) {
        getUserResult().replace(fiveDice, count5dice(user.getDiceList()));
        getUserPossibilities().replace(fiveDice, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void chanceAcceptance(User user) {
        getUserResult().replace(chance, countChance(user.getDiceList()));
        getUserPossibilities().replace(chance, false);
        user.userTurn = false;
        clearTheTemporaryPoints();
    }

    public void pointsBeforeUserAcceptance(User user) {

        if (getUserPossibilities().get(aces)) {
            getUserTemporarResult().replace(aces, count(user.getDiceList(), diceScore1));
        }

        if (getUserPossibilities().get(twos)) {
            getUserTemporarResult().replace(twos, count(user.getDiceList(), diceScore2));
        }

        if (getUserPossibilities().get(threes)) {
            getUserTemporarResult().replace(threes, count(user.getDiceList(), diceScore3));
        }

        if (getUserPossibilities().get(fours)) {
            getUserTemporarResult().replace(fours, count(user.getDiceList(), diceScore4));
        }

        if (getUserPossibilities().get(fives)) {
            getUserTemporarResult().replace(fives, count(user.getDiceList(), diceScore5));
        }


        if (getUserPossibilities().get(sixes)) {
            getUserTemporarResult().replace(sixes, count(user.getDiceList(), diceScore6));
        }

        if (getUserPossibilities().get(threeOfaAKind)) {
            getUserTemporarResult().replace(threeOfaAKind, countThreeOfAKind(user.getDiceList()));
        }

        if (getUserPossibilities().get(fourOfaAKind)) {
            getUserTemporarResult().replace(fourOfaAKind, countFourOfAKind(user.getDiceList()));
        }

        if (getUserPossibilities().get(fullHouse)) {
            getUserTemporarResult().replace(fullHouse, countFullHouse(user.getDiceList()));
        }

        if (getUserPossibilities().get(smallStraight)) {
            getUserTemporarResult().replace(smallStraight, countSmallStraight(user.getDiceList()));
        }

        if (getUserPossibilities().get(largeStraight)) {
            getUserTemporarResult().replace(largeStraight, countLargeStraight(user.getDiceList()));
        }

        if (getUserPossibilities().get(fiveDice)) {
            getUserTemporarResult().replace(fiveDice, count5dice(user.getDiceList()));
        }

        if (getUserPossibilities().get(chance)) {
            getUserTemporarResult().replace(chance, countChance(user.getDiceList()));
        }
    }

    private void clearTheTemporaryPoints() {
        for (Map.Entry<Score, Integer> entry : getUserTemporarResult().entrySet()) {
            entry.setValue(0);
        }

    }

}
