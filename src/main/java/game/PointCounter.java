package game;

public class PointCounter {


    void rollTheDicePointCounter(User user) {

        //bardziej rozbudowany if - do populacji w pozostałych poniżej
        if (user.userPossibilities.get("acesPoints")) {
            //wyświetlanie wyliczonej liczby punktów w odpowiednim polu w tabeli:
            user.count(user.dicesList,1);
            //[BUTTON] zatwierdzający, po jego zatwierdzeniu (kliknięciu):
            user.userResult.replace("acesPoints", user.count(user.dicesList,1));
            user.userPossibilities.replace("acesPoints", false);
            user.userTurn = false;
        }


        if (user.userPossibilities.get("twosPoints")) {
//..
            user.userResult.replace("twosPoints", user.count(user.dicesList,2));
            user.userPossibilities.replace("twosPoints", false);
            user.userTurn = false;
        }


        if (user.userPossibilities.get("threesPoints")) {
//..
            user.userResult.replace("threesPoints", user.count(user.dicesList,3));
            user.userPossibilities.replace("threesPoints", false);
            user.userTurn = false;
        }


        if (user.userPossibilities.get("foursPoints")) {
//..
            user.userResult.replace("foursPoints", user.count(user.dicesList,4));
            user.userPossibilities.replace("foursPoints", false);
            user.userTurn = false;
        }

        if (user.userPossibilities.get("fivesPoints")) {
//..
            user.userResult.replace("fivesPoints", user.count(user.dicesList,5));
            user.userPossibilities.replace("fivesPoints", false);
            user.userTurn = false;
        }


        if (user.userPossibilities.get("sixesPoints")) {
//..
            user.userResult.replace("sixesPoints", user.count(user.dicesList,6));
            user.userPossibilities.replace("sixesPoints", false);
            user.userTurn = false;
        }


        if (user.userPossibilities.get("threeOfAKindPoints")) {
//..
            user.userResult.replace("threeOfAKindPoints", user.countThreeOfAKind(user.dicesList));
            user.userPossibilities.replace("threeOfAKindPoints", false);
            user.userTurn = false;
        }


        if (user.userPossibilities.get("fourOfAKindPoints")) {
//..
            user.userResult.replace("fourOfAKindPoints", user.countFourOfAKind(user.dicesList));
            user.userPossibilities.replace("fourOfAKindPoints", false);
            user.userTurn = false;
        }

        if (user.userPossibilities.get("fullHousePoints")) {
//..
            user.userResult.replace("fullHousePoints", user.countFullHouse(user.dicesList));
            user.userPossibilities.replace("fullHousePoints", false);
            user.userTurn = false;
        }


        if (user.userPossibilities.get("smallStraightPoints")) {
//..
            user.userResult.replace("smallStraightPoints", user.countSmallStraight(user.dicesList));
            user.userPossibilities.replace("smallStraightPoints", false);
            user.userTurn = false;
        }

        if (user.userPossibilities.get("largeStraightPoints")) {
//..
            user.userResult.replace("largeStraightPoints", user.countLargeStraight(user.dicesList));
            user.userPossibilities.replace("largeStraightPoints", false);
            user.userTurn = false;
        }


        if (user.userPossibilities.get("5dicePoints")) {
//..
            user.userResult.replace("5dicePoints", user.count5dice(user.dicesList));
            user.userPossibilities.replace("5dicePoints", false);
            user.userTurn = false;
        }


        if (user.userPossibilities.get("chancePoints")) {
//..
            user.userResult.replace("chancePoints", user.countChance(user.dicesList));
            user.userPossibilities.replace("chancePoints", false);
            user.userTurn = false;
        }


        if (
                (((!user.userPossibilities.get("acesPoints")) && (!user.userPossibilities.get("twosPoints")) && (!user.userPossibilities.get("threesPoints")) &&
                        (!user.userPossibilities.get("foursPoints")) && (!user.userPossibilities.get("fivesPoints")) && (!user.userPossibilities.get("sixesPoints")))
                        &&
                        ((user.userResult.get("acesPoints")) + (user.userResult.get("twosPoints")) + (user.userResult.get("threesPoints")) + (user.userResult.get("foursPoints")) + (user.userResult.get("fivesPoints")) + (user.userResult.get("sixesPoints"))) >= 65)) {
            user.userResult.replace("bonusPoints", 35);
        }

    }
}
