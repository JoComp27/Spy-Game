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
public class Map {
    private int xMax;
    private int yMax;
    private char[][] map;
    public Map(int xMax, int yMax, char[][] map){
        this.map = map;
        this.xMax = xMax;
        this.xMax = xMax;
    }
    
    public int getXMax(){
        return xMax;
    }
    
    public int getYMax(){
        return yMax;
    }
    
    public void setMap(char[][] map){
        this.map = map;
    }
    
    public char[][] getMap(){
        return this.map;
    }
    
}
