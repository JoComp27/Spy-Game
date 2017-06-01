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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import spy.game.GuardTypes.VerticalGuard;

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
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        
        int xMax = 10;
        int yMax = 10;
        char[][] a = new char[xMax][yMax];
        for(int i = 0; i < xMax; i++){
            for(int j = 0; j < yMax; j++){
                if(j == 0 || j == 9 || i == 0 || i == 9){
                    a[i][j] = 'X';
                }
                else{
                    a[i][j] = ' ';
                }
            }
        }
        
       Guard[] guardArray = new Guard[1];
       guardArray[0] = new VerticalGuard(2, 2, Direction.DOWN,2);
       
        Map map = new Map(xMax, yMax, a, 1,guardArray);
        
        GameManager gm = new GameManager(map, 500);
        
        while(gm.getTurnsLeft() > 0){
            gm.update();
        }
        
    }
    
}
