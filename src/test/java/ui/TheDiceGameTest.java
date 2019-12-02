package ui;

import game.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TheDiceGameTest {

    @Test
    public void diceGameScenario() {
        Random randomComputerMock = mock(Random.class);
        RandomDicesProvider randomDicesProviderMock = mock(RandomDicesProvider.class);
        User user = new User(randomDicesProviderMock);
        PointCounter pointCounter = new PointCounter();
        ComputerPointCounter computerPointCounter = new ComputerPointCounter(randomComputerMock);

        pointCounter.initialize();
        computerPointCounter.initialize();

        //Given
        when(randomComputerMock.nextInt(5)).thenReturn(4);
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(1, false),
                new Dice(1, false),
                new Dice(1, false),
                new Dice(1, false),
                new Dice(1, false)
        ));
        when(randomDicesProviderMock.getSingle()).thenReturn(new Dice(2, false));
        when(computerPointCounter.drawSize()).thenReturn(0);
        //When
        user.userThrow1();
//        System.out.println("Dices to rethrow"+user.getDicesToRethrow());
//        System.out.println(user.getDiceList());
//        user.selectDice(user.getDiceList().get(0));
//        randomDicesProviderMock.getSingle();
//        System.out.println(user.getDiceList());
//        System.out.println("Dices to rethrow"+user.getDicesToRethrow());
//        user.selectDice(user.getDiceList().get(0));
//        System.out.println("Dices to rethrow"+user.getDicesToRethrow());
//        user.reThrow();
        computerPointCounter.computerTurn(user);
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.acesAcceptanceButton(user);

        int userAcesResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(1));
        int computerAcesResult = computerPointCounter.countAces();

        pointCounter.scoreTable(); //Displaying actual users points table (for test reasons)
        computerPointCounter.scoreTable(); //Displaying actual computer points table (for test reasons)

        //Then
        Assert.assertEquals(5, userAcesResult);
        Assert.assertEquals(5, computerAcesResult);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(2, false),
                new Dice(2, false),
                new Dice(2, false),
                new Dice(2, false),
                new Dice(2, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(1);

        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.twosAcceptanceButton(user);
        computerPointCounter.computerTurn(user);

        int userTwosResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(2));
        int computerTwosResult = computerPointCounter.countTwos();

        pointCounter.scoreTable();
        computerPointCounter.scoreTable();

        //Then
        Assert.assertEquals(10, userTwosResult);
        Assert.assertEquals(10, computerTwosResult);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(3, false),
                new Dice(3, false),
                new Dice(3, false),
                new Dice(3, false),
                new Dice(3, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(2);

        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.threesAcceptanceButton(user);
        computerPointCounter.computerTurn(user);
        int userThreesResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(3));
        int computerThreesResult = computerPointCounter.countThrees();
        pointCounter.scoreTable();
        computerPointCounter.scoreTable();
        //Then
        Assert.assertEquals(15, userThreesResult);
        Assert.assertEquals(15, computerThreesResult);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(4, false),
                new Dice(4, false),
                new Dice(4, false),
                new Dice(4, false),
                new Dice(4, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(3);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.foursAcceptanceButton(user);
        computerPointCounter.computerTurn(user);

        int userFoursResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(4));
        int computerFoursResult = computerPointCounter.countFours();
        pointCounter.scoreTable();
        computerPointCounter.scoreTable();

        //Then
        Assert.assertEquals(20, userFoursResult);
        Assert.assertEquals(20, computerFoursResult);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(5, false),
                new Dice(5, false),
                new Dice(5, false),
                new Dice(5, false),
                new Dice(5, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(4);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.fivesAcceptanceButton(user);
        computerPointCounter.computerTurn(user);
        int userFivesResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(5));
        int computerFivesResult = computerPointCounter.countFives();

        pointCounter.scoreTable();
        computerPointCounter.scoreTable();

        //Then
        Assert.assertEquals(25, userFivesResult);
        Assert.assertEquals(25, computerFivesResult);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(6, false),
                new Dice(6, false),
                new Dice(6, false),
                new Dice(6, false),
                new Dice(6, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(5);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.sixesAcceptanceButton(user);
        computerPointCounter.computerTurn(user);
        int userSixesResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(6));
        int computerSixesResult = computerPointCounter.countSixes();

        pointCounter.scoreTable();
        computerPointCounter.scoreTable();

        //Then
        Assert.assertEquals(30, userSixesResult);
        Assert.assertEquals(30, computerSixesResult);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(2, false),
                new Dice(6, false),
                new Dice(6, false),
                new Dice(1, false),
                new Dice(6, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(6);
        when(randomComputerMock.nextInt(6)).thenReturn(5);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.threeOfaAKindAcceptanceButton(user);
        computerPointCounter.computerTurn(user);
        int userThreeOfAKindResult = pointCounter.countThreeOfAKind(user.getDiceList());
        int computerThreeOfAKindResult = computerPointCounter.countThreeOfAKind();

        pointCounter.scoreTable();
        computerPointCounter.scoreTable();
/*
        System.out.println("computer "+computerPointCounter.getComputerResult());
        System.out.println("computer "+computerPointCounter.getComputerPossibilities());
        System.out.println("computer "+computerPointCounter.getComputerTemporarResult());*/

        //Then
        Assert.assertEquals(21, userThreeOfAKindResult);
        Assert.assertEquals(30, computerThreeOfAKindResult);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(6, false),
                new Dice(6, false),
                new Dice(6, false),
                new Dice(1, false),
                new Dice(6, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(7);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.fourOfaAKindOfaAKindAcceptanceButton(user);
        computerPointCounter.computerTurn(user);
        int userFourOfAKindResult = pointCounter.countFourOfAKind(user.getDiceList());
        int computerFourOfAKindResult = computerPointCounter.countFourOfAKind();

        pointCounter.scoreTable();
        computerPointCounter.scoreTable();

        //Then
        Assert.assertEquals(25, userFourOfAKindResult);
        Assert.assertEquals(30, computerFourOfAKindResult);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(6, false),
                new Dice(5, false),
                new Dice(5, false),
                new Dice(6, false),
                new Dice(6, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(8);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.fullHouseAcceptanceButton(user);
        computerPointCounter.computerTurn(user);
        int userFullHouse = pointCounter.countFullHouse(user.getDiceList());
        int computerFullHouse = computerPointCounter.countFullHouse();

        pointCounter.scoreTable();
        computerPointCounter.scoreTable();
        //Then
        Assert.assertEquals(25, userFullHouse);
        Assert.assertEquals(25, computerFullHouse);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(2, false),
                new Dice(5, false),
                new Dice(4, false),
                new Dice(3, false),
                new Dice(2, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(9);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.smallStraightAcceptanceButton(user);
        computerPointCounter.computerTurn(user);

        int userSmallStraightResult = pointCounter.countSmallStraight(user.getDiceList());
        int computerSmallStraight = computerPointCounter.countSmallStraight();
        pointCounter.scoreTable();
        computerPointCounter.scoreTable();
        //Then
        Assert.assertEquals(30, userSmallStraightResult);
        Assert.assertEquals(30, computerSmallStraight);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(6, false),
                new Dice(5, false),
                new Dice(4, false),
                new Dice(3, false),
                new Dice(2, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(10);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.largeStraightAcceptanceButton(user);
        computerPointCounter.computerTurn(user);
        int userLargeStraightResult = pointCounter.countLargeStraight(user.getDiceList());
        int computerLargeStraight = computerPointCounter.countLargeStraight();
        pointCounter.scoreTable();
        computerPointCounter.scoreTable();
        //Then
        Assert.assertEquals(40, userLargeStraightResult);
        Assert.assertEquals(40, computerLargeStraight);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(6, false),
                new Dice(6, false),
                new Dice(6, false),
                new Dice(6, false),
                new Dice(6, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(11);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.fiveDiceAcceptanceButton(user);
        computerPointCounter.computerTurn(user);
        int user5DiceResult = pointCounter.count5dice(user.getDiceList());
        int computer5Dice = computerPointCounter.count5Dice();
        pointCounter.scoreTable();
        computerPointCounter.scoreTable();
        //Then
        Assert.assertEquals(50, user5DiceResult);
        Assert.assertEquals(0, computer5Dice);


        //Given
        when(randomDicesProviderMock.get()).thenReturn(Arrays.asList(
                new Dice(1, false),
                new Dice(5, false),
                new Dice(4, false),
                new Dice(3, false),
                new Dice(2, false)
        ));
        when(computerPointCounter.drawSize()).thenReturn(12);
        //When
        user.userThrow1();
        pointCounter.rollTheDicePointCounter(user);//test temporary table
        pointCounter.temporaryScoreTable();//test temporary table
        pointCounter.chanceAcceptanceButton(user);
        computerPointCounter.computerTurn(user);
        int userChanceResult = pointCounter.countChance(user.getDiceList());
        int computerChance = computerPointCounter.countChance();
        int userTotalResult = pointCounter.totalScore(pointCounter.getUserResult());
        int computerTotalResult = computerPointCounter.totalScore(computerPointCounter.getComputerResult());
        pointCounter.scoreTable();
        computerPointCounter.scoreTable();
        computerPointCounter.computerPossibleTurn(user);

        //Then
        Assert.assertEquals(15, userChanceResult);
        Assert.assertEquals(30, computerChance);
        Assert.assertEquals(346, userTotalResult);
        Assert.assertEquals(325, computerTotalResult);
    }


}