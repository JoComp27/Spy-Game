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
public class VerticalGuard extends Guard{

    
    public VerticalGuard(int x, int y, Direction direction, int sightLenght){
        this.position[0] = x;
        this.position[1] = y;
        this.direction = direction;
        this.sightLength = sightLenght;
    }
    
    @Override
    public void getBehavior(Map map) {
        if(position[1] == 0){
            position[1]+=1;
            this.direction = Direction.DOWN;
        }
        else if(position[1]+1 == map.getYMax()){
            position[1] -= 1;
            this.direction = Direction.UP;
        }
        else{
        if(this.direction == Direction.DOWN){
            position[1] += 1;
        }
        else{
            position[1] -= 1;
        }
    }
    }
    
}
