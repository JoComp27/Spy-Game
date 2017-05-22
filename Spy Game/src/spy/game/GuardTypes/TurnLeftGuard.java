/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy.game.GuardTypes;

import spy.game.Direction;
import spy.game.Guard;
import spy.game.Map;

/**
 *
 * @author Administrateur
 */
public class TurnLeftGuard extends Guard{
    
    public TurnLeftGuard(int x, int y, Direction direction, int sightLenght){
        this.position[0] = x;
        this.position[1] = y;
        this.direction = direction;
        this.sightLenght = sightLenght;
        
    }
    
    @Override
    public void getBehavior(Map map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
