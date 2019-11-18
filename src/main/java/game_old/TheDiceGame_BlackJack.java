package game_old;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TheDiceGame_BlackJack extends Application {

    private Image imageback = new Image("bckgrnd.jpg");
    private Card aceClub = new Card(new Image("cards/AC.png",69,105,true,true));
    private Card aceDiamond = new Card(new Image("cards/AD.png",69,105,true,true));
    private Card aceHeart = new Card(new Image("cards/AH.png",69,105,true,true));
    private Card aceSpade = new Card(new Image("cards/AS.png",69,105,true,true));
    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);


    private Label playerLbl = new Label("Twoje karty");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        ImageView img = new ImageView(aceClub.getCard());
        ImageView img2 = new ImageView(aceDiamond.getCard());
        ImageView img3 = new ImageView(aceHeart.getCard());
        ImageView img4 = new ImageView(aceSpade.getCard());

        cards.getChildren().add(img);
        cards.getChildren().add(img2);
        cards.getChildren().add(img3);
        cards.getChildren().add(img4);

        Button newbtn = new Button();
        newbtn.setText("Nowe rozdanie");
        newbtn.setOnAction((e) -> {
            cards.getChildren().removeAll(cards.getChildren());
        });

        playerLbl.setTextFill(Color.web("#FFF"));
        playerLbl.setFont(new Font("Arial", 24));

        grid.add(cards, 0, 0, 3, 1);
        grid.add(playerLbl, 0, 4);
        grid.add(newbtn,0,5);

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        primaryStage.setTitle("The Dice Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}