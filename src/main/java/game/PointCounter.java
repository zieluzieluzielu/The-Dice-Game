package game;

import java.util.Map;

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

    public int tableResult(Score score, User user) {
        if (!user.userPossibilities.get(score)) {
            return user.userResult.get(score);
        }
        else if (user.userPossibilities.get(score)) {
            return user.userTemporarResult.get(score);
        }
        else {
            return 0;
        }
    }

    public void acesAcceptanceButton(User user) {
        user.userResult.replace(aces, user.count(user.dicesIntList, 1));
        user.userPossibilities.replace(aces, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void twosAcceptanceButton(User user) {
        user.userResult.replace(twos, user.count(user.dicesIntList, 2));
        user.userPossibilities.replace(twos, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void threesAcceptanceButton(User user) {
        user.userResult.replace(threes, user.count(user.dicesIntList, 3));
        user.userPossibilities.replace(threes, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void foursAcceptanceButton(User user) {
        user.userResult.replace(fours, user.count(user.dicesIntList, 4));
        user.userPossibilities.replace(fours, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fivesAcceptanceButton(User user) {
        user.userResult.replace(fives, user.count(user.dicesIntList, 5));
        user.userPossibilities.replace(fives, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void sixesAcceptanceButton(User user) {
        user.userResult.replace(sixes, user.count(user.dicesIntList, 6));
        user.userPossibilities.replace(sixes, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void threeOfaAKindAcceptanceButton(User user) {
        user.userResult.replace(threeOfaAKind, user.countThreeOfAKind(user.dicesIntList));
        user.userPossibilities.replace(threeOfaAKind, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fourOfaAKindOfaAKindAcceptanceButton(User user) {
        user.userResult.replace(fourOfaAKind, user.countFourOfAKind(user.dicesIntList));
        user.userPossibilities.replace(fourOfaAKind, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fullHouseAcceptanceButton(User user) {
        user.userResult.replace(fullHouse, user.countFullHouse(user.dicesIntList));
        user.userPossibilities.replace(fullHouse, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void smallStraightAcceptanceButton(User user) {
        user.userResult.replace(smallStraight, user.countSmallStraight(user.dicesIntList));
        user.userPossibilities.replace(smallStraight, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void largeStraightAcceptanceButton(User user) {
        user.userResult.replace(largeStraight, user.countLargeStraight(user.dicesIntList));
        user.userPossibilities.replace(largeStraight, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void fiveDiceAcceptanceButton(User user) {
        user.userResult.replace(fiveDice, user.count5dice(user.dicesIntList));
        user.userPossibilities.replace(fiveDice, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }

    public void chanceAcceptanceButton(User user) {
        user.userResult.replace(chance, user.countChance(user.dicesIntList));
        user.userPossibilities.replace(chance, false);
        user.userTurn = false;
        clearTheTemporaryPoints(user);
    }


    public void rollTheDicePointCounter(User user) {

        if (user.userPossibilities.get(aces)) {
            user.userTemporarResult.replace(aces, user.count(user.dicesIntList, 1));
            //[BUTTON] zatwierdzający:
            acesAcceptanceButton(user);
        }


        if (user.userPossibilities.get(twos)) {
            user.userTemporarResult.replace(twos, user.count(user.dicesIntList, 2));
            //[BUTTON] zatwierdzający:
            twosAcceptanceButton(user);
        }


        if (user.userPossibilities.get(threes)) {
            user.userTemporarResult.replace(threes, user.count(user.dicesIntList, 3));
            //[BUTTON] zatwierdzający:
            threesAcceptanceButton(user);
        }


        if (user.userPossibilities.get(fours)) {
            user.userTemporarResult.replace(fours, user.count(user.dicesIntList, 4));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            foursAcceptanceButton(user);
        }


        if (user.userPossibilities.get(fives)) {
            user.userTemporarResult.replace(fives, user.count(user.dicesIntList, 5));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fivesAcceptanceButton(user);
        }


        if (user.userPossibilities.get(sixes)) {
            user.userTemporarResult.replace(sixes, user.count(user.dicesIntList, 6));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            sixesAcceptanceButton(user);
        }


        if (user.userPossibilities.get(threeOfaAKind)) {
            user.userTemporarResult.replace(threeOfaAKind, user.countThreeOfAKind(user.dicesIntList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            threeOfaAKindAcceptanceButton(user);
        }


        if (user.userPossibilities.get(fourOfaAKind)) {
            user.userTemporarResult.replace(fourOfaAKind, user.countFourOfAKind(user.dicesIntList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fourOfaAKindOfaAKindAcceptanceButton(user);
        }

        if (user.userPossibilities.get(fullHouse)) {
            user.userTemporarResult.replace(fullHouse, user.countFullHouse(user.dicesIntList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fullHouseAcceptanceButton(user);
        }


        if (user.userPossibilities.get(smallStraight)) {
            user.userTemporarResult.replace(smallStraight, user.countSmallStraight(user.dicesIntList));
            //[BUTTON] zatwierdzający:
            smallStraightAcceptanceButton(user);

        }

        if (user.userPossibilities.get(largeStraight)) {
            user.userTemporarResult.replace(largeStraight, user.countLargeStraight(user.dicesIntList));
            //[BUTTON] zatwierdzający:
            largeStraightAcceptanceButton(user);
        }


        if (user.userPossibilities.get(fiveDice)) {
            user.userTemporarResult.replace(fiveDice, user.count5dice(user.dicesIntList));
            //[BUTTON] zatwierdzający:
            fiveDiceAcceptanceButton(user);
        }


        if (user.userPossibilities.get(chance)) {
            user.userTemporarResult.replace(chance, user.countChance(user.dicesIntList));
            //[BUTTON] zatwierdzający:
            chanceAcceptanceButton(user);
        }


        if (user.userPossibilities.get(bonusPoints)) {
            if
            (((user.userResult.get(aces)) + (user.userResult.get(twos)) + (user.userResult.get(threes)) + (user.userResult.get(fours)) +
                    (user.userResult.get(fives)) + (user.userResult.get(sixes))) >= 65) {
                user.userResult.replace(bonusPoints, 35);
                user.userPossibilities.replace(bonusPoints, false);
            }
        }

        user.userResult.replace(topScore, user.topScore(user.userResult));
        user.userResult.replace(bottomScore, user.bottomScore(user.userResult));

    }

    public int getBottomScore(User user) {
        int bottomScore = user.bottomScore(user.userResult);
        return bottomScore;
    }

    public int getTopScore(User user) {
        int topScore = user.topScore(user.userResult);
        return topScore;
    }

    public int getTotalScore(User user) {
        int totalScore = user.totalScore(user.userResult);
        return totalScore;
    }

    public void clearTheTemporaryPoints(User user) {
        for (Map.Entry<Score, Integer> entry : user.userTemporarResult.entrySet()) {
            entry.setValue(0);
        }

    }
}
