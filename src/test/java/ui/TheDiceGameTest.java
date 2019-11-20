package ui;

import game.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TheDiceGameTest {

    @Test
    public void diceGameScenario() {

        //GIVEN
        User user = new User();
        Computer computer = new Computer();
        user.userTurn = true;

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
        //a moze zrobic interfejs Score w ktorym kazda punktacja by zawierala wlasna metode obliczania punktow? (bylo by dodatkowo 13+ klas)

        //stworzenie obiektu zliczajacego
        PointCounter pointCounter = new PointCounter();
        ComputerPointCounter computerPointCounter = new ComputerPointCounter();

        //stworzenie list kosci (pomyslec jak zastapic to jedna zamiast dwoch):
        //jedna  typu Integer z samymi wartosciami - potrzebnymi do wyliczenia punktacji
        //druga typu Dice (zawierająca integer i boolean) - potrzebna do wyboru kosci
        ArrayList<Integer> dicesIntList = new ArrayList<>();
        ArrayList<Dice> diceList = new ArrayList<>();

        //dodanie do listy (typu Dice) 5 kosci
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);

        //hashmapa z mozliwosciami wyboru Usera (true - user moze wybrac do punktacji)
        HashMap<Score, Boolean> userPossibilities = new HashMap<>();
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

        //hashmapa z mozliwosciami wyboru komputera (true - user moze wybrac do punktacji)
        HashMap<Score, Boolean> computerPossibilities = new HashMap<>();
        computerPossibilities.put(aces, true);
        computerPossibilities.put(twos, true);
        computerPossibilities.put(threes, true);
        computerPossibilities.put(fours, true);
        computerPossibilities.put(fives, true);
        computerPossibilities.put(sixes, true);
        computerPossibilities.put(threeOfaAKind, true);
        computerPossibilities.put(fourOfaAKind, true);
        computerPossibilities.put(fullHouse, true);
        computerPossibilities.put(smallStraight, true);
        computerPossibilities.put(largeStraight, true);
        computerPossibilities.put(fiveDice, true);
        computerPossibilities.put(chance, true);
        computerPossibilities.put(bonusPoints, true);

        //hashmapa zliczająca punktacje per pozycja (początkowa ilosc punktow = 0)
        HashMap<Score, Integer> userResult = new HashMap<>();
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

        //hashmapa zliczająca punktacje per pozycja (początkowa ilosc punktow = 0)
        HashMap<Score, Integer> computerResult = new HashMap<>();
        computerResult.put(aces, 0);
        computerResult.put(twos, 0);
        computerResult.put(threes, 0);
        computerResult.put(fours, 0);
        computerResult.put(fives, 0);
        computerResult.put(sixes, 0);
        computerResult.put(threeOfaAKind, 0);
        computerResult.put(fourOfaAKind, 0);
        computerResult.put(fullHouse, 0);
        computerResult.put(smallStraight, 0);
        computerResult.put(largeStraight, 0);
        computerResult.put(fiveDice, 0);
        computerResult.put(chance, 0);
        computerResult.put(bonusPoints, 0);

        //Hashmapa z tymczasowym rezultatem dla każdej z pozycji (odroznic kolorem czcionke) - brak topScore, bottomScore - bo są nadpisywane i liczone osobno
        HashMap<Score, Integer> userTemporarResult = new HashMap<>();
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

        //mozliwe ruchy komputera (poczatkowo jest ich 13):
        ArrayList<Score> computerTemporarResult = new ArrayList<>();
        computerTemporarResult.add(aces);
        computerTemporarResult.add(twos);
        computerTemporarResult.add(threes);
        computerTemporarResult.add(fours);
        computerTemporarResult.add(fives);
        computerTemporarResult.add(sixes);
        computerTemporarResult.add(threeOfaAKind);
        computerTemporarResult.add(fourOfaAKind);
        computerTemporarResult.add(fullHouse);
        computerTemporarResult.add(smallStraight);
        computerTemporarResult.add(largeStraight);
        computerTemporarResult.add(fiveDice);
        computerTemporarResult.add(chance);

        //tabela Usera (pokazujaca wartosci z listy userResult, lub gdy nie zostaly wybrane z temporaryResult)
        //czy tabela bedzie sie uatomatycznie nadpisywac?
        pointCounter.tableResult(aces, user);
        pointCounter.tableResult(twos, user);
        pointCounter.tableResult(threes, user);
        pointCounter.tableResult(fours, user);
        pointCounter.tableResult(fives, user);
        pointCounter.tableResult(sixes, user);
        pointCounter.tableResult(threeOfaAKind, user);
        pointCounter.tableResult(fourOfaAKind, user);
        pointCounter.tableResult(fullHouse, user);
        pointCounter.tableResult(smallStraight, user);
        pointCounter.tableResult(largeStraight, user);
        pointCounter.tableResult(fiveDice, user);
        pointCounter.tableResult(chance, user);

        pointCounter.tableResult(bonusPoints, user);

        pointCounter.getTopScore(user);
        pointCounter.getBottomScore(user);
        pointCounter.getTotalScore(user);


        //tabela Komputera (pokazujaca wartosci z listy computerResult):
        //czy tabela bedzie sie uatomatycznie nadpisywac?
        computerPointCounter.tableResult(aces, computer);
        computerPointCounter.tableResult(twos, computer);
        computerPointCounter.tableResult(threes, computer);
        computerPointCounter.tableResult(fours, computer);
        computerPointCounter.tableResult(fives, computer);
        computerPointCounter.tableResult(sixes, computer);
        computerPointCounter.tableResult(threeOfaAKind, computer);
        computerPointCounter.tableResult(fourOfaAKind, computer);
        computerPointCounter.tableResult(fullHouse, computer);
        computerPointCounter.tableResult(smallStraight, computer);
        computerPointCounter.tableResult(largeStraight, computer);
        computerPointCounter.tableResult(fiveDice, computer);
        computerPointCounter.tableResult(chance, computer);

        computerPointCounter.tableResult(bonusPoints, computer);

        computerPointCounter.getTopScore(computer);
        computerPointCounter.getBottomScore(computer);
        computerPointCounter.getTotalScore(computer);

        computerPointCounter.tableResult(bonusPoints, computer);

        //zamockowana klasa ruchu komputera
        ComputerDrawResult computerDrawResultMock = mock(ComputerDrawResult.class);
        when(computerDrawResultMock.draw()).thenReturn(aces);
        Computer computerMock = mock(Computer.class);
        when(computerMock.countAces()).thenReturn(4);


        //WHEN
        //[ROUND 1]:
        //NORMALNIE : wyrzut 5 kosci:
        //user.userThrow(diceList);

        //NA POTRZEBY TESTOW:
        dicesIntList.clear();
        diceList.clear();
        dice1 = new Dice(4, false);
        dice2 = new Dice(1, false);
        dice3 = new Dice(1, false);
        dice4 = new Dice(4, false);
        dice5 = new Dice(3, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);

        //dodanie wartosci kosci do listy kosci
        user.addDicesToList(diceList, dicesIntList);

        //wybranie pierwszych 3 kosci:
        user.selectDice(dice1);
        user.selectDice(dice2);
        user.selectDice(dice3);

        //cofniecie wybrania pierwszej kosci:
        user.unSelectDice(dice1);

        //wyczyszczenie kosci (tylko tych ktore zostaly niewybrane)
        dicesIntList.clear();
        diceList.clear();

        //drugi wyrzut:
        dice1 = new Dice(1, false);
        dice4 = new Dice(5, false);
        dice5 = new Dice(6, false);
        diceList.add(dice1);
        diceList.add(dice4);
        diceList.add(dice5);
        //user.userThrow(diceList);
        user.addDicesToList(diceList, dicesIntList);

        //wybranie pierwszej kosci:
        user.selectDice(dice1);

        //wyczyszczenie kosci (tylko tych ktore zostaly niewybrane)
        dicesIntList.clear();
        diceList.clear();

        //trzeci wyrzut:
        dice4 = new Dice(1, false);
        dice5 = new Dice(6, false);
        diceList.add(dice4);
        diceList.add(dice5);
        //user.userThrow(diceList);
        user.addDicesToList(diceList, dicesIntList);

        //wyliczenie tymczasowej punktacji do tabeli - metoda zawiera także buttony z zatwierdzeniem konkretnej (mozliwej) punktacji
        //jesli ktorys z buttonow zostanie wybrany - ruch wykonuje komputer

        //NORMALNIE:
        //pointCounter.rollTheDicePointCounter(user);

        //NA POTRZEBY TESTOW:
        //recznie wybranie buttona aktualizacujaego tabele o dana punktacje (i wyczyszczenie listy temporarypoints);
        pointCounter.acesAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 4;

        //RUCH KOMPUTERA
        //uaktualnienie listy mozliwych ruchow (computerTemporarList) komputera na podstawie ComuterPossibilites.
        //Jesli = true, ruch nie zostal wczesniej wybrany i jest dostępny do wyboru
        computerPointCounter.computerPossibleTurn(computer, user);

        //losowanie dostepnego ruchu z listy mozliwych ruchow, uzupelnienie punktow w HashMapie computerResult:
        computerPointCounter.computerTurn(computer, user);

        //computerTemporarList :  kopia listy - gdzie boolean = true. z niej bedzie losowanie punktacji do wyboru (random 1 - listSize)
        //po wylosowaniu pozycji z listy temporarlist -> nadanie punktacji do listy computerPointsList
        //koniec rundy komputera

        //wylosowanie jednego z elementow mapy temporarresult
        //po jego wylosowaniu - dodanie do mapy z wynikami
        //po jaego wylosowani - zmiana possibilites na false


        //[ROUND 2]
        //user.userThrow(diceList);
        dice1 = new Dice(2, false);
        dice2 = new Dice(2, false);
        dice3 = new Dice(2, false);
        dice4 = new Dice(6, false);
        dice5 = new Dice(4, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        //NA POTRZEBY TESTOW:
        //recznie wybranie buttona aktualizacujaego tabele o dana punktacje (i wyczyszczenie listy temporarypoints);
        pointCounter.twosAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 6;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);


        //[ROUND 3]
        dice1 = new Dice(3, false);
        dice2 = new Dice(3, false);
        dice3 = new Dice(5, false);
        dice4 = new Dice(1, false);
        dice5 = new Dice(3, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.threesAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 9;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 4]
        dice1 = new Dice(4, false);
        dice2 = new Dice(4, false);
        dice3 = new Dice(6, false);
        dice4 = new Dice(4, false);
        dice5 = new Dice(4, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.foursAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 16;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 5]
        dice1 = new Dice(1, false);
        dice2 = new Dice(2, false);
        dice3 = new Dice(3, false);
        dice4 = new Dice(5, false);
        dice5 = new Dice(5, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.fivesAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 10;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 6]
        dice1 = new Dice(6, false);
        dice2 = new Dice(6, false);
        dice3 = new Dice(3, false);
        dice4 = new Dice(6, false);
        dice5 = new Dice(6, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.sixesAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 24;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 7]
        dice1 = new Dice(6, false);
        dice2 = new Dice(6, false);
        dice3 = new Dice(2, false);
        dice4 = new Dice(4, false);
        dice5 = new Dice(6, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.threeOfaAKindAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 24;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 8]
        dice1 = new Dice(2, false);
        dice2 = new Dice(2, false);
        dice3 = new Dice(2, false);
        dice4 = new Dice(2, false);
        dice5 = new Dice(6, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.fourOfaAKindOfaAKindAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 14;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 9]
        dice1 = new Dice(1, false);
        dice2 = new Dice(6, false);
        dice3 = new Dice(1, false);
        dice4 = new Dice(2, false);
        dice5 = new Dice(4, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.smallStraightAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 0;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 10]
        dice1 = new Dice(5, false);
        dice2 = new Dice(2, false);
        dice3 = new Dice(3, false);
        dice4 = new Dice(4, false);
        dice5 = new Dice(6, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.largeStraightAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 40;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 11]
        dice1 = new Dice(5, false);
        dice2 = new Dice(5, false);
        dice3 = new Dice(3, false);
        dice4 = new Dice(3, false);
        dice5 = new Dice(3, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.fullHouseAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 25;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 12]
        dice1 = new Dice(5, false);
        dice2 = new Dice(5, false);
        dice3 = new Dice(5, false);
        dice4 = new Dice(5, false);
        dice5 = new Dice(5, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.fiveDiceAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 50;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //[ROUND 13]
        dice1 = new Dice(1, false);
        dice2 = new Dice(5, false);
        dice3 = new Dice(3, false);
        dice4 = new Dice(5, false);
        dice5 = new Dice(6, false);
        diceList.add(dice1);
        diceList.add(dice2);
        diceList.add(dice3);
        diceList.add(dice4);
        diceList.add(dice5);
        user.addDicesToList(diceList, dicesIntList);

        pointCounter.chanceAcceptanceButton(user);
        dicesIntList.clear();
        diceList.clear();
        //liczba punktow = 20;

        //RUCH KOMPUTERA
        computerPointCounter.computerPossibleTurn(computer, user);
        computerPointCounter.computerTurn(computer, user);

        //THEN
        Assert.assertEquals(277, pointCounter.getTotalScore(user));



    }


}