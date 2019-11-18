package game;

import java.util.ArrayList;
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

    public int tableResult(Score score, User user){
        if (!user.userPossibilities.get(score)) {
            return user.userResult.get(score);
        } else if(user.userPossibilities.get(score)) {
            return user.userTemporarResult.get(score);
        }
        else {
            return 0;
        }
    }

    public void acesAcceptanceButton(User user) {
        user.userResult.replace(aces, user.count(user.dicesList,1));
        user.userPossibilities.replace(aces, false);
        user.userTurn = false;
    }

    public void twosAcceptanceButton(User user) {
        user.userResult.replace(twos, user.count(user.dicesList,2));
        user.userPossibilities.replace(twos, false);
        user.userTurn = false;
    }

    public void threesAcceptanceButton(User user) {
        user.userResult.replace(threes, user.count(user.dicesList,3));
        user.userPossibilities.replace(threes, false);
        user.userTurn = false;
    }

    public void foursAcceptanceButton(User user) {
        user.userResult.replace(fours, user.count(user.dicesList,4));
        user.userPossibilities.replace(fours, false);
        user.userTurn = false;
    }

    public void fivesAcceptanceButton(User user) {
        user.userResult.replace(fives, user.count(user.dicesList,5));
        user.userPossibilities.replace(fives, false);
        user.userTurn = false;
    }

    public void sixesAcceptanceButton(User user) {
        user.userResult.replace(sixes, user.count(user.dicesList,6));
        user.userPossibilities.replace(sixes, false);
        user.userTurn = false;
    }

    public void threeOfaAKindAcceptanceButton(User user) {
        user.userResult.replace(threeOfaAKind, user.countThreeOfAKind(user.dicesList));
        user.userPossibilities.replace(threeOfaAKind, false);
        user.userTurn = false;
    }
    public void fourOfaAKindOfaAKindAcceptanceButton(User user) {
        user.userResult.replace(fourOfaAKind, user.countFourOfAKind(user.dicesList));
        user.userPossibilities.replace(fourOfaAKind, false);
        user.userTurn = false;
    }

    public void fullHouseAcceptanceButton(User user) {
        user.userResult.replace(fullHouse, user.countFullHouse(user.dicesList));
        user.userPossibilities.replace(fullHouse, false);
        user.userTurn = false;
    }

    public void smallStraightAcceptanceButton(User user) {
        user.userResult.replace(smallStraight, user.countSmallStraight(user.dicesList));
        user.userPossibilities.replace(smallStraight, false);
        user.userTurn = false;
    }

    public void largeStraightAcceptanceButton(User user) {
        user.userResult.replace(largeStraight, user.countLargeStraight(user.dicesList));
        user.userPossibilities.replace(largeStraight, false);
        user.userTurn = false;
    }

    public void fiveDiceAcceptanceButton(User user) {
        user.userResult.replace(fiveDice, user.count5dice(user.dicesList));
        user.userPossibilities.replace(fiveDice, false);
        user.userTurn = false;
    }

    public void chanceAcceptanceButton(User user) {
        user.userResult.replace(chance, user.countChance(user.dicesList));
        user.userPossibilities.replace(chance, false);
        user.userTurn = false;
    }


    public void rollTheDicePointCounter(User user) {

        if (user.userPossibilities.get(aces)) {
            user.userTemporarResult.replace(aces,user.count(user.dicesList,1));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            acesAcceptanceButton(user);
        }


        if (user.userPossibilities.get(twos)) {
            user.userTemporarResult.replace(twos,user.count(user.dicesList,2));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            twosAcceptanceButton(user);
        }


        if (user.userPossibilities.get(threes)) {
            user.userTemporarResult.replace(threes,user.count(user.dicesList,3));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            threesAcceptanceButton(user);
        }


        if (user.userPossibilities.get(fours)) {
            user.userTemporarResult.replace(fours,user.count(user.dicesList,4));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            foursAcceptanceButton(user);
        }


        if (user.userPossibilities.get(fives)) {
            user.userTemporarResult.replace(fives,user.count(user.dicesList,5));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fivesAcceptanceButton(user);
        }


        if (user.userPossibilities.get(sixes)) {
            user.userTemporarResult.replace(sixes,user.count(user.dicesList,6));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            sixesAcceptanceButton(user);
        }


        if (user.userPossibilities.get(threeOfaAKind)) {
            user.userTemporarResult.replace(threeOfaAKind,user.countThreeOfAKind(user.dicesList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            threeOfaAKindAcceptanceButton(user);
        }


        if (user.userPossibilities.get(fourOfaAKind)) {
            user.userTemporarResult.replace(fourOfaAKind,user.countFourOfAKind(user.dicesList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fourOfaAKindOfaAKindAcceptanceButton(user);
        }

        if (user.userPossibilities.get(fullHouse)) {
            user.userTemporarResult.replace(fullHouse,user.countFullHouse(user.dicesList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fullHouseAcceptanceButton(user);
        }


        if (user.userPossibilities.get(smallStraight)) {
            user.userTemporarResult.replace(smallStraight,user.countSmallStraight(user.dicesList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            smallStraightAcceptanceButton(user);

        }

        if (user.userPossibilities.get(largeStraight)) {
            user.userTemporarResult.replace(largeStraight,user.countLargeStraight(user.dicesList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            largeStraightAcceptanceButton(user);
        }


        if (user.userPossibilities.get(fiveDice)) {
            user.userTemporarResult.replace(fiveDice,user.count5dice(user.dicesList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            fiveDiceAcceptanceButton(user);
        }


        if (user.userPossibilities.get(chance)) {
            user.userTemporarResult.replace(chance,user.countChance(user.dicesList));
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            chanceAcceptanceButton(user);
        }


        if (user.userPossibilities.get(bonusPoints)) {
            if
        (
                (((!user.userPossibilities.get(aces)) && (!user.userPossibilities.get(twos)) && (!user.userPossibilities.get(threes)) &&
                        (!user.userPossibilities.get(fours)) && (!user.userPossibilities.get(fives)) && (!user.userPossibilities.get(sixes)))
                        &&
                        ((user.userResult.get(aces)) + (user.userResult.get(twos)) + (user.userResult.get(threes)) + (user.userResult.get(fours)) +
                                (user.userResult.get(fives)) + (user.userResult.get(sixes))) >= 65)) {
            user.userResult.replace(bonusPoints, 35);
            user.userPossibilities.replace(bonusPoints, false);
            }
        }

    }

    public void clearTheTemporaryPoints(User user) {
        for (Map.Entry<Score, Integer> entry : user.userTemporarResult.entrySet()) {
            entry.setValue(0);
        }
        }

    }
