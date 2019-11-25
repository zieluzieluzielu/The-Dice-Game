package game;

import java.util.*;

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


    int diceFrequency(List<Integer> dicesIntList, SingleDiceScore singleDiceScore) {
        return Collections.frequency(dicesIntList, singleDiceScore.getDiceScore());

    }

    public int count(List<Integer> dicesIntList, SingleDiceScore singleDiceScore) {
        if (dicesIntList.contains(singleDiceScore.getDiceScore())) {
            int occurrences = diceFrequency(dicesIntList, singleDiceScore);
            return occurrences * singleDiceScore.getDiceScore();
        } else {
            return 0;
        }

    }

    int countThreeOfAKind(List<Integer> dicesIntList) {
        if (diceFrequency(dicesIntList, diceScore1) >= 3 || diceFrequency(dicesIntList, diceScore2) >= 3 || diceFrequency(dicesIntList, diceScore3) >= 3 ||
                diceFrequency(dicesIntList, diceScore4) >= 3 || diceFrequency(dicesIntList, diceScore5) >= 3 || diceFrequency(dicesIntList, diceScore6) >= 3) {
            int sum = dicesIntList.stream().mapToInt(Integer::intValue).sum();
            return sum;
        } else {
            return 0;
        }
    }


    int countFourOfAKind(List<Integer> dicesIntList) {
        if (diceFrequency(dicesIntList, diceScore1) >= 4 || diceFrequency(dicesIntList, diceScore2) >= 4 || diceFrequency(dicesIntList, diceScore3) >= 4 ||
                diceFrequency(dicesIntList, diceScore4) >= 4 || diceFrequency(dicesIntList, diceScore5) >= 4 || diceFrequency(dicesIntList, diceScore6) >= 4) {
            int sum = dicesIntList.stream().mapToInt(Integer::intValue).sum();
            return sum;
        } else {
            return 0;
        }
    }


    int countFullHouse(List<Integer> dicesIntList) {
        if (
                ((diceFrequency(dicesIntList, diceScore1) == 3)
                        &&
                        (diceFrequency(dicesIntList, diceScore2) == 2 || diceFrequency(dicesIntList, diceScore3) == 2 || diceFrequency(dicesIntList, diceScore4) == 2 || diceFrequency(dicesIntList, diceScore5) == 2 || diceFrequency(dicesIntList, diceScore6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, diceScore2) == 3)
                                &&
                                (diceFrequency(dicesIntList, diceScore1) == 2 || diceFrequency(dicesIntList, diceScore3) == 2 || diceFrequency(dicesIntList, diceScore4) == 2 || diceFrequency(dicesIntList, diceScore5) == 2 || diceFrequency(dicesIntList, diceScore6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, diceScore3) == 3)
                                &&
                                (diceFrequency(dicesIntList, diceScore1) == 2 || diceFrequency(dicesIntList, diceScore2) == 2 || diceFrequency(dicesIntList, diceScore4) == 2 || diceFrequency(dicesIntList, diceScore5) == 2 || diceFrequency(dicesIntList, diceScore6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, diceScore4) == 3)
                                &&
                                (diceFrequency(dicesIntList, diceScore1) == 2 || diceFrequency(dicesIntList, diceScore2) == 2 || diceFrequency(dicesIntList, diceScore3) == 2 || diceFrequency(dicesIntList, diceScore5) == 2 || diceFrequency(dicesIntList, diceScore6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, diceScore5) == 3)
                                &&
                                (diceFrequency(dicesIntList, diceScore1) == 2 || diceFrequency(dicesIntList, diceScore2) == 2 || diceFrequency(dicesIntList, diceScore3) == 2 || diceFrequency(dicesIntList, diceScore4) == 2 || diceFrequency(dicesIntList, diceScore6) == 2))
                        ||
                        ((diceFrequency(dicesIntList, diceScore6) == 3)
                                &&
                                (diceFrequency(dicesIntList, diceScore1) == 2 || diceFrequency(dicesIntList, diceScore2) == 2 || diceFrequency(dicesIntList, diceScore3) == 2 || diceFrequency(dicesIntList, diceScore4) == 2 || diceFrequency(dicesIntList, diceScore5) == 2))
        ) {
            return 25;
        } else {
            return 0;
        }
    }

    int countSmallStraight(List<Integer> dicesIntList) {
        if (
                (dicesIntList.contains(diceScore1.getDiceScore()) && dicesIntList.contains(diceScore2.getDiceScore()) && dicesIntList.contains(diceScore3.getDiceScore()) && dicesIntList.contains(diceScore4.getDiceScore()))
                        ||
                        (dicesIntList.contains(diceScore2.getDiceScore()) && dicesIntList.contains(diceScore3.getDiceScore()) && dicesIntList.contains(diceScore4.getDiceScore()) && dicesIntList.contains(diceScore5.getDiceScore()))
                        ||
                        (dicesIntList.contains(diceScore3.getDiceScore()) && dicesIntList.contains(diceScore4.getDiceScore()) && dicesIntList.contains(diceScore5.getDiceScore()) && dicesIntList.contains(diceScore6.getDiceScore()))
        ) {
            return 30;
        } else {
            return 0;
        }
    }


    int countLargeStraight(List<Integer> dicesIntList) {
        if (
                (dicesIntList.contains(diceScore1.getDiceScore()) && dicesIntList.contains(diceScore2.getDiceScore()) && dicesIntList.contains(diceScore3.getDiceScore()) && dicesIntList.contains(diceScore4.getDiceScore())  && dicesIntList.contains(diceScore5.getDiceScore()))
                        ||
                        (dicesIntList.contains(diceScore2.getDiceScore()) && dicesIntList.contains(diceScore3.getDiceScore()) && dicesIntList.contains(diceScore4.getDiceScore()) && dicesIntList.contains(diceScore5.getDiceScore()) && dicesIntList.contains(diceScore6.getDiceScore()))
        ) {
            return 40;
        } else {
            return 0;
        }
    }


    int count5dice(List<Integer> dicesIntList) {
        if (diceFrequency(dicesIntList, diceScore1) >= 5 || diceFrequency(dicesIntList, diceScore2) >= 5 || diceFrequency(dicesIntList, diceScore3) >= 5 ||
                diceFrequency(dicesIntList, diceScore4) >= 5 || diceFrequency(dicesIntList, diceScore5) >= 5 || diceFrequency(dicesIntList, diceScore6) >= 5) {
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
        userResult.replace(aces, count(dicesIntList, diceScore1));
        userPossibilities.replace(aces, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void twosAcceptanceButton(User user) {
        userResult.replace(twos, count(dicesIntList, diceScore2));
        userPossibilities.replace(twos, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void threesAcceptanceButton(User user) {
        userResult.replace(threes, count(dicesIntList, diceScore3));
        userPossibilities.replace(threes, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void foursAcceptanceButton(User user) {
        userResult.replace(fours, count(dicesIntList, diceScore4));
        userPossibilities.replace(fours, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fivesAcceptanceButton(User user) {
        userResult.replace(fives, count(dicesIntList, diceScore5));
        userPossibilities.replace(fives, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void sixesAcceptanceButton(User user) {
        userResult.replace(sixes, count(dicesIntList, diceScore6));
        userPossibilities.replace(sixes, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void threeOfaAKindAcceptanceButton(User user) {
        userResult.replace(threeOfaAKind, countThreeOfAKind(dicesIntList));
        userPossibilities.replace(threeOfaAKind, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fourOfaAKindOfaAKindAcceptanceButton(User user) {
        userResult.replace(fourOfaAKind, countFourOfAKind(dicesIntList));
        userPossibilities.replace(fourOfaAKind, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fullHouseAcceptanceButton(User user) {
        userResult.replace(fullHouse, countFullHouse(dicesIntList));
        userPossibilities.replace(fullHouse, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void smallStraightAcceptanceButton(User user) {
        userResult.replace(smallStraight, countSmallStraight(dicesIntList));
        userPossibilities.replace(smallStraight, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void largeStraightAcceptanceButton(User user) {
        userResult.replace(largeStraight, countLargeStraight(dicesIntList));
        userPossibilities.replace(largeStraight, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fiveDiceAcceptanceButton(User user) {
        userResult.replace(fiveDice, count5dice(dicesIntList));
        userPossibilities.replace(fiveDice, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void chanceAcceptanceButton(User user) {
        userResult.replace(chance, countChance(dicesIntList));
        userPossibilities.replace(chance, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }


    public void rollTheDicePointCounter(User user) {

        if (userPossibilities.get(aces)) {
            userTemporarResult.replace(aces, count(dicesIntList, diceScore1));
            //[BUTTON] zatwierdzający:
            acesAcceptanceButton(user);
        }


        if (userPossibilities.get(twos)) {
            userTemporarResult.replace(twos, count(dicesIntList, diceScore2));
            //[BUTTON] zatwierdzający:
            twosAcceptanceButton(user);
        }


        if (userPossibilities.get(threes)) {
            userTemporarResult.replace(threes, count(dicesIntList, diceScore3));
            //[BUTTON] zatwierdzający:
            threesAcceptanceButton(user);
        }


        if (userPossibilities.get(fours)) {
            userTemporarResult.replace(fours, count(dicesIntList, diceScore4));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            foursAcceptanceButton(user);
        }


        if (userPossibilities.get(fives)) {
            userTemporarResult.replace(fives, count(dicesIntList, diceScore5));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fivesAcceptanceButton(user);
        }


        if (userPossibilities.get(sixes)) {
            userTemporarResult.replace(sixes, count(dicesIntList, diceScore6));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            sixesAcceptanceButton(user);
        }


        if (userPossibilities.get(threeOfaAKind)) {
            userTemporarResult.replace(threeOfaAKind, countThreeOfAKind(dicesIntList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            threeOfaAKindAcceptanceButton(user);
        }


        if (userPossibilities.get(fourOfaAKind)) {
            userTemporarResult.replace(fourOfaAKind, countFourOfAKind(dicesIntList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fourOfaAKindOfaAKindAcceptanceButton(user);
        }

        if (userPossibilities.get(fullHouse)) {
            userTemporarResult.replace(fullHouse, countFullHouse(dicesIntList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fullHouseAcceptanceButton(user);
        }


        if (userPossibilities.get(smallStraight)) {
            userTemporarResult.replace(smallStraight, countSmallStraight(dicesIntList));
            //[BUTTON] zatwierdzający:
            smallStraightAcceptanceButton(user);

        }

        if (userPossibilities.get(largeStraight)) {
            userTemporarResult.replace(largeStraight, countLargeStraight(dicesIntList));
            //[BUTTON] zatwierdzający:
            largeStraightAcceptanceButton(user);
        }


        if (userPossibilities.get(fiveDice)) {
            userTemporarResult.replace(fiveDice, count5dice(dicesIntList));
            //[BUTTON] zatwierdzający:
            fiveDiceAcceptanceButton(user);
        }


        if (userPossibilities.get(chance)) {
            userTemporarResult.replace(chance, countChance(dicesIntList));
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
