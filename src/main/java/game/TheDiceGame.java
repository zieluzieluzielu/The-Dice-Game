package game;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;


public class TheDiceGame extends Application {

    private Image imageback = new Image("bckgrnd.jpg");
    private FlowPane dices = new FlowPane(Orientation.HORIZONTAL);

    @Override
    public void start(Stage primaryStage) {

        User user = new User();
        User computer = new User();
        boolean userTurn = true;
        PointCounter pointCounter = new PointCounter();

        Dice dice1 = new Dice(0, false);
        Dice dice2 = new Dice(0, false);
        Dice dice3 = new Dice(0, false);
        Dice dice4 = new Dice(0, false);
        Dice dice5 = new Dice(0, false);

        //Schemat rundy:

        //RZUT [BUTTON]:
        dice1.rollTheDice();
        dice2.rollTheDice();
        dice3.rollTheDice();
        dice4.rollTheDice();
        dice5.rollTheDice();

        //count the points
        pointCounter.rollTheDicePointCounter(user);

        //KLIKNIECIE W JEDNĄ Z KOSCI [button]
        dice1.selectDice();

        ArrayList<Integer> dicesList = new ArrayList<Integer>();
        dicesList.add(dice1.getValue());
        dicesList.add(dice2.getValue());
        dicesList.add(dice3.getValue());
        dicesList.add(dice4.getValue());
        dicesList.add(dice5.getValue());

        //Kolejna runda
        //NIEKLIKNIĘCIE W KOSC - KLIKNIECIE W ROLL THE DICE [ button ]
        dice1.rollTheDice();
        dice2.rollTheDice();
        dice3.rollTheDice();
        dice4.rollTheDice();
        dice5.rollTheDice();

        dicesList.clear();
        dicesList.add(dice1.getValue());
        dicesList.add(dice2.getValue());
        dicesList.add(dice3.getValue());
        dicesList.add(dice4.getValue());
        dicesList.add(dice5.getValue());

        //PO RZUCIE: automatyczne wyliczanie punktów z wykorzystaniem metod z klasy User - PointCounter
        pointCounter.rollTheDicePointCounter(user);
        //...

        //MOŻLIWOŚCI RZUTU USERA:
        user.userPossibilities.put("acesPoints",true);
        user.userPossibilities.put("twosPoints",true);
        user.userPossibilities.put("threesPoints",true);
        //PUNKTACJA USERA:
        user.userResult.put("acesPoints", 0);
        user.userResult.put("twosPoints", 0);
        user.userResult.put("threesPoints", 0);
        //...

        HashMap<String, Boolean> computerPossibilities = new HashMap<String, Boolean>();
        computerPossibilities.put("acesPoints", true);
        //..



        //...

        HashMap<String, Integer> computerResult = new HashMap<String, Integer>();
        computerResult.put("acesPoints", 0);
        //...


        /*TABELA (GRAFICZNA)
                   user   					computer
        ACES		| userResult.get("acesPoints");		| computerResult.get("acesPoints");
        TWOS		| userResult.get("twosPoints");		| computerResult.get("twosPoints");
        THREES 		| userResult.get("threesPoints");	| computerResult.get("threesPoints");
        ..
        TOPSCORE 	    | topScore(userResult);			| topScore(computerResult);
        BOTTOMSCORE 	| bottomScore(userResult);		| bottomScore(computerResult);
        TOTALSCORE  	| totalScore(userResult);		| totalScore(computerResult);

        */





        /*PUNKTACJA KOMPUTERA
        losowanie któregoś z poniższych układów 1-13 i następnie losowanie możliwej punktacji w danym układzie.
        układ nie może być wcześniej wcześniej wybrany:  if (computerPossibilities.get(..))

        1.countAces - 1-2-3-4-5
        3.countTwos - 2-4-6-8-10
        2.countThrees - 3-6-9-12-15
        4.countFours - 4-8-12-16-20
        5.countFives - 5-10-15-20-25
        6.countSixes - 6-12-18-24-30-36

        7.countThreeOfAKind - (3||6||9||12|15|18) + 2-12
        8.countFourOfAKind - (4||8||12||16||20||30) + 1-6
        9.countFullHouse - 25 || 0 (50% szans)
        10.countSmallStraight - 30 || 0 (50% szans)
        11.countLargeStraight - 40 || 0 || 0 (mała szansa)
        12.count5Dice - 50 || 0 || O (najmniejsza szansa)
        13.countChance - 5 - 30

        po wylosowaniu następuje:

        computerResult.replace(..,...);
        computerPossibilities.replace(..,false);
        userTurn = true;
        */

            }


    public static void main(String[] args) {
        launch(args);
    }
}
