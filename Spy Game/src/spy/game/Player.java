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
public class Player {
    public int[] position = {1,1};
    
    Player(){}
    
    public Player(int[] position){
        this.position = position;
    }
    
    public int getX(){
        return position[1];
    }
    
    public int getY(){
        return position[0];
    }
    
    public void GoUp(Map map){
        if(map.getMap()[position[1]-1][position[0]] != 'X'){
        position[1] -= 1;
        }
        else{
            sayRunningInWall();
        }
    }
    
    public void GoDown(Map map){
        if(map.getMap()[position[1]+1][position[0]] != 'X'){
            position[1] += 1;
        }
            else{
                    sayRunningInWall();
                    }
        
    }
    
    public void GoLeft(Map map){
        if(map.getMap()[position[1]][position[0]-1] != 'X'){
            position[0] -= 1;
        }
            else{
                    sayRunningInWall();
                    }
        
    }
    public void GoRight(Map map){
        if(map.getMap()[position[1]][position[0]+1] != 'X'){
            position[0] += 1;
        }
            else{
                    sayRunningInWall();
                    }
        
    }
    
    
    private void sayRunningInWall(){
        System.out.println("Player is running in a wall");
    }
    
}
