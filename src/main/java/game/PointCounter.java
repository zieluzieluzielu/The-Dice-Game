package game;

public class PointCounter {



    void rollTheDicePointCounter(User user) {

        //bardziej rozbudowany if - do populacji w pozostałych poniżej
        if (userPossibilities.get("acesPoints")) {
            //wyświetlanie wyliczonej liczby punktów w odpowiednim polu w tabeli:
            user.count(dicesList,1);
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            userResult.replace("acesPoints", user.count(dicesList,1));
            userPossibilities.replace("acesPoints", false);
            userTurn = false;
        }


        if (userPossibilities.get("twosPoints")) {
//..
            userResult.replace("twosPoints", user.count(dicesList,2));
            userPossibilities.replace("twosPoints", false);
            userTurn = false;
        }


        if (userPossibilities.get("threesPoints")) {
//..
            userResult.replace("threesPoints", user.count(dicesList,3));
            userPossibilities.replace("threesPoints", false);
            userTurn = false;
        }


        if (userPossibilities.get("foursPoints")) {
//..
            userResult.replace("foursPoints", user.count(dicesList,4));
            userPossibilities.replace("foursPoints", false);
            userTurn = false;
        }

        if (userPossibilities.get("fivesPoints")) {
//..
            userResult.replace("fivesPoints", user.count(dicesList,5));
            userPossibilities.replace("fivesPoints", false);
            userTurn = false;
        }


        if (userPossibilities.get("sixesPoints")) {
//..
            userResult.replace("sixesPoints", user.count(dicesList,6));
            userPossibilities.replace("sixesPoints", false);
            userTurn = false;
        }


        if (userPossibilities.get("threeOfAKindPoints")) {
//..
            userResult.replace("threeOfAKindPoints", user.countThreeOfAKind(dicesList));
            userPossibilities.replace("threeOfAKindPoints", false);
            userTurn = false;
        }


        if (userPossibilities.get("fourOfAKindPoints")) {
//..
            userResult.replace("fourOfAKindPoints", user.countFourOfAKind(dicesList));
            userPossibilities.replace("fourOfAKindPoints", false);
            userTurn = false;
        }

        if (userPossibilities.get("fullHousePoints")) {
//..
            userResult.replace("fullHousePoints", user.countFullHouse(dicesList));
            userPossibilities.replace("fullHousePoints", false);
            userTurn = false;
        }


        if (userPossibilities.get("smallStraightPoints")) {
//..
            userResult.replace("smallStraightPoints", user.countSmallStraight(dicesList));
            userPossibilities.replace("smallStraightPoints", false);
            userTurn = false;
        }

        if (userPossibilities.get("largeStraightPoints")) {
//..
            userResult.replace("largeStraightPoints", user.countLargeStraight(dicesList));
            userPossibilities.replace("largeStraightPoints", false);
            userTurn = false;
        }


        if (userPossibilities.get("5dicePoints")) {
//..
            userResult.replace("5dicePoints", user.count5dice(dicesList));
            userPossibilities.replace("5dicePoints", false);
            userTurn = false;
        }


        if (userPossibilities.get("chancePoints")) {
//..
            userResult.replace("chancePoints", user.countChance(dicesList));
            userPossibilities.replace("chancePoints", false);
            userTurn = false;
        }


        if (
                (((!userPossibilities.get("acesPoints")) && (!userPossibilities.get("twosPoints")) && (!userPossibilities.get("threesPoints")) &&
                        (!userPossibilities.get("foursPoints")) && (!userPossibilities.get("fivesPoints")) && (!userPossibilities.get("sixesPoints")))
                        &&
                        ((userResult.get("acesPoints")) + (userResult.get("twosPoints")) + (userResult.get("threesPoints")) + (userResult.get("foursPoints")) + (userResult.get("fivesPoints")) + (userResult.get("sixesPoints"))) >= 65)) {
            userResult.replace("bonusPoints", 35);
        }

    }
}
