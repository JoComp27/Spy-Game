/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy.game;

import java.util.Scanner;

/**
 *
 * @author Administrateur
 */
public class GameManager {
    
   private int score;
   private int turnsLeft;
   private Map map;
   
   Scanner input = new Scanner(System.in);
   
    public GameManager(){
        
    }
    
    public GameManager(Map map, int turnsLeft){
        this.map = map;
        this.turnsLeft = turnsLeft;
    }
    
    public int getTurnsLeft(){
        return turnsLeft;
    }
    
    public void update(){
        for(int i = 0; i < map.getNumOfGuards(); i++){
            map.getGuardList()[i].getBehavior(map);
        }
        System.out.println("Turns left : " + turnsLeft);
        map.RenderMap();
        turnsLeft--;
    }
    
}
