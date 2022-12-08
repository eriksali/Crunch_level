package csi2300;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class App extends Application {

    private int gameSize;
    //private Scene gameScene;

    @Override 

    public void start(Stage primaryStage) {

        gameSize = 5;
        VBox gameStartPane = new VBox(10);
        gameStartPane.setAlignment(Pos.CENTER);
        HBox hBoxStartButtons = new HBox(10);
        hBoxStartButtons.setAlignment(Pos.CENTER);
        Button btnExit = new Button("Exit");
        Button btnStartGame = new Button("Start");
        hBoxStartButtons.getChildren().addAll(btnStartGame, btnExit);
        HBox hBoxGameOptions = new HBox(10);
        hBoxGameOptions.setAlignment(Pos.CENTER);
        Spinner<Integer> startGameSize = new Spinner<>(1, 100, gameSize, 1);
        hBoxGameOptions.getChildren().addAll(new Label("Game Level:"), startGameSize);
        gameStartPane.getChildren().addAll(new Label("Calculation Crunch"), new Label(""), hBoxGameOptions, hBoxStartButtons);

        gameStartPane.setAlignment(Pos.CENTER);
        Scene startGameScene = new Scene(gameStartPane, 300, 150);

        btnExit.setOnAction(e -> {
            primaryStage.close();
        });

        btnStartGame.setOnAction(e -> {
            gameSize = startGameSize.getValue();

            Pane pane = new Pane();
            Label question = new Label("");
            Label answer = new Label();

            Text flag = new Text();
            TextField result = new TextField();

            GamePane gamepane = new GamePane(result, answer, question, flag, gameSize);

            Scene gameScene = new Scene(pane, 600, 600);
            
            primaryStage.setScene(gameScene);

            gamepane.loadText(pane);
            gamepane.submitBtn(pane);
            gamepane.renewBtn(pane);
            gamepane.exitBtn(pane, primaryStage);
        });


        primaryStage.setTitle("Space game!");
        primaryStage.setScene(startGameScene);
        primaryStage.show();
        
    }

    public static void main(String[] args){
        launch(args);
    }

}


