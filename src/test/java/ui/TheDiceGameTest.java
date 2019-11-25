package ui;

import game.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TheDiceGameTest {

    @Test
    public void diceGameScenario() {

        //GIVEN
        //tworzene mocka
        Random randomMock = mock(Random.class);
        User user = new User(randomMock);
        //Computer computer = new Computer(randomMock);
        PointCounter pointCounter = new PointCounter();
        //ComputerPointCounter computerPointCounter = new ComputerPointCounter();
        //wstrzykniecie mocka
        when(randomMock.nextInt(6)).thenReturn(0);


        //WHEN
        user.userThrow1();
        int userAcesResult = pointCounter.count(user.getDicesIntList(),new SingleDiceScore(1));//sprawdzic dlaczego nie przelicza
        int userAcesResult2 = user.sumofDices(user.getDiceList());
        //THEN
        Assert.assertEquals(5, userAcesResult);

        //a moze zrobic interfejs Score w ktorym kazda punktacja by zawierala wlasna metode obliczania punktow? (bylo by dodatkowo 13+ klas) -> tak

        //WHEN


        //[ROUND 1]:
//        //wyrzut 5 kosci:
//        ArrayList<Dice> diceList = new ArrayList<>();
//        diceList.add(new Dice(1,false));
//        diceList.add(new Dice(1,false));
//        diceList.add(new Dice(1,false));
//        diceList.add(new Dice(1,false));
//        diceList.add(new Dice(1,false));
//        when(listOfDices.getDiceList()).thenReturn(diceList);
//
//        ArrayList<Integer> dicesIntList = new ArrayList<>();

//        when(listOfDices.getDicesIntList()).thenReturn(dicesIntList);


/*

        when(randomMock.nextInt(6)).thenReturn(4);

        int computerResult = computer.countAces();
        int userAcesResult = pointCounter.count(dicesIntList,1);


        Assert.assertEquals(5, computerResult);


        //computerPointCounter.computerPossibleTurn(computer, user);
        //losowanie dostepnego ruchu z listy mozliwych ruchow, uzupelnienie punktow w HashMapie computerResult:
        //computerPointCounter.computerTurn(computer, user);
















        //dodanie wartosci kosci do listy kosci
        listOfDices.addDicesToList(diceList, dicesIntList);

        //wybranie pierwszych 3 kosci:
        user.selectDice(diceList.get(1));
        user.selectDice(diceList.get(2));
        user.selectDice(diceList.get(3));

        //cofniecie wybrania pierwszej kosci:
        user.unSelectDice(diceList.get(1));

        //drugi wyrzut:
        user.userSecondThrow(listOfDices.getDiceList());

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


*/

    }


}