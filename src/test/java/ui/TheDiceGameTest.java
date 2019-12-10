package ui;

import game.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TheDiceGameTest {
    private  void scoreTable(PointCounter pointCounter) {
        pointCounter.bonusCounter();
        System.out.println("USER SCORE:");
        System.out.println("Aces: " + pointCounter.getUserResult().get(pointCounter.getAces()));
        System.out.println("Twos: " + pointCounter.getUserResult().get(pointCounter.getTwos()));
        System.out.println("Threes: " + pointCounter.getUserResult().get(pointCounter.getThrees()));
        System.out.println("Fours: " + pointCounter.getUserResult().get(pointCounter.getFours()));
        System.out.println("Fives: " + pointCounter.getUserResult().get(pointCounter.getFives()));
        System.out.println("Sixes: " + pointCounter.getUserResult().get(pointCounter.getSixes()));
        System.out.println("Top score: " + pointCounter.topScore(pointCounter.getUserResult()));
        System.out.println("Bonus: " + pointCounter.getUserResult().get(pointCounter.getBonusPoints()));
        System.out.println("");

        System.out.println("Three Of A Kind: " + pointCounter.getUserResult().get(pointCounter.getThreeOfaAKind()));
        System.out.println("Four Of A Kind: " + pointCounter.getUserResult().get(pointCounter.getFourOfaAKind()));
        System.out.println("Full House: " + pointCounter.getUserResult().get(pointCounter.getFullHouse()));
        System.out.println("Small Straight: " + pointCounter.getUserResult().get(pointCounter.getSmallStraight()));
        System.out.println("Large Straight: " + pointCounter.getUserResult().get(pointCounter.getLargeStraight()));
        System.out.println("Chance: " + pointCounter.getUserResult().get(pointCounter.getChance()));
        System.out.println("5 dice: " + pointCounter.getUserResult().get(pointCounter.getFiveDice()));

        System.out.println("Bottom score: " + pointCounter.bottomScore(pointCounter.getUserResult()));
        System.out.println("Total score: " + pointCounter.totalScore(pointCounter.getUserResult()));
        System.out.println("\n");
    }

    private  void temporaryScoreTable(PointCounter pointCounter) {
        System.out.println("TEMPORARY USER SCORE (user possibilities):");
        if (pointCounter.getUserTemporarResult().get(pointCounter.getAces()) != 0) {
            System.out.println("Aces: " + pointCounter.getUserTemporarResult().get(pointCounter.getAces()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getTwos()) != 0) {
            System.out.println("Twos: " + pointCounter.getUserTemporarResult().get(pointCounter.getTwos()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getThrees()) != 0) {
            System.out.println("Threes: " + pointCounter.getUserTemporarResult().get(pointCounter.getThrees()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getFours()) != 0) {
            System.out.println("Fours: " + pointCounter.getUserTemporarResult().get(pointCounter.getFours()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getFives()) != 0) {
            System.out.println("Fives: " + pointCounter.getUserTemporarResult().get(pointCounter.getFives()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getSixes()) != 0) {
            System.out.println("Sixes: " + pointCounter.getUserTemporarResult().get(pointCounter.getSixes()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getBonusPoints()) != 0) {
            System.out.println("Bonus: " + pointCounter.getUserTemporarResult().get(pointCounter.getBonusPoints()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getThreeOfaAKind()) != 0) {

            System.out.println("Three Of A Kind: " + pointCounter.getUserTemporarResult().get(pointCounter.getThreeOfaAKind()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getFourOfaAKind()) != 0) {
            System.out.println("Four Of A Kind: " + pointCounter.getUserTemporarResult().get(pointCounter.getFourOfaAKind()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getFullHouse()) != 0) {
            System.out.println("Full House: " + pointCounter.getUserTemporarResult().get(pointCounter.getFullHouse()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getSmallStraight()) != 0) {
            System.out.println("Small Straight: " + pointCounter.getUserTemporarResult().get(pointCounter.getSmallStraight()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getLargeStraight()) != 0) {
            System.out.println("Large Straight: " + pointCounter.getUserTemporarResult().get(pointCounter.getLargeStraight()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getChance()) != 0) {
            System.out.println("Chance: " + pointCounter.getUserTemporarResult().get(pointCounter.getChance()));
        }

        if (pointCounter.getUserTemporarResult().get(pointCounter.getFiveDice()) != 0) {
            System.out.println("5 dice: " + pointCounter.getUserTemporarResult().get(pointCounter.getFiveDice()));
        }


        System.out.println("\n");
    }

    private  void computerScoreTable(ComputerPointCounter computerPointCounter) {
        System.out.println("COMPUTER SCORE:");
        System.out.println("Aces: " + computerPointCounter.getComputerResult().get(computerPointCounter.getAces()));
        System.out.println("Twos: " + computerPointCounter.getComputerResult().get(computerPointCounter.getTwos()));
        System.out.println("Threes: " + computerPointCounter.getComputerResult().get(computerPointCounter.getThrees()));
        System.out.println("Fours: " + computerPointCounter.getComputerResult().get(computerPointCounter.getFours()));
        System.out.println("Fives: " + computerPointCounter.getComputerResult().get(computerPointCounter.getFives()));
        System.out.println("Sixes: " + computerPointCounter.getComputerResult().get(computerPointCounter.getSixes()));
        System.out.println("Top score: " + computerPointCounter.topScore(computerPointCounter.getComputerResult()));
        System.out.println("Bonus: " + computerPointCounter.getComputerResult().get(computerPointCounter.getBonusPoints()));
        System.out.println("");

        System.out.println("Three Of A Kind: " + computerPointCounter.getComputerResult().get(computerPointCounter.getThreeOfaAKind()));
        System.out.println("Four Of A Kind: " + computerPointCounter.getComputerResult().get(computerPointCounter.getFourOfaAKind()));
        System.out.println("Full House: " + computerPointCounter.getComputerResult().get(computerPointCounter.getFullHouse()));
        System.out.println("Small Straight: " + computerPointCounter.getComputerResult().get(computerPointCounter.getSmallStraight()));
        System.out.println("Large Straight: " + computerPointCounter.getComputerResult().get(computerPointCounter.getLargeStraight()));
        System.out.println("Chance: " + computerPointCounter.getComputerResult().get(computerPointCounter.getChance()));
        System.out.println("5 dice: " + computerPointCounter.getComputerResult().get(computerPointCounter.getFiveDice()));

        System.out.println("Bottom score: " + computerPointCounter.bottomScore(computerPointCounter.getComputerResult()));
        System.out.println("Total score: " + computerPointCounter.totalScore(computerPointCounter.getComputerResult()));
        System.out.println("\n");
    }
    
    @Test
    public void diceGameScenario() {
        Random randomComputerMock = mock(Random.class);
        RandomDicesProvider randomDicesProviderMock = mock(RandomDicesProvider.class);
        User user = new User(randomDicesProviderMock);
        PointCounter pointCounter = new PointCounter();
        ComputerPointCounter computerPointCounter = new ComputerPointCounter(randomComputerMock);

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
        computerPointCounter.computerTurn(user);
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.acesAcceptance(user);

        int userAcesResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(1));
        int computerAcesResult = computerPointCounter.countAces();
        
        

        scoreTable(pointCounter); //Displaying actual users points table (for test reasons)
        computerScoreTable(computerPointCounter); //Displaying actual computer points table (for test reasons)

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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.twosAcceptance(user);
        computerPointCounter.computerTurn(user);

        int userTwosResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(2));
        int computerTwosResult = computerPointCounter.countTwos();

        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);

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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.threesAcceptance(user);
        computerPointCounter.computerTurn(user);
        int userThreesResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(3));
        int computerThreesResult = computerPointCounter.countThrees();
        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);
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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.foursAcceptance(user);
        computerPointCounter.computerTurn(user);

        int userFoursResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(4));
        int computerFoursResult = computerPointCounter.countFours();
        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);

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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.fivesAcceptance(user);
        computerPointCounter.computerTurn(user);
        int userFivesResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(5));
        int computerFivesResult = computerPointCounter.countFives();

        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);

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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.sixesAcceptance(user);
        computerPointCounter.computerTurn(user);
        int userSixesResult = pointCounter.count(user.getDiceList(), new SingleDiceScore(6));
        int computerSixesResult = computerPointCounter.countSixes();

        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);

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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.threeOfaAKindAcceptance(user);
        computerPointCounter.computerTurn(user);
        int userThreeOfAKindResult = pointCounter.countThreeOfAKind(user.getDiceList());
        int computerThreeOfAKindResult = computerPointCounter.countThreeOfAKind();

        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);
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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.fourOfaAKindOfaAKindAcceptance(user);
        computerPointCounter.computerTurn(user);
        int userFourOfAKindResult = pointCounter.countFourOfAKind(user.getDiceList());
        int computerFourOfAKindResult = computerPointCounter.countFourOfAKind();

        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);

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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.fullHouseAcceptance(user);
        computerPointCounter.computerTurn(user);
        int userFullHouse = pointCounter.countFullHouse(user.getDiceList());
        int computerFullHouse = computerPointCounter.countFullHouse();

        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);
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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.smallStraightAcceptance(user);
        computerPointCounter.computerTurn(user);

        int userSmallStraightResult = pointCounter.countSmallStraight(user.getDiceList());
        int computerSmallStraight = computerPointCounter.countSmallStraight();
        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);
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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.largeStraightAcceptance(user);
        computerPointCounter.computerTurn(user);
        int userLargeStraightResult = pointCounter.countLargeStraight(user.getDiceList());
        int computerLargeStraight = computerPointCounter.countLargeStraight();
        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);
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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.fiveDiceAcceptance(user);
        computerPointCounter.computerTurn(user);
        int user5DiceResult = pointCounter.count5dice(user.getDiceList());
        int computer5Dice = computerPointCounter.count5Dice();
        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);
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
        pointCounter.pointsBeforeUserAcceptance(user);//test temporary table
        temporaryScoreTable(pointCounter);//test temporary table
        pointCounter.chanceAcceptance(user);
        computerPointCounter.computerTurn(user);
        int userChanceResult = pointCounter.countChance(user.getDiceList());
        int computerChance = computerPointCounter.countChance();
        int userTotalResult = pointCounter.totalScore(pointCounter.getUserResult());
        int computerTotalResult = computerPointCounter.totalScore(computerPointCounter.getComputerResult());
        scoreTable(pointCounter);
        computerScoreTable(computerPointCounter);
        computerPointCounter.computerPossibleTurn(user);

        //Then
        Assert.assertEquals(15, userChanceResult);
        Assert.assertEquals(30, computerChance);
        Assert.assertEquals(346, userTotalResult);
        Assert.assertEquals(325, computerTotalResult);
    }


}