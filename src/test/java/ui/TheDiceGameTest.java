package ui;

import game.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TheDiceGameTest {

    @Test
    public void diceGameScenario() {

        Random randomMock = mock(Random.class);
        Random randomComputerMock = mock(Random.class);
        User user = new User(randomMock);
        Computer computer = new Computer(randomComputerMock);
        PointCounter pointCounter = new PointCounter();
        //ComputerPointCounter computerPointCounter = new ComputerPointCounter();

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(0);
        when(randomComputerMock.nextInt(5)).thenReturn(4);
        //WHEN
        user.userThrow1();
        int userAcesResult = pointCounter.count(user.getDiceList(),new SingleDiceScore(1));
        int computerAcesResult = computer.countAces();
        //THEN
        Assert.assertEquals(5, userAcesResult);
        Assert.assertEquals(5, computerAcesResult);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(1);
        //WHEN
        user.userThrow1();
        int userTwosResult = pointCounter.count(user.getDiceList(),new SingleDiceScore(2));
        int computerTwosResult = computer.countTwos();
        //THEN
        Assert.assertEquals(10, userTwosResult);
        Assert.assertEquals(10, computerTwosResult);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(2);
        //WHEN
        user.userThrow1();
        int userThreesResult = pointCounter.count(user.getDiceList(),new SingleDiceScore(3));
        int computerThreesResult = computer.countThrees();
        //THEN
        Assert.assertEquals(15, userThreesResult);
        Assert.assertEquals(15, computerThreesResult);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(3);
        //WHEN
        user.userThrow1();
        int userFoursResult = pointCounter.count(user.getDiceList(),new SingleDiceScore(4));
        int computerFoursResult = computer.countFours();
        //THEN
        Assert.assertEquals(20, userFoursResult);
        Assert.assertEquals(20, computerFoursResult);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(4);
        //WHEN
        user.userThrow1();
        int userFivesResult = pointCounter.count(user.getDiceList(),new SingleDiceScore(5));
        int computerFivesResult = computer.countFives();
        //THEN
        Assert.assertEquals(25, userFivesResult);
        Assert.assertEquals(25, computerFivesResult);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(5);
        //WHEN
        user.userThrow1();
        int userSixesResult = pointCounter.count(user.getDiceList(),new SingleDiceScore(6));
        int computerSixesResult = computer.countSixes();
        //THEN
        Assert.assertEquals(30, userSixesResult);
        Assert.assertEquals(30, computerSixesResult);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(5);
        when(randomComputerMock.nextInt(6)).thenReturn(5);
        //WHEN
        user.userThrow1();
        int userThreeOfAKindResult = pointCounter.countThreeOfAKind(user.getDiceList());
        int computerThreeOfAKindResult = computer.countThreeOfAKind();
        //THEN
        Assert.assertEquals(30, userThreeOfAKindResult);
        Assert.assertEquals(30, computerThreeOfAKindResult);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(2);
        //WHEN
        user.userThrow1();
        int userFourOfAKindResult = pointCounter.countFourOfAKind(user.getDiceList());
        //THEN
        Assert.assertEquals(15, userFourOfAKindResult);

        //GIVEN
        user.getDiceList().clear();
        user.getDiceList().add(new Dice(3, false));
        user.getDiceList().add(new Dice(3, false));
        user.getDiceList().add(new Dice(2, false));
        user.getDiceList().add(new Dice(2, false));
        user.getDiceList().add(new Dice(2, false));
        //WHEN
        //user.userThrow1();
        int userFullHouse = pointCounter.countFullHouse(user.getDiceList());
        //THEN
        Assert.assertEquals(25, userFullHouse);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(0);
        //WHEN
        user.userThrow1();
        int userSmallStraightResult = pointCounter.countSmallStraight(user.getDiceList());
        //THEN
        Assert.assertEquals(0, userSmallStraightResult);


        //GIVEN
        user.getDiceList().clear();
        user.getDiceList().add(new Dice(2, false));
        user.getDiceList().add(new Dice(3, false));
        user.getDiceList().add(new Dice(4, false));
        user.getDiceList().add(new Dice(5, false));
        user.getDiceList().add(new Dice(6, false));
        //WHEN
        //user.userThrow1();
        int userLargeStraightResult = pointCounter.countLargeStraight(user.getDiceList());
        //THEN
        Assert.assertEquals(40, userLargeStraightResult);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(0);
        //WHEN
        user.userThrow1();
        int user5DiceResult = pointCounter.count5dice(user.getDiceList());
        //THEN
        Assert.assertEquals(50, user5DiceResult);

        //GIVEN
        when(randomMock.nextInt(6)).thenReturn(1);
        //WHEN
        user.userThrow1();
        int userChanceResult = pointCounter.countChance(user.getDiceList());
        //THEN
        Assert.assertEquals(10, userChanceResult);


        //Zrobic interfejs Score w ktorym kazda punktacja by zawierala wlasna metode obliczania punktow? (bylo by dodatkowo 13+ klas) -> tak


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