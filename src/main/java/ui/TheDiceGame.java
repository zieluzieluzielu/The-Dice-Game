package ui;

import game.PointCounter;
import game.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;


public class TheDiceGame extends Application {
    private final Random random = new Random();
    private final RandomDicesProvider randomDicesProvider = new RandomDicesProvider(random);
    private final User user = new User(randomDicesProvider);
    private final PointCounter pointCounter = new PointCounter();
    private final ComputerPointCounter computerPointCounter = new ComputerPointCounter(random);

    private int throwsLeft = 2;

    private Image imageBack = new Image("bckgrnd.jpg");
    private Image logo = new Image("theDiceLogo2.png");
    private Image won = new Image("won.png");
    private Image lost = new Image("lost.png");
    private Image draw = new Image("draw.png");
    private FlowPane gameResult = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane gameLogo = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane dices = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane dicesButtons = new FlowPane(Orientation.HORIZONTAL);

    private Label whatToDo = new Label();

    private Label endGame = new Label();
    private Label statusLabel = new Label();

    private Label roundNumber = new Label("Round Number:" + computerPointCounter.getRoundNr());

    private Label acesLabel = new Label("ACES");
    private Label userAces = new Label();
    private Label computerAces = new Label();
    private Label twosLabel = new Label("TWOS");
    private Label userTwos = new Label();
    private Label computerTwos = new Label();
    private Label threesLabel = new Label("THREES");
    private Label userThrees = new Label();
    private Label computerThrees = new Label();
    private Label foursLabel = new Label("FOURS");
    private Label userFours = new Label();
    private Label computerFours = new Label();
    private Label fivesLabel = new Label("FIVES");
    private Label userFives = new Label();
    private Label computerFives = new Label();
    private Label sixesLabel = new Label("SIXES");
    private Label userSixes = new Label();
    private Label computerSixes = new Label();
    private Label bonusLabel = new Label("BONUS");
    private Label userBonus = new Label();
    private Label computerBonus = new Label();
    private Label topScoreLabel = new Label("TOP SCORE");
    private Label userTopScore = new Label();
    private Label computerTopScore = new Label();

    private Label threeOfAKindLabel = new Label("3 OF A KIND");
    private Label userTreeOfAKind = new Label();
    private Label computerTreeOfAKind = new Label();
    private Label fourOfAKindLabel = new Label("4 OF A KIND");
    private Label userFourOfAKind = new Label();
    private Label computerFourOfAKind = new Label();
    private Label fullHouseLabel = new Label("FULL HOUSE");
    private Label userFullHouse = new Label();
    private Label computerFullHouse = new Label();
    private Label smallStreetLabel = new Label("SMALL STREET");
    private Label userSmallStreet = new Label();
    private Label computerSmallStreet = new Label();
    private Label largeStreetLabel = new Label("LARGE STREET");
    private Label userLargeStreet = new Label();
    private Label computerLargeStreet = new Label();
    private Label fiveDiceLabel = new Label("5 DICE");
    private Label user5Dice = new Label();
    private Label computer5Dice = new Label();
    private Label chanceLabel = new Label("CHANCE");
    private Label userChance = new Label();
    private Label computerChance = new Label();
    private Label bottomScoreLabel = new Label("BOTTOM SCORE");
    private Label userBottomScore = new Label();
    private Label computerBottomScore = new Label();
    private Label totalScoreLabel = new Label("TOTAL SCORE");
    private Label userTotalScore = new Label();
    private Label computerTotalScore = new Label();

    private Label userPoints = new Label("USER SCORE");
    private Label computerPoints = new Label("COMPUTER SCORE ");

    private void throwDices() {
        if (computerPointCounter.getRoundNr() < 14) {
            if (user.getDiceList().isEmpty()) {
                try {
                    user.userThrow1();
                    System.out.println(user.getDiceList());
                    ImageView diceOne = new ImageView(user.getDiceList().get(0).getDiceImage());
                    dices.getChildren().add(diceOne);
                    ImageView diceTwo = new ImageView(user.getDiceList().get(1).getDiceImage());
                    dices.getChildren().add(diceTwo);
                    ImageView diceThree = new ImageView(user.getDiceList().get(2).getDiceImage());
                    dices.getChildren().add(diceThree);
                    ImageView diceFour = new ImageView(user.getDiceList().get(3).getDiceImage());
                    dices.getChildren().add(diceFour);
                    ImageView diceFive = new ImageView(user.getDiceList().get(4).getDiceImage());
                    dices.getChildren().add(diceFive);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.print("Dices were already thrown");
            }
        } else {
            endGame.setText("The game has finished");
        }
    }

    private void clearDices() {
        dices.getChildren().removeAll(dices.getChildren());
    }

    private void reThrowDices() {
        if (computerPointCounter.getRoundNr() < 14)
            if (!user.getDiceList().isEmpty() && !user.getDicesToRethrow().isEmpty()) {
                try {
                    System.out.println("dice list: " + user.getDiceList());
                    throwsLeft--;
                    user.reThrow();
                    System.out.println("dice list: " + user.getDiceList());
                    ImageView diceOne = new ImageView(user.getDiceList().get(0).getDiceImage());
                    dices.getChildren().add(diceOne);
                    ImageView diceTwo = new ImageView(user.getDiceList().get(1).getDiceImage());
                    dices.getChildren().add(diceTwo);
                    ImageView diceThree = new ImageView(user.getDiceList().get(2).getDiceImage());
                    dices.getChildren().add(diceThree);
                    ImageView diceFour = new ImageView(user.getDiceList().get(3).getDiceImage());
                    dices.getChildren().add(diceFour);
                    ImageView diceFive = new ImageView(user.getDiceList().get(4).getDiceImage());
                    dices.getChildren().add(diceFive);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                statusLabel.setText("Please throw the dices first");
                System.out.print("Please throw the dices first");
            }
    }

    private void newRound() {
        statusLabel.setText("");
        computerTurn();
        roundNumber.setText("Round Number:" + computerPointCounter.getRoundNr());
        whatToDo.setText("");
        dices.getChildren().removeAll(dices.getChildren());
        user.getDiceList().clear();
        gameWinner();
    }

    private void gameWinner() {
        if (computerPointCounter.getRoundNr() == 14) {

            dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
            roundNumber.setText("");
            if (computerPointCounter.totalScore(computerPointCounter.getComputerResult()) > pointCounter.totalScore(pointCounter.getUserResult())) {
                ImageView gameLost = new ImageView(lost);
                gameResult.getChildren().add(gameLost);
            } else if (computerPointCounter.totalScore(computerPointCounter.getComputerResult()) < pointCounter.totalScore(pointCounter.getUserResult())) {
                ImageView gameWon = new ImageView(won);
                gameResult.getChildren().add(gameWon);
            } else {
                ImageView gameDraw = new ImageView(draw);
                gameResult.getChildren().add(gameDraw);
            }
        }
    }

    private void computerTurn() {
        computerPointCounter.computerPossibleTurn(user);
        computerPointCounter.computerTurn(user);
        System.out.println("Computer points: " + computerPointCounter.getComputerResult());
        computerAces.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getAces())));
        computerTwos.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getTwos())));
        computerThrees.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getThrees())));
        computerFours.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getFours())));
        computerFives.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getFives())));
        computerSixes.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getSixes())));
        computerTopScore.setText(String.valueOf(computerPointCounter.topScore(computerPointCounter.getComputerResult())));
        computerBonus.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getBonusPoints())));
        computerTreeOfAKind.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getThreeOfaAKind())));
        computerFourOfAKind.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getFourOfaAKind())));
        computerFullHouse.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getFullHouse())));
        computerSmallStreet.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getSmallStraight())));
        computerLargeStreet.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getLargeStraight())));
        computer5Dice.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getFiveDice())));
        computerChance.setText(String.valueOf(computerPointCounter.getComputerResult().get(computerPointCounter.getChance())));
        computerBottomScore.setText(String.valueOf(computerPointCounter.bottomScore(computerPointCounter.getComputerResult())));
        computerTotalScore.setText(String.valueOf(computerPointCounter.totalScore(computerPointCounter.getComputerResult())));

    }

    private void fillUserTable() {
        userAces.setText(String.valueOf(pointCounter.tableResult(pointCounter.getAces())));
        userTwos.setText(String.valueOf(pointCounter.tableResult(pointCounter.getTwos())));
        userThrees.setText(String.valueOf(pointCounter.tableResult(pointCounter.getThrees())));
        userFours.setText(String.valueOf(pointCounter.tableResult(pointCounter.getFours())));
        userFives.setText(String.valueOf(pointCounter.tableResult(pointCounter.getFives())));
        userSixes.setText(String.valueOf(pointCounter.tableResult(pointCounter.getSixes())));
        userTreeOfAKind.setText(String.valueOf(pointCounter.tableResult(pointCounter.getThreeOfaAKind())));
        userFourOfAKind.setText(String.valueOf(pointCounter.tableResult(pointCounter.getFourOfaAKind())));
        userFullHouse.setText(String.valueOf(pointCounter.tableResult(pointCounter.getFullHouse())));
        userSmallStreet.setText(String.valueOf(pointCounter.tableResult(pointCounter.getSmallStraight())));
        userLargeStreet.setText(String.valueOf(pointCounter.tableResult(pointCounter.getLargeStraight())));
        user5Dice.setText(String.valueOf(pointCounter.tableResult(pointCounter.getFiveDice())));
        userChance.setText(String.valueOf(pointCounter.tableResult(pointCounter.getChance())));
    }

    private void countTotalUsersScores() {
        pointCounter.bonusCounter();
        userTopScore.setText(String.valueOf(pointCounter.topScore(pointCounter.getUserResult())));
        userBottomScore.setText(String.valueOf(pointCounter.bottomScore(pointCounter.getUserResult())));
        userBonus.setText(String.valueOf(pointCounter.getUserResult().get(pointCounter.getBonusPoints())));
        userTotalScore.setText(String.valueOf(pointCounter.totalScore(pointCounter.getUserResult())));
    }

    private void buttonAction(Button button, Integer index) {
        if (!user.getDiceList().isEmpty()) {
            if (throwsLeft > 0) {
                if (!user.getDiceList().get(index).getSelected()) {
                    user.selectDice(user.getDiceList().get(index));
                    System.out.println(user.getDiceList().get(index));
                    System.out.println("dices to rethrow " + user.getDicesToRethrow());
                    button.getStyleClass().add("buttonSelected");
                    System.out.println("dice list: " + user.getDiceList());
                } else {
                    button.getStyleClass().remove("buttonSelected");
                    user.unSelectDice(user.getDiceList().get(index));
                    user.afterUnselectingDice();
                    System.out.println(user.getDiceList().get(index));
                    System.out.println("dices to rethrow " + user.getDicesToRethrow());
                    System.out.println("dice list: " + user.getDiceList());
                }
            } else {
                statusLabel.setText("You can't select any dice (" + throwsLeft + " throws left). Please choose your score.");
            }
        } else {
            statusLabel.setText("Please throw the dices first.");

        }
    }


    @Override
    public void start(Stage primaryStage) {

        statusLabel.getStyleClass().add("whiteStatusText");
        statusLabel.setAlignment(Pos.CENTER);
        whatToDo.getStyleClass().add("whiteStatusText");
        whatToDo.setAlignment(Pos.CENTER);
        endGame.getStyleClass().add("whiteText");
        roundNumber.getStyleClass().add("smallWhiteText");
        acesLabel.getStyleClass().add("whiteText");
        userAces.getStyleClass().add("whiteText");
        computerAces.getStyleClass().add("whiteText");
        twosLabel.getStyleClass().add("whiteText");
        userTwos.getStyleClass().add("whiteText");
        computerTwos.getStyleClass().add("whiteText");
        threesLabel.getStyleClass().add("whiteText");
        userThrees.getStyleClass().add("whiteText");
        computerThrees.getStyleClass().add("whiteText");
        foursLabel.getStyleClass().add("whiteText");
        userFours.getStyleClass().add("whiteText");
        computerFours.getStyleClass().add("whiteText");
        fivesLabel.getStyleClass().add("whiteText");
        userFives.getStyleClass().add("whiteText");
        computerFives.getStyleClass().add("whiteText");
        sixesLabel.getStyleClass().add("whiteText");
        userSixes.getStyleClass().add("whiteText");
        computerSixes.getStyleClass().add("whiteText");
        bonusLabel.getStyleClass().add("yellowText");
        userBonus.getStyleClass().add("yellowText");
        computerBonus.getStyleClass().add("yellowText");
        topScoreLabel.getStyleClass().add("yellowText");
        userTopScore.getStyleClass().add("yellowText");
        computerTopScore.getStyleClass().add("yellowText");
        threeOfAKindLabel.getStyleClass().add("whiteText");
        userTreeOfAKind.getStyleClass().add("whiteText");
        computerTreeOfAKind.getStyleClass().add("whiteText");
        fourOfAKindLabel.getStyleClass().add("whiteText");
        userFourOfAKind.getStyleClass().add("whiteText");
        computerFourOfAKind.getStyleClass().add("whiteText");
        fullHouseLabel.getStyleClass().add("whiteText");
        userFullHouse.getStyleClass().add("whiteText");
        computerFullHouse.getStyleClass().add("whiteText");
        smallStreetLabel.getStyleClass().add("whiteText");
        userSmallStreet.getStyleClass().add("whiteText");
        computerSmallStreet.getStyleClass().add("whiteText");
        largeStreetLabel.getStyleClass().add("whiteText");
        userLargeStreet.getStyleClass().add("whiteText");
        computerLargeStreet.getStyleClass().add("whiteText");
        fiveDiceLabel.getStyleClass().add("whiteText");
        user5Dice.getStyleClass().add("whiteText");
        computer5Dice.getStyleClass().add("whiteText");
        chanceLabel.getStyleClass().add("whiteText");
        userChance.getStyleClass().add("whiteText");
        computerChance.getStyleClass().add("whiteText");
        bottomScoreLabel.getStyleClass().add("yellowText");
        userBottomScore.getStyleClass().add("yellowText");
        computerBottomScore.getStyleClass().add("yellowText");
        totalScoreLabel.getStyleClass().add("yellowText");
        userTotalScore.getStyleClass().add("yellowText");
        computerTotalScore.getStyleClass().add("yellowText");
        userPoints.getStyleClass().add("whiteBoldText");
        computerPoints.getStyleClass().add("whiteBoldText");

        BackgroundSize backgroundSize = new BackgroundSize(1600, 900, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setBackground(background);

        ImageView diceLogo = new ImageView(logo);
        gameLogo.getChildren().add(diceLogo);
        grid.add(gameLogo, 30, 2, 3, 1);
        grid.add(gameResult, 25, 10, 18, 10);
        grid.add(statusLabel, 8, 5, 27, 35);
        GridPane.setHalignment(statusLabel, HPos.CENTER);

        grid.add(whatToDo, 8, 2, 27, 35);
        GridPane.setHalignment(whatToDo, HPos.CENTER);
        grid.add(endGame, 40, 10, 3, 1);

        grid.add(roundNumber, 3, 20, 1, 1);

        grid.add(dices, 7, 10, 35, 35);

        grid.add(userPoints, 60, 3, 3, 1);
        grid.add(computerPoints, 67, 3, 3, 1);

        grid.add(acesLabel, 55, 4, 2, 1);
        grid.add(userAces, 60, 4, 2, 1);
        grid.add(computerAces, 67, 4, 2, 1);

        grid.add(twosLabel, 55, 5, 2, 1);
        grid.add(userTwos, 60, 5, 2, 1);
        grid.add(computerTwos, 67, 5, 2, 1);

        grid.add(threesLabel, 55, 6, 2, 1);
        grid.add(userThrees, 60, 6, 2, 1);
        grid.add(computerThrees, 67, 6, 2, 1);

        grid.add(foursLabel, 55, 7, 2, 1);
        grid.add(userFours, 60, 7, 2, 1);
        grid.add(computerFours, 67, 7, 2, 1);

        grid.add(fivesLabel, 55, 8, 2, 1);
        grid.add(userFives, 60, 8, 2, 1);
        grid.add(computerFives, 67, 8, 2, 1);

        grid.add(sixesLabel, 55, 9, 2, 1);
        grid.add(userSixes, 60, 9, 2, 1);
        grid.add(computerSixes, 67, 9, 2, 1);

        grid.add(topScoreLabel, 55, 10, 2, 1);
        grid.add(userTopScore, 60, 10, 2, 1);
        grid.add(computerTopScore, 67, 10, 2, 1);

        grid.add(bonusLabel, 55, 11, 2, 1);
        grid.add(userBonus, 60, 11, 2, 1);
        grid.add(computerBonus, 67, 11, 2, 1);

        grid.add(threeOfAKindLabel, 55, 12, 2, 1);
        grid.add(userTreeOfAKind, 60, 12, 2, 1);
        grid.add(computerTreeOfAKind, 67, 12, 2, 1);

        grid.add(fourOfAKindLabel, 55, 13, 2, 1);
        grid.add(userFourOfAKind, 60, 13, 2, 1);
        grid.add(computerFourOfAKind, 67, 13, 2, 1);

        grid.add(fullHouseLabel, 55, 14, 2, 1);
        grid.add(userFullHouse, 60, 14, 2, 1);
        grid.add(computerFullHouse, 67, 14, 2, 1);

        grid.add(smallStreetLabel, 55, 15, 2, 1);
        grid.add(userSmallStreet, 60, 15, 2, 1);
        grid.add(computerSmallStreet, 67, 15, 2, 1);

        grid.add(largeStreetLabel, 55, 16, 2, 1);
        grid.add(userLargeStreet, 60, 16, 2, 1);
        grid.add(computerLargeStreet, 67, 16, 2, 1);

        grid.add(fiveDiceLabel, 55, 17, 2, 1);
        grid.add(user5Dice, 60, 17, 2, 1);
        grid.add(computer5Dice, 67, 17, 2, 1);

        grid.add(chanceLabel, 55, 18, 2, 1);
        grid.add(userChance, 60, 18, 2, 1);
        grid.add(computerChance, 67, 18, 2, 1);

        grid.add(bottomScoreLabel, 55, 19, 2, 1);
        grid.add(userBottomScore, 60, 19, 2, 1);
        grid.add(computerBottomScore, 67, 19, 2, 1);

        grid.add(totalScoreLabel, 55, 20, 2, 1);
        grid.add(userTotalScore, 60, 20, 2, 1);
        grid.add(computerTotalScore, 67, 20, 2, 1);

        Button selectDice1 = new Button();
        selectDice1.setText("dice1");
        selectDice1.getStyleClass().add("button1");
        selectDice1.setOnAction((e) -> buttonAction(selectDice1, 0));

        Button selectDice2 = new Button();
        selectDice2.setText("dice2");
        selectDice2.getStyleClass().add("button1");
        selectDice2.setOnAction((e) -> buttonAction(selectDice2, 1));

        Button selectDice3 = new Button();
        selectDice3.setText("dice3");
        selectDice3.getStyleClass().add("button1");
        selectDice3.setOnAction((e) -> buttonAction(selectDice3, 2));

        Button selectDice4 = new Button();
        selectDice4.setText("dice4");
        selectDice4.getStyleClass().add("button1");
        selectDice4.setOnAction((e) -> buttonAction(selectDice4, 3));

        Button selectDice5 = new Button();
        selectDice5.setText("dice5");
        selectDice5.getStyleClass().add("button1");
        selectDice5.setOnAction((e) -> buttonAction(selectDice5, 4));

        Button reThrow = new Button();
        reThrow.setText("RE-THROW (" + throwsLeft + ")");
        reThrow.getStyleClass().add("button2");
        reThrow.setOnAction((e) -> {
            if (!dices.getChildren().isEmpty()) {
                if (throwsLeft > 0) {
                    statusLabel.setText("");
                    if (!user.getDicesToRethrow().isEmpty()) {
                        selectDice1.getStyleClass().remove("buttonSelected");
                        selectDice2.getStyleClass().remove("buttonSelected");
                        selectDice3.getStyleClass().remove("buttonSelected");
                        selectDice4.getStyleClass().remove("buttonSelected");
                        selectDice5.getStyleClass().remove("buttonSelected");
                        System.out.println("to rethrow " + user.getDicesToRethrow());
                        clearDices();
                        reThrowDices();
                        reThrow.setText("RE-THROW (" + throwsLeft + ")");
                        pointCounter.pointsBeforeUserAcceptance(user);
                        fillUserTable();
                        System.out.println("to rethrow after throw" + user.getDicesToRethrow());
                        if (throwsLeft == 0) {
                            whatToDo.setText("");
                        }
                    } else {
                        System.out.println("Please select any dice first!");
                        statusLabel.setText("Please select any dice first!");
                    }
                } else {
                    System.out.println("3 throws already done");
                    statusLabel.setText("3 throws already done");
                }
            } else {
                System.out.println("Please throw the dices first!");
                statusLabel.setText("Please throw the dices first!");

            }
        });

        Button newThrow = new Button();
        newThrow.setText("NEW THROW");
        newThrow.getStyleClass().add("button2");
        newThrow.setOnAction((e) -> {
            if (user.getDiceList().isEmpty() && computerPointCounter.getRoundNr() < 14) {
                whatToDo.setText("Please select the dices that you want to re-throw");

                selectDice1.getStyleClass().remove("buttonSelected");
                selectDice2.getStyleClass().remove("buttonSelected");
                selectDice3.getStyleClass().remove("buttonSelected");
                selectDice4.getStyleClass().remove("buttonSelected");
                selectDice5.getStyleClass().remove("buttonSelected");
                dicesButtons.getChildren().add(selectDice1);
                dicesButtons.getChildren().add(selectDice2);
                dicesButtons.getChildren().add(selectDice3);
                dicesButtons.getChildren().add(selectDice4);
                dicesButtons.getChildren().add(selectDice5);
                statusLabel.setText("");
                throwDices();
                pointCounter.pointsBeforeUserAcceptance(user);
                fillUserTable();
                throwsLeft = 2;
                reThrow.setText("RE-THROW (" + throwsLeft + ")");
                grid.add(reThrow, 33, 19, 1, 1);
            } else if (!user.getDiceList().isEmpty()) {
                System.out.println("Dices were already thrown. Plese re-throw if possible, otherwise select the score");
                statusLabel.setText("Dices were already thrown. Plese re-throw if possible, otherwise select the score!");
            } else {
                newThrow.setText("NEW THROW IS NOT AVAILABLE");
                System.out.println("The game has finished");
                statusLabel.setText("The game has finished");
            }
        });


        Button acesAccept = new Button();
        acesAccept.setText("✔");
        acesAccept.getStyleClass().add("button1");
        acesAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getAces())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.acesAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(acesAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }

                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button twosAccept = new Button();
        twosAccept.setText("✔");
        twosAccept.getStyleClass().add("button1");
        twosAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getTwos())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.twosAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(twosAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button threesAccept = new Button();
        threesAccept.setText("✔");
        threesAccept.getStyleClass().add("button1");
        threesAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getThrees())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.threesAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(threesAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button foursAccept = new Button();
        foursAccept.setText("✔");
        foursAccept.getStyleClass().add("button1");
        foursAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getFours())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.foursAcceptance(user);
                    grid.getChildren().remove(reThrow);
                    countTotalUsersScores();
                    grid.getChildren().remove(foursAccept);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button fivesAccept = new Button();
        fivesAccept.setText("✔");
        fivesAccept.getStyleClass().add("button1");
        fivesAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getFives())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.fivesAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(fivesAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button sixesAccept = new Button();
        sixesAccept.setText("✔");
        sixesAccept.getStyleClass().add("button1");
        sixesAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getSixes())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.sixesAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(sixesAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button threeOfAKindAccept = new Button();
        threeOfAKindAccept.setText("✔");
        threeOfAKindAccept.getStyleClass().add("button1");
        threeOfAKindAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getThreeOfaAKind())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.threeOfaAKindAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(threeOfAKindAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button fourOfAKindAccept = new Button();
        fourOfAKindAccept.setText("✔");
        fourOfAKindAccept.getStyleClass().add("button1");
        fourOfAKindAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getFourOfaAKind())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.fourOfaAKindOfaAKindAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(fourOfAKindAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button fullHouseAccept = new Button();
        fullHouseAccept.setText("✔");
        fullHouseAccept.getStyleClass().add("button1");
        fullHouseAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getFullHouse())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.fullHouseAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(fullHouseAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button smallStreetAccept = new Button();
        smallStreetAccept.setText("✔");
        smallStreetAccept.getStyleClass().add("button1");
        smallStreetAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getSmallStraight())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.smallStraightAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(smallStreetAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button largeStreetAccept = new Button();
        largeStreetAccept.setText("✔");
        largeStreetAccept.getStyleClass().add("button1");
        largeStreetAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getLargeStraight())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.largeStraightAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(largeStreetAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button fiveDiceAccept = new Button();
        fiveDiceAccept.setText("✔");
        fiveDiceAccept.getStyleClass().add("button1");
        fiveDiceAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getFiveDice())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.fiveDiceAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(fiveDiceAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });

        Button chanceAccept = new Button();
        chanceAccept.setText("✔");
        chanceAccept.getStyleClass().add("button1");
        chanceAccept.setOnAction((e) -> {
            if (!user.getDiceList().isEmpty()) {
                if (pointCounter.getUserPossibilities().get(pointCounter.getChance())) {
                    dicesButtons.getChildren().removeAll(dicesButtons.getChildren());
                    pointCounter.chanceAcceptance(user);
                    countTotalUsersScores();
                    grid.getChildren().remove(chanceAccept);
                    grid.getChildren().remove(reThrow);
                    if (computerPointCounter.getRoundNr() >= 13) {
                        grid.getChildren().remove(newThrow);
                    }
                    newRound();
                } else {
                    System.out.println("already selected");
                }
            } else {

                statusLabel.setText("Please throw the dices first");
            }
        });
        dicesButtons.setHgap(74);
        grid.add(dicesButtons, 10, 14, 35, 35);
        GridPane.setHalignment(dicesButtons, HPos.CENTER);
        grid.add(newThrow, 30, 19, 3, 1);
        grid.add(acesAccept, 62, 4, 1, 1);
        grid.add(twosAccept, 62, 5, 1, 1);
        grid.add(threesAccept, 62, 6, 1, 1);
        grid.add(foursAccept, 62, 7, 1, 1);
        grid.add(fivesAccept, 62, 8, 1, 1);
        grid.add(sixesAccept, 62, 9, 1, 1);
        grid.add(threeOfAKindAccept, 62, 12, 1, 1);
        grid.add(fourOfAKindAccept, 62, 13, 1, 1);
        grid.add(fullHouseAccept, 62, 14, 1, 1);
        grid.add(smallStreetAccept, 62, 15, 1, 1);
        grid.add(largeStreetAccept, 62, 16, 1, 1);
        grid.add(fiveDiceAccept, 62, 17, 1, 1);
        grid.add(chanceAccept, 62, 18, 1, 1);

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        scene.getStylesheets().add("class.css");

        primaryStage.setTitle("The Dice Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
