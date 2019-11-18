package ui;

import game.Dice;
import game.PointCounter;
import game.Score;
import game.User;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TheDiceGameTest {

    void diceGameScenario() {
        User user = new User();

        boolean userTurn;

        //stworzenie obiektow 5 kosci

        Dice dice1 = new Dice(0, false);
        Dice dice2 = new Dice(0, false);
        Dice dice3 = new Dice(0, false);
        Dice dice4 = new Dice(0, false);
        Dice dice5 = new Dice(0, false);

        //stworzenie obiektow do rozrozniania punktacji
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
        Score bonusPoints = new Score("Bonus Points");
        Score topScore = new Score("Top Score");
        Score bottomScore = new Score("Bottom Score");
        Score totalScore = new Score("Total Score");
        //a moze zrobic interfejs Score w ktorym kazda punktacja by zawierala wlasna metode obliczania punktow? (bylo by 13+ klas)

        //stworzenie obiektu zliczajacego
        PointCounter pointCounter = new PointCounter();

        //stworzenie list kosci (pomyslec jak zastapic to jedna zamiast dwoch)
        ArrayList<Integer> dicesList = new ArrayList<>();
        ArrayList<Dice> diceList = new ArrayList<>();

        //dodanie do listy (typu Dice) 5 kosci
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);

        //hashmapa z mozliwosciami wyrzutu
        HashMap<Score,Boolean> userPossibilities = new HashMap<>();
        userPossibilities.put(aces,true);
        userPossibilities.put(twos,true);
        userPossibilities.put(threes,true);
        userPossibilities.put(fours,true);
        userPossibilities.put(fives,true);
        userPossibilities.put(sixes,true);
        userPossibilities.put(threeOfaAKind,true);
        userPossibilities.put(fourOfaAKind,true);
        userPossibilities.put(fullHouse,true);
        userPossibilities.put(smallStraight,true);
        userPossibilities.put(largeStraight,true);
        userPossibilities.put(fiveDice,true);
        userPossibilities.put(chance,true);
        userPossibilities.put(bonusPoints,true);
        userPossibilities.put(topScore,true);
        userPossibilities.put(bottomScore,true);

        //hashmapa zliczająca punktacje per pozycja (początkowa ilosc punktow = 0)
        HashMap<Score,Integer> userResult = new HashMap<>();
        userResult.put(aces,0);
        userResult.put(twos,0);
        userResult.put(threes,0);
        userResult.put(fours,0);
        userResult.put(fives,0);
        userResult.put(sixes,0);
        userResult.put(threeOfaAKind,0);
        userResult.put(fourOfaAKind,0);
        userResult.put(fullHouse,0);
        userResult.put(smallStraight,0);
        userResult.put(largeStraight,0);
        userResult.put(fiveDice,0);
        userResult.put(chance,0);
        userResult.put(bonusPoints,0);
        userResult.put(topScore,0);
        userResult.put(bottomScore,0);

        //Hashmapa z tymczasowym rezultatem dla każdej z pozycji (odroznic kolorem czcionke)
        HashMap<Score,Integer> userTemporarResult = new HashMap<>();
        userTemporarResult.put(aces,0);
        userTemporarResult.put(twos,0);
        userTemporarResult.put(threes,0);
        userTemporarResult.put(fours,0);
        userTemporarResult.put(fives,0);
        userTemporarResult.put(sixes,0);
        userTemporarResult.put(threeOfaAKind,0);
        userTemporarResult.put(fourOfaAKind,0);
        userTemporarResult.put(fullHouse,0);
        userTemporarResult.put(smallStraight,0);
        userTemporarResult.put(largeStraight,0);
        userTemporarResult.put(fiveDice,0);
        userTemporarResult.put(chance,0);
        userResult.put(bonusPoints,0);
        userResult.put(topScore,0);
        userResult.put(bottomScore,0);

        //wyrzut 5 koscmi:
        user.userThrow(diceList,user);

        //dodanie wartosci kosci do listy kosci
        user.addDicesToList(diceList,dicesList);

        //wyliczenie tymczasowej punktacji do tabeli
        pointCounter.rollTheDicePointCounter(user);

        //wyczyszczenie temporarypoints listy:
        pointCounter.clearTheTemporaryPoints(user);

        //kliknięcie i zaakceptowanie punktow dla szansy (nowa runda)
        pointCounter.chanceAcceptanceButton(user);

        //tabela Usera:
        pointCounter.tableResult(aces,user);
        pointCounter.tableResult(twos,user);
        pointCounter.tableResult(threes,user);
        pointCounter.tableResult(fours,user);
        pointCounter.tableResult(fives,user);
        pointCounter.tableResult(sixes,user);
        pointCounter.tableResult(threeOfaAKind,user);
        pointCounter.tableResult(fourOfaAKind,user);
        pointCounter.tableResult(fullHouse,user);
        pointCounter.tableResult(smallStraight,user);
        pointCounter.tableResult(largeStraight,user);
        pointCounter.tableResult(fiveDice,user);
        pointCounter.tableResult(chance,user);

        pointCounter.tableResult(bonusPoints,user);

        pointCounter.tableResult(topScore,user);
        pointCounter.tableResult(bottomScore,user);
        pointCounter.tableResult(totalScore,user);



        //wyczyszczenie temporary resultu, zostawienie tylko userResult

        //wyczyszczenie kosci
        dicesList.clear();
        diceList.clear();

        //select first two dices
        user.selectDice(dice1);
        user.selectDice(dice2);

        //dokonczyc realne testy

        //dodac do tabeli metody wyliczajace total / bottom / top score
        // user.topScore(userResult);

        //ruch komputera












        selectPoints();

        countBonus();
        countTop();
        countBottom();
        countTotal();

        rollTheDice2();
        countThePoints();
        selectDice();
        selectPoints();

        countBonus();
        countTop();
        countBottom();
        countTotal();

        rolltheDice3();
        countThePoints();
        selectPoints();

        countBonus();
        countTop();
        countBottom();
        countTotal();

        computerTurn();

        //round 2
        //...
        //round 13
        //...

        //endGame
        showWinner();






    }


}