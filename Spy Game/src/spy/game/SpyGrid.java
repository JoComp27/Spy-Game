/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy.game;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author Administrateur
 */
public class SpyGrid extends GridPane {
    
   public  SpyGrid(Map map){
        super();
        updateSpyGrid(map);
    }
   
   public void updateSpyGrid(Map map){
       this.getChildren().clear();
       for(int i = 0; i < map.getYMax(); i++){
           for(int j = 0; j < map.getXMax(); j++){
               
               this.add(new Text(Character.toString(map.getMap()[j][i])), j, i);
           }
       }
   }

}
