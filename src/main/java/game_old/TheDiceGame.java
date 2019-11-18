package game_old;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TheDiceGame extends Application {

    private Dice dice1 = new Dice(new Image("dices/dice_1.png", 105, 105, true, true));
    private Dice dice2 = new Dice(new Image("dices/dice_2.png", 105, 105, true, true));
    private Dice dice3 = new Dice(new Image("dices/dice_3.png", 105, 105, true, true));
    private Dice dice4 = new Dice(new Image("dices/dice_4.png", 105, 105, true, true));
    private Dice dice5 = new Dice(new Image("dices/dice_5.png", 105, 105, true, true));
    private Dice dice6 = new Dice(new Image("dices/dice_6.png", 105, 105, true, true));

    private Image imageback = new Image("bckgrnd.jpg");

    private FlowPane dices = new FlowPane(Orientation.HORIZONTAL);

    @Override
    public void start(Stage primaryStage) {

        BackgroundSize backgroundSize = new BackgroundSize(1600, 900, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.setBackground(background);

        ImageView img = new ImageView(dice1.getDice());
        ImageView img2 = new ImageView(dice2.getDice());
        ImageView img3 = new ImageView(dice3.getDice());
        ImageView img4 = new ImageView(dice4.getDice());
        ImageView img5 = new ImageView(dice5.getDice());
        ImageView img6 = new ImageView(dice6.getDice());

        dices.getChildren().add(img);
        dices.getChildren().add(img2);
        dices.getChildren().add(img3);
        dices.getChildren().add(img4);
        dices.getChildren().add(img5);
        dices.getChildren().add(img6);

        Button newbtn = new Button();

        newbtn.setText("Nowy rzut");
        newbtn.setOnAction((e) -> {
            dices.getChildren().removeAll(dices.getChildren());
        });


        grid.add(dices, 0, 6, 6, 1);
        grid.add(newbtn, 0, 5);

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        primaryStage.setTitle("The Dice Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}