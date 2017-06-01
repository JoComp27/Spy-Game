/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy.game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import spy.game.GuardTypes.HorizontalGuard;
import spy.game.GuardTypes.TurnLeftGuard;
import spy.game.GuardTypes.TurnRightGuard;
import spy.game.GuardTypes.VerticalGuard;
import spy.game.Maps.Map1;

/**
 *
 * @author Administrateur
 */

public class SpyGame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        BorderPane root = new BorderPane();
        HBox test = new HBox();
        
        test.getChildren().add(btn);
        root.setTop(test);
        
        
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        /*
        Map1 map1 = new Map1();
        
        GameManager gm = new GameManager(map1.getMap(), 500);
        
        while(gm.getTurnsLeft() > 0){
            gm.update();
        }
        */
    }
    
}
