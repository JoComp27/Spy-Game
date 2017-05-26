/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy.game;

/**
 *
 * @author Administrateur
 */
public class GameManager {
    
   private int score;
   private int turnsLeft;
   private Map map;
   
    public GameManager(){
        
    }
    
    public GameManager(Map map, int turnsLeft){
        this.map = map;
        this.turnsLeft = turnsLeft;
    }
    
}
