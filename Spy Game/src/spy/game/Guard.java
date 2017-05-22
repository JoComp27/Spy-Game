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

public abstract class Guard {
    public int[] position = new int[2];
    public int sightLenght;
    
    public Direction direction;
    
    public abstract void getBehavior(Map map);
    
}
